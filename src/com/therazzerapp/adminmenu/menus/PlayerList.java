package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 21:52 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class PlayerList {

    public static ChatComponent getBody(String tooltip, String command,Player player, LocaleHelper translator){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");
        String komma;
        int counter = 0;
        for (Player p : Canary.getServer().getPlayerList()) {

            counter++;
            komma = ", ";
            if(counter >= Canary.getServer().getPlayerList().size()){
                komma = "";
            }

            ChatComponent cCPlayerText = f.newChatComponent(p.getName() + komma);

            if (p.isOperator() || p.hasPermission("adminmenu.isadmin")) {
                cCPlayerText.getChatStyle().setColor(f.colorRed());
            } else {
                cCPlayerText.getChatStyle().setColor(f.colorYellow());
            }

            if(p == player){
                cCPlayerText.getChatStyle().setColor(f.colorDarkRed());
            }

            cCPlayerText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" +p.getName())));

            if(AdminMenu.settings.isPlayerInfos()){
                cCPlayerText.getChatStyle().getChatHoverEvent().getValue()
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_world", player.getLocale()) + " §f" + p.getWorld().getName()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_group", player.getLocale()) + " §f" + p.getGroup().getName()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_ip",player.getLocale()) + " §f" + p.getIP()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_locale",player.getLocale()) + " §f" + p.getLocale()));
            }
            cCPlayerText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%p" , p.getName())));

            cCText.appendSibling(cCPlayerText);
        }
        return cCText;
    }
}
