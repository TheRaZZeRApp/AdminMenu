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
 * Time: 19:32 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class TimeList01 {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (int x = 1; x <= 12;x++) {
            int amount = 0;
            ChatComponent amountText = f.newChatComponent("");
            amountText.getChatStyle().setColor(f.colorYellow());
            switch (x){
                case 1:
                    amountText.appendText("Clear");
                    amount = 0;
                    break;
                case 2:
                    amountText.appendText("1 Day");
                    amount = 86400;
                    break;
                case 3:
                    amountText.appendText("5 Hours");
                    amount = 18000;
                    break;
                case 4:
                    amountText.appendText("2 Hours");
                    amount = 7200;
                    break;
                case 5:
                    amountText.appendText("1 Hour");
                    amount = 3600;
                    break;
                case 6:
                    amountText.appendText("30 Minutes");
                    amount = 1800;
                    break;
                case 7:
                    amountText.appendText("15 Minutes");
                    amount = 900;
                    break;
                case 8:
                    amountText.appendText("10 Minutes");
                    amount = 600;
                    break;
                case 9:
                    amountText.appendText("5 Minutes");
                    amount = 300;
                    break;
                case 10:
                    amountText.appendText("1 Minute");
                    amount = 60;
                    break;
                case 11:
                    amountText.appendText("30 Sec");
                    amount = 30;
                    break;
                case 12:
                    amountText.appendText("10 Sec");
                    amount = 10;
                    break;
            }

            amountText.appendText("\n");

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            amountText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%t2" , ""+amount);

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            amountText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(amountText);
        }

        return text;
    }
}
