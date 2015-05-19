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
        for (PotionEffectType p : PotionEffectType.values()){
            
            ChatComponent cCEffectText;
            counter++;

            if (counter %2 == 0){
                cCEffectText = f.newChatComponent(p.name().toLowerCase());
            } else {
                cCEffectText = f.newChatComponent("- " + p.name().toLowerCase() + "   ");
            }

            cCEffectText.getChatStyle().setColor(f.colorYellow());
            cCEffectText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + p.name().toLowerCase())));
            cCEffectText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%ef", ""+p.getID())));

            cCText.appendSibling(cCEffectText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        if(counter %2 != 0){
            cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        }
        return cCText;
    }
}
