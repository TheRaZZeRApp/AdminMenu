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
 * Time: 14:26 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class AmountList01 {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(new File("./config/AdminMenu/ATL/amountList01.json"));

        String[] amounts = root.getStringArray("amounts");
        ChatComponent cCAmountText;
        for (String amount : amounts) {

            cCAmountText = f.newChatComponent("- " + amount);

            if (amount.equalsIgnoreCase("complete")){
                amount = "";
            }

            cCAmountText.getChatStyle().setColor(f.colorYellow());
            cCAmountText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(),"/" + command.replaceFirst("%a1" , ""+amount)));
            cCAmountText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(tooltip)));
            cCText.appendSibling(cCAmountText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
