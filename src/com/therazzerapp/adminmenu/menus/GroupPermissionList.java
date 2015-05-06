package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.permissionsystem.PermissionNode;
import net.canarymod.user.Group;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 14:32 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class GroupPermissionList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        String[] temp = command.split(" ");
        String groupName = temp[6];
        Group group = Canary.usersAndGroups().getGroup(groupName);

        for (PermissionNode permission : group.getPermissionProvider().getPermissionMap()) {

            ChatComponent groupText = f.newChatComponent("- " + permission.getFullPath() + "\n");
            groupText.getChatStyle().setColor(f.colorYellow());

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            groupText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%pg" , permission.getFullPath());

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            groupText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(groupText);
        }

        return text.appendText("\n");
    }
}
