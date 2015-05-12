package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.world.World;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 12/05/2015
 * Time: 20:11 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class WorldList {
    public static ChatComponent getBody(String tooltip, String command){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (World w : Canary.getServer().getWorldManager().getAllWorlds()) {

            ChatComponent temp = f.newChatComponent(w.getName() + ",");

            if(w.getPlayerList().isEmpty()){
                temp.getChatStyle().setColor(f.colorGreen());
            } else {
                temp.getChatStyle().setColor(f.colorRed());
            }

            temp.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));

            String com  = command.replaceFirst("%wo" , w.getName());


            temp.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + com));

            text.appendSibling(temp);

        }
        return text;
    }
}
