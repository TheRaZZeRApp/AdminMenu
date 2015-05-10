package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.factory.ChatComponentFactory;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 19:33 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class WhiteList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (String uuid : Canary.whitelist().getWhitelisted()) {
            PlayerReference reference = Canary.getServer().matchKnownPlayer(uuid);
            if (reference != null) {

                ChatComponent whitelistText = f.newChatComponent(reference.getName() + ", ");

                whitelistText.getChatStyle().setColor(f.colorYellow());
                HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
                whitelistText.getChatStyle().setChatHoverEvent(hoverEvent);

                String com  = command.replaceFirst("%w" , reference.getName());

                ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
                whitelistText.getChatStyle().setChatClickEvent(clickEvent);

                text.appendSibling(whitelistText);

            } else {
                ChatComponent whitelistText = f.newChatComponent("Unknown, ");
                whitelistText.getChatStyle().setColor(f.colorYellow());
                HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(uuid));
                whitelistText.getChatStyle().setChatHoverEvent(hoverEvent);

                String com  = command.replaceFirst("%w" , uuid);

                ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
                whitelistText.getChatStyle().setChatClickEvent(clickEvent);

                text.appendSibling(whitelistText);
            }
        }
        return text;
    }
}
