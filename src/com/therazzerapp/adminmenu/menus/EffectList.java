package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.potion.PotionEffectType;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 14:29 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class EffectList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        int counter = 0;

        for (PotionEffectType type : PotionEffectType.values()){

            ChatComponent amountText;

            if (counter == 0){
                amountText = f.newChatComponent("- " + type.name().toLowerCase() + "   ");
                counter = 1;
            } else {
                amountText = f.newChatComponent(type.name().toLowerCase() + "\n");
                counter = 0;
            }

            amountText.getChatStyle().setColor(f.colorYellow());

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + type.name().toLowerCase()));
            amountText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com = command.replaceFirst("%ef", ""+type.getID());

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            amountText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(amountText);

        }
        return text;
    }
}
