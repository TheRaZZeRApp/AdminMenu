package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.bansystem.Ban;

/**
 * Project: AdminMenu
 * User: Sonny
 * Date: 12/05/2015
 * Time: 08:55 PM
 * Package: com.therazzerapp.adminmenu.menus
 */
public class BannedPlayerList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (Ban ban : Canary.bans().getAllBans()) {

            ChatComponent reserveText = f.newChatComponent(ban.getSubject() + ", ");

            reserveText.getChatStyle().setColor(f.colorYellow());
            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            reserveText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%bp" , ban.getSubject());

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            reserveText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(reserveText);
        }
        return text;
    }
}
