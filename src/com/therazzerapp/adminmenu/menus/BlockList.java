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
 * Time: 14:29 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class BlockList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        for (int x = 1; x <= 9;x++) {
            String amount = "";
            ChatComponent amountText = f.newChatComponent("");
            amountText.getChatStyle().setColor(f.colorYellow());
            switch (x){
                case 1:
                    amountText.appendText("- Stone");
                    amount = "minecraft:stone";
                    break;
                case 2:
                    amountText.appendText("- Grass");
                    amount = "minecraft:grass";
                    break;
                case 3:
                    amountText.appendText("- Dirt");
                    amount = "minecraft:dirt";
                    break;
                case 4:
                    amountText.appendText("- Cobblestone");
                    amount = "minecraft:cobblestone";
                    break;
                case 5:
                    amountText.appendText("- Oak Wood Plank");
                    amount = "minecraft:planks";
                    break;
                case 6:
                    amountText.appendText("- Oak Wood");
                    amount = "minecraft:log";
                    break;
                case 7:
                    amountText.appendText("- Glass");
                    amount = "minecraft:glass";
                    break;
                case 8:
                    amountText.appendText("- White Wool");
                    amount = "minecraft:wool";
                    break;
                case 9:
                    amountText.appendText("- Stone Slab");
                    amount = "minecraft:stone_slab";
                    break;
            }

            amountText.appendText("\n");

            HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
            amountText.getChatStyle().setChatHoverEvent(hoverEvent);

            String com  = command.replaceFirst("%b1" , "" + amount);

            ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
            amountText.getChatStyle().setChatClickEvent(clickEvent);

            text.appendSibling(amountText);
        }

        return text;
    }
}
