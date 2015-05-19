package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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
        ChatComponent cCText = f.newChatComponent("");

        int counter = 0;
        int counter2 = 0;


        for (SoundEffect.Type type : SoundEffect.Type.values()){
            counter2++;

            ChatComponent cCSoundText;

            if (counter == 0){
                cCSoundText = f.newChatComponent("- " + type.name().toLowerCase() + "   ");
                counter = 1;
            } else if (counter == 1){
                cCSoundText = f.newChatComponent(type.name().toLowerCase() + "   ");
                counter = 2;
            } else {
                cCSoundText = f.newChatComponent(type.name().toLowerCase() + "\n");
                counter = 0;
            }

            cCSoundText.getChatStyle().setColor(f.colorYellow());
            cCSoundText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + type.name().toLowerCase())));
            cCSoundText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%so", ""+type.getMcName())));

            cCText.appendSibling(cCSoundText);

            if (counter2 >= 120 && counter != 0){
                cCText.appendText("\n");
                return cCText;
            }

        }
        return cCText;
    }
}
