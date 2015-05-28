package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 19:32 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class TrueFalseList {
    public static ChatComponent getBody(String tooltip, String command,Player player,LocaleHelper translator) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        for (int x = 0; x <= 1;x++) {
            String amount = "";
            ChatComponent cCBooleanText = f.newChatComponent("");
            cCBooleanText.getChatStyle().setColor(f.colorYellow());
            switch (x){
                case 0:
                    cCBooleanText.appendText(translator.localeTranslate("extras_true",player.getLocale()) + "\n");
                    amount = "true";
                    break;
                case 1:
                    cCBooleanText.appendText(translator.localeTranslate("extras_false",player.getLocale()));
                    amount = "false";
                    break;
            }

            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCBooleanText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));
            }
            cCBooleanText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%tf" ,amount)));
            cCText.appendSibling(cCBooleanText);
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        return cCText;
    }
}
