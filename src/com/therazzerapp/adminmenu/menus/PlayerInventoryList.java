package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.inventory.Item;

import java.util.Arrays;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 19:28 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class PlayerInventoryList {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        String[] playerName = command.split(" ");

        System.out.println(Arrays.toString(playerName));

        if (playerName.length >= 5){

            Player player = Canary.getServer().getPlayer(playerName[4]);
            for(int x=0;x < player.getInventory().getSize();x++){

                Item item = player.getInventory().getSlot(x);
                if (item != null) {
                    ChatComponent groupText = f.newChatComponent("- " + item.getDisplayName() + " Amount: " + item.getAmount() + "\n");

                    groupText.getChatStyle().setColor(f.colorYellow());

                    HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip));
                    groupText.getChatStyle().setChatHoverEvent(hoverEvent);

                    String com = command.replaceFirst("%pi", "" + item.getType().getMachineName() + " " + item.getType().getData());

                    ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + com);
                    groupText.getChatStyle().setChatClickEvent(clickEvent);

                    text.appendSibling(groupText);
                }
            }

        } else {
            text.appendText("ERROR No player named");
        }

        return text;
    }
}
