package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 21:52 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class PlayerList {

    public static ChatComponent getBody(String tooltip, String command){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (Player p : Canary.getServer().getPlayerList()) {

            ChatComponent playerText = f.newChatComponent(p.getName() + ",");

            if (p.isOperator() || p.hasPermission("adminmenue.admin")) {
                playerText.getChatStyle().setColor(f.colorRed());
            } else {
                playerText.getChatStyle().setColor(f.colorGreen());
            }

            playerText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));

            String com  = command.replaceFirst("%p" , p.getName());

            playerText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + com));

            text.appendSibling(playerText);

        }
        return text;
    }
}
