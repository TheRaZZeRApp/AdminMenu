package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
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

public class PluginList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (String plugin : Canary.pluginManager().getPluginNames()) {

            ChatComponent reserveText = f.newChatComponent(plugin + ", ");

            reserveText.getChatStyle().setColor(f.colorYellow());
            //todo Color red=disabled green=enabled
            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            reserveText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%pl" , plugin);

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            reserveText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(reserveText);
        }

        return text;
    }
}
