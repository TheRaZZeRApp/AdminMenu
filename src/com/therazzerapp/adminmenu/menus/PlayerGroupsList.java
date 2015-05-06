package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.user.Group;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 19:27 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class PlayerGroupsList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        String[] playerName = command.split(" ");

        if (playerName.length >= 6){
            for (Group group : Canary.getServer().getPlayer(playerName[5]).getPlayerGroups()) {

                ChatComponent groupText = f.newChatComponent("- " + group.getName() + "\n");

                groupText.getChatStyle().setColor(f.colorYellow());

                HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
                groupText.getChatStyle().setChatHoverEvent(hoverEvent);

                String com  = command.replaceFirst("%gp" , group.getName());

                ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
                groupText.getChatStyle().setChatClickEvent(clickEvent);

                text.appendSibling(groupText);
            }
        } else {
            text.appendText("ERROR No player named");
        }

        return text.appendText("\n");
    }
}