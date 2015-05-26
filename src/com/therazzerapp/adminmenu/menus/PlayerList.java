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

        for (Player p : Canary.getServer().getPlayerList()) {
            ChatComponent cCPlayerText = f.newChatComponent(p.getName());

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
                        .appendSibling(f.newChatComponent("\n§f" + translator.localeTranslate("atl_p_world", player.getLocale()) + " §a" + p.getWorld().getName()))
                        .appendSibling(f.newChatComponent("\n§f" + translator.localeTranslate("atl_p_group", player.getLocale()) + " §a" + p.getGroup().getName()))
                        .appendSibling(f.newChatComponent("\n§f" + translator.localeTranslate("atl_p_ip",player.getLocale()) + " §a" + p.getIP()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_locale",player.getLocale()) + " §a" + p.getLocale()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_firstseen",player.getLocale()) + " §a" + p.getFirstJoined().replaceAll("-",".")))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_lastseen",player.getLocale()) + " §a" + p.getLastJoined().replaceAll("-",".")));
            }

            cCPlayerText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%p" , p.getName())));

            cCText.appendSibling(cCPlayerText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
