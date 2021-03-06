package de.therazzerapp.adminmenu.menus;

import de.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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
        ChatComponent cCText = f.newChatComponent("");

        String[] playerName = command.split(" ");

        if (playerName.length >= 7){
            for (Group group : Canary.getServer().getPlayer(playerName[6]).getPlayerGroups()) {
                ChatComponent cCGroupText = f.newChatComponent("- " + group.getName());

                cCGroupText.getChatStyle().setColor(f.colorYellow());
                if(!AdminMenu.settings.isDisableHoverInfos()) {
                    cCGroupText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));
                }
                cCGroupText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%gp" , group.getName())));

                cCText.appendSibling(cCGroupText);
                cCText.appendText("\n");
            }
        } else {
            cCText.appendText("ERROR No player named");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
