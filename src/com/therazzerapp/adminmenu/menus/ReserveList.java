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
 * Time: 19:30 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class ReserveList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (String uuid : Canary.reservelist().getReservations()) {
            PlayerReference reference = Canary.getServer().matchKnownPlayer(uuid);
            if (reference != null) {

                ChatComponent reserveText = f.newChatComponent(reference.getName() + ", ");

                reserveText.getChatStyle().setColor(f.colorYellow());
                HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
                reserveText.getChatStyle().setChatHoverEvent(hoverEvent);

                String com  = command.replaceFirst("%r" , reference.getName());

                ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
                reserveText.getChatStyle().setChatClickEvent(clickEvent);

                text.appendSibling(reserveText);

            } else {
                ChatComponent reserveText = f.newChatComponent("Unknown, ");
                reserveText.getChatStyle().setColor(f.colorYellow());
                HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(uuid));
                reserveText.getChatStyle().setChatHoverEvent(hoverEvent);

                String com  = command.replaceFirst("%r" , uuid);

                ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
                reserveText.getChatStyle().setChatClickEvent(clickEvent);

                text.appendSibling(reserveText);
            }
        }
        text.appendText("\n");

        return text;
    }
}
