package de.therazzerapp.adminmenu.menus;

import de.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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
        ChatComponent cCText = f.newChatComponent("");

        String[] temp = command.split(" ");
        Group group = Canary.usersAndGroups().getGroup(temp[7]);

        for (PermissionNode permission : group.getPermissionProvider().getPermissionMap()) {

            ChatComponent cCGroupText = f.newChatComponent("- " + permission.getFullPath());

            cCGroupText.getChatStyle().setColor(f.colorYellow());
            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCGroupText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));
            }
            cCGroupText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%pg" , permission.getFullPath())));

            cCText.appendSibling(cCGroupText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
