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
 * Date: 19/05/2015
 * Time: 21:29 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class ItemList {
    public static ChatComponent getBody(String tooltip, String command, File file, String parameter) {

        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);

        String[] blocks = root.getStringArray("items");
        ChatComponent cCAmountText;

        for (String item : blocks) {
            cCAmountText = f.newChatComponent("- " + item.replaceFirst("minecraft:","").replaceAll("_"," "));
            cCAmountText.getChatStyle().setColor(f.colorYellow());
            cCAmountText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(),"/" + command.replaceFirst(parameter , item.replaceFirst("minecraft:","").toLowerCase())));
            cCAmountText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(tooltip + " §a" + item.replaceFirst("minecraft:","").replaceAll("_"," "))));
            cCText.appendSibling(cCAmountText);
            cCText.appendText("\n");
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
