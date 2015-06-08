package de.therazzerapp.adminmenu.menus;

import de.therazzerapp.adminmenu.AdminMenu;
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
 * Time: 19:31 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class TimeList00 {
    public static ChatComponent getBody(String tooltip, String command) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(new File("./config/AdminMenu/ATL/timeList.json"));

        for (ConfigSection time : root.getConfigSectionArray("time_00")) {
            ChatComponent cCTimeText = f.newChatComponent("- " + time.getString("item"));
            cCTimeText.getChatStyle().setColor(f.colorYellow());
            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCTimeText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));
            }
            cCTimeText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%t1" , time.getString("value"))));

            cCText.appendSibling(cCTimeText);
            cCText.appendText("\n");
        }

        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
