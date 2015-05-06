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
 * Time: 19:31 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class TimeList00 {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (int x = 1; x <= 12;x++) {
            String amount = "0 min";
            ChatComponent amountText = f.newChatComponent("");
            amountText.getChatStyle().setColor(f.colorYellow());
            switch (x){
                case 1:
                    amountText.appendText("1 Year");
                    amount = "12 mo";
                    break;
                case 2:
                    amountText.appendText("6 Months");
                    amount = "6 mo";
                    break;
                case 3:
                    amountText.appendText("1 Moth");
                    amount = "1 mo";
                    break;
                case 4:
                    amountText.appendText("2 Weeks");
                    amount = "2 w";
                    break;
                case 5:
                    amountText.appendText("1 Week");
                    amount = "1 w";
                    break;
                case 6:
                    amountText.appendText("3 Days");
                    amount = "3 d";
                    break;
                case 7:
                    amountText.appendText("1 Day");
                    amount = "1 d";
                    break;
                case 8:
                    amountText.appendText("12 Hours");
                    amount = "12 h";
                    break;
                case 9:
                    amountText.appendText("1 Hour");
                    amount = "1 h";
                    break;
                case 10:
                    amountText.appendText("30 Minutes");
                    amount = "30 min";
                    break;
                case 11:
                    amountText.appendText("5 Minute");
                    amount = "5 min";
                    break;
                case 12:
                    amountText.appendText("1 Minute");
                    amount = "1 min";
                    break;
            }

            amountText.appendText("\n");

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            amountText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%t1" , ""+amount);

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            amountText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(amountText);
        }

        return text;
    }
}
