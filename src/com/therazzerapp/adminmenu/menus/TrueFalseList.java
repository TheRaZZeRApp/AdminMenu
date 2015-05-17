package com.therazzerapp.adminmenu.menus;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
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
        ChatComponent text = f.newChatComponent("");

        for (int x = 0; x <= 1;x++) {
            String amount = "";
            ChatComponent amountText = f.newChatComponent("");
            amountText.getChatStyle().setColor(f.colorYellow());
            switch (x){
                case 0:
                    amountText.appendText(translator.localeTranslate("extras_true",player.getLocale()) + "\n");
                    amount = "true";
                    break;
                case 1:
                    amountText.appendText(translator.localeTranslate("extras_false",player.getLocale()));
                    amount = "false";
                    break;
            }

            amountText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip)));
            amountText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%tf" ,amount)));
            text.appendSibling(amountText);
        }
        return text;
    }
}
