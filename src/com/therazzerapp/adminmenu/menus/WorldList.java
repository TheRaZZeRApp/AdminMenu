package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.world.World;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 12/05/2015
 * Time: 20:11 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class WorldList {
    public static ChatComponent getBody(String tooltip, String command, Player player, LocaleHelper translator){

        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        int counter = 0;

        for (World w : Canary.getServer().getWorldManager().getAllWorlds()) {

            counter++;

            String newLine = "\n";
            if(counter >= Canary.getServer().getWorldManager().getAllWorlds().size()){
                newLine = "";
            }

            ChatComponent cCWorldText;
            if (player.getWorld().getName().equals(w.getName())){
                cCWorldText = f.newChatComponent("- " + w.getName() + " " + translator.localeTranslate("atl_w_currentw",player.getLocale()) + newLine);
                cCWorldText.getChatStyle().setColor(f.colorRed());
            } else {
                cCWorldText = f.newChatComponent("- " + w.getName() + newLine);
                cCWorldText.getChatStyle().setColor(f.colorYellow());
            }

            cCWorldText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(translator.localeTranslate(tooltip, player.getLocale()) + " " + w.getName())));

            if(AdminMenu.settings.isWorldInfos()){
                cCWorldText.getChatStyle().getChatHoverEvent().getValue()
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_player",player.getLocale())+ " " + w.getPlayerList().size()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_type",player.getLocale()) + " " + w.getType().getName().toLowerCase()));
            }


            cCWorldText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%wo" , w.getName()+ "_" +w.getType().getName())));

            cCText.appendSibling(cCWorldText);
        }

        return cCText;
    }
}
