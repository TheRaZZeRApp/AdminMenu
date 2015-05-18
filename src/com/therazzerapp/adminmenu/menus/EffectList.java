package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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
        ChatComponent cCText = f.newChatComponent("");

        int counter = 0;

        for (PotionEffectType type : PotionEffectType.values()){
            ChatComponent cCCmountText;

            if (counter == 0){
                cCCmountText = f.newChatComponent("- " + type.name().toLowerCase() + "   ");
                counter = 1;
            } else {
                cCCmountText = f.newChatComponent(type.name().toLowerCase() + "\n");
                counter = 0;
            }

            cCCmountText.getChatStyle().setColor(f.colorYellow());
            cCCmountText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + type.name().toLowerCase())));
            cCCmountText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%ef", ""+type.getID())));

            cCText.appendSibling(cCCmountText);
        }
        return cCText;
    }
}
