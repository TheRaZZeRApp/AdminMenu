package com.therazzerapp.adminmenu.menus;

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
        ChatComponent text = f.newChatComponent("");

        int counter = 0;

        for (World w : Canary.getServer().getWorldManager().getAllWorlds()) {

            counter++;

            String newLine = "\n";
            if(counter >= Canary.getServer().getWorldManager().getAllWorlds().size()){
                newLine = "";
            }

            ChatComponent temp;
            if (player.getWorld().getName().equals(w.getName())){
                temp = f.newChatComponent("- " + w.getName() + " " + translator.localeTranslate("atl_w_currentw",player.getLocale()) + newLine);
                temp.getChatStyle().setColor(f.colorRed());
            } else {
                temp = f.newChatComponent("- " + w.getName() + newLine);
                temp.getChatStyle().setColor(f.colorGreen());
            }

            ChatComponent cCPlayer = f.newChatComponent("\n" + translator.localeTranslate("atl_w_player",player.getLocale())+ " " + w.getPlayerList().size());
            ChatComponent cCType = f.newChatComponent("\n" + translator.localeTranslate("atl_w_type",player.getLocale()) + " " + w.getType().getName().toLowerCase());
            temp.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(translator.localeTranslate(tooltip, player.getLocale()) + " " + w.getName()).appendSibling(cCPlayer).appendSibling(cCType)));


            temp.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%wo" , w.getName()+ "_" +w.getType().getName())));

            text.appendSibling(temp);
        }

        return text;
    }
}
