package com.therazzerapp.adminmenu.menus;

/*
 * Project: AdminMenu
 * User: Sonny
 * Date: 19/05/2015
 * Time: 11:01 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: e-mail@therazzerapp.com
 */

import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.config.ConfigSection;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;

import java.io.File;

public class ReasonList {
    public static ChatComponent getBody(String tooltip, String command, Player player) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(new File("./config/AdminMenu/ATL/reasonList.json"));

        String[] reasons = root.getStringArray("reasons_" + player.getLocale());
        if(reasons.length == 0){
            reasons = root.getStringArray("reasons");
        }

        ChatComponent cCReasonText;
        for (String reason : reasons) {

            cCReasonText = f.newChatComponent("- " + reason);

            cCReasonText.getChatStyle().setColor(f.colorYellow());
            cCReasonText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(),"/" + command.replaceFirst("%re" , ""+reason)));
            cCReasonText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(tooltip)));
            cCText.appendSibling(cCReasonText);
            cCText.appendText("\n");
        }
        return cCText;
    }
}
