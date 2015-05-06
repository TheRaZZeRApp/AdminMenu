package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.world.effects.SoundEffect;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 19:31 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class SoundList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        int counter = 0;
        int counter2 = 0;


        for (SoundEffect.Type type : SoundEffect.Type.values()){

            counter2++;

            ChatComponent amountText;

            if (counter == 0){
                amountText = f.newChatComponent("- " + type.name().toLowerCase() + "   ");
                counter = 1;
            } else if (counter == 1){
                amountText = f.newChatComponent(type.name().toLowerCase() + "   ");
                counter = 2;
            } else {
                amountText = f.newChatComponent(type.name().toLowerCase() + "\n");
                counter = 0;
            }

            amountText.getChatStyle().setColor(f.colorYellow());

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + type.name().toLowerCase()));
            amountText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com = command.replaceFirst("%so", ""+type.getMcName());

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            amountText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(amountText);

            if (counter2 == 120){
                text.appendText("\n");
                return text;
            }

        }
        text.appendText("\n");
        return text;
    }
}
