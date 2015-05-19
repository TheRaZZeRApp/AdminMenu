package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.inventory.Item;


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
        ChatComponent cCText = f.newChatComponent("");

        String[] parameters = command.split(" ");
        if (parameters.length >= 6){
            Player player = Canary.getServer().getPlayer(parameters[5]);
            for(int x=0;x < player.getInventory().getSize();x++){
                Item item = player.getInventory().getSlot(x);

                if (item != null) {
                    ChatComponent cCInvText = f.newChatComponent("- " + item.getDisplayName() + " Amount: §a" + item.getAmount());

                    cCInvText.getChatStyle().setColor(f.colorYellow());
                    cCInvText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));
                    cCInvText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%pi", "" + item.getType().getMachineName() + " " + item.getType().getData())));

                    cCText.appendSibling(cCInvText);
                    cCText.appendText("\n");
                }
            }
        } else {
            cCText.appendText("ERROR No player named");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
