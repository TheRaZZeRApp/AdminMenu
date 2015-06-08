package de.therazzerapp.adminmenu.menus;

import de.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.statistics.Achievements;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 14:14 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class AchievementList {
    public static ChatComponent getBody(String tooltip, String command){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        int counter = 0;
        for (Achievements a : Achievements.values()){

            counter++;
            ChatComponent cCAchievementList;

            if (counter %2 == 0){
                cCAchievementList = f.newChatComponent(a.name().toLowerCase() + "\n");
            } else {
                cCAchievementList = f.newChatComponent("- " + a.name().toLowerCase() + ",  ");
            }

            cCAchievementList.getChatStyle().setColor(f.colorYellow());
            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCAchievementList.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + a.name().toLowerCase())));
            }
            cCAchievementList.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%ac", a.getNativeName())));
            cCText.appendSibling(cCAchievementList);

        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        if(counter %2 == 0){
            cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        }
        return cCText;
    }
}
