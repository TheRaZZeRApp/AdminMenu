package com.therazzerapp.adminmenu.menus;

import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.config.ConfigSection;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.factory.ChatComponentFactory;

import java.io.File;


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

        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(new File("./config/AdminMenu/ATL/blockList.json"));

        String[] blocks = root.getStringArray("blocks");
        ChatComponent cCAmountText;

        for (String block : blocks) {
            cCAmountText = f.newChatComponent("- " + block.replaceFirst("minecraft:","").replaceAll("_"," "));
            cCAmountText.getChatStyle().setColor(f.colorYellow());
            cCAmountText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(),"/" + command.replaceFirst("%b1" , block.replaceFirst("minecraft:","").toLowerCase())));
            cCAmountText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(tooltip)));
            text.appendSibling(cCAmountText);
            text.appendText("\n");
        }

        return text;
    }
}
