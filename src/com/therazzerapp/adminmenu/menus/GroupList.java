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
 * Time: 14:30 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class GroupList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (Group group : Canary.usersAndGroups().getGroups()) {

            ChatComponent groupText = f.newChatComponent("- " + group.getName() + "\n");

            groupText.getChatStyle().setColor(f.colorYellow());

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            groupText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%g" , group.getName());

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            groupText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(groupText);
        }

        return text;
    }
}
