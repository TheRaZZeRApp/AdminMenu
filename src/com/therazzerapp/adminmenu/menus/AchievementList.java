package com.therazzerapp.adminmenu.menus;

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
        ChatComponent text = f.newChatComponent("");

        int counter = 0;

        for (Achievements type : Achievements.values()){

            ChatComponent amountText;

            if (counter == 0){
                amountText = f.newChatComponent("- " + type.name().toLowerCase() + "   ");
                counter = 1;
            } else {
                amountText = f.newChatComponent(type.name().toLowerCase() + "\n");
                counter = 0;
            }

            amountText.getChatStyle().setColor(f.colorYellow());

            amountText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + type.name().toLowerCase())));

            String com = command.replaceFirst("%ac", type.getNativeName());

            amountText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + com));

            text.appendSibling(amountText);
        }
        return text;
    }
}
