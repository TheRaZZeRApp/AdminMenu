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
 * Time: 14:27 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class AmountList02 {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (int x = 2; x <= 9;x++) {
            String amount = "";
            ChatComponent amountText = f.newChatComponent("");
            amountText.getChatStyle().setColor(f.colorYellow());
            switch (x){
                case 2:
                    amountText.appendText("- 127");
                    amount = "127";
                    break;
                case 3:
                    amountText.appendText("- 64");
                    amount = "64";
                    break;
                case 4:
                    amountText.appendText("- 32");
                    amount = "32";
                    break;
                case 5:
                    amountText.appendText("- 16");
                    amount = "16";
                    break;
                case 6:
                    amountText.appendText("- 8");
                    amount = "8";
                    break;
                case 7:
                    amountText.appendText("- 4");
                    amount = "4";
                    break;
                case 8:
                    amountText.appendText("- 2");
                    amount = "2";
                    break;
                case 9:
                    amountText.appendText("- 1");
                    amount = "1";
                    break;
            }

            if(x != 9){
                amountText.appendText("\n");
            }

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            amountText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com = command.replaceFirst("%a2" ,amount);

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            amountText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(amountText);
        }
        return text;
    }
}
