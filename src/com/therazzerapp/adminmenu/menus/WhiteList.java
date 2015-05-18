package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.PlayerReference;
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
 * Time: 19:33 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class WhiteList {
    public static ChatComponent getBody(String tooltip, String command, Player player, LocaleHelper translator) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        int counter = 0;
        String komma = ",";
        for (String uuid : Canary.whitelist().getWhitelisted()) {

            counter++;
            if(counter >= Canary.whitelist().getWhitelisted().length){
                komma = "";
            }


            PlayerReference reference = Canary.getServer().matchKnownPlayer(uuid);

            if (reference != null) {


                ChatComponent cCWhitelistText = f.newChatComponent(reference.getName() + komma);
                cCWhitelistText.getChatStyle().setColor(f.colorYellow());
                cCWhitelistText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip +  " §a" + reference.getName())));

                String online = translator.localeTranslate("extras_no",player.getLocale());
                if(reference.isOnline()){
                    online = translator.localeTranslate("extras_yes",player.getLocale());
                }

                if(AdminMenu.settings.isPlayerInfos()){
                    cCWhitelistText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_online", player.getLocale()) + " §f" + online))
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_group", player.getLocale()) + " §f" + reference.getGroup().getName()));

                    if(reference.isOnline()){
                        cCWhitelistText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_world", player.getLocale()) + " §f" + reference.getWorld().getName()))
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_ip", player.getLocale()) + " §f" + reference.getIP()));
                    }
                }

                cCWhitelistText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%w" , reference.getName())));

                cCText.appendSibling(cCWhitelistText);

            } else {


                ChatComponent cCWhitelistText = f.newChatComponent(translator.localeTranslate("atl_w_unknown", player.getLocale()) + komma);
                cCWhitelistText.getChatStyle().setColor(f.colorGold());
                HoverEvent hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent("UUID: §a" + uuid));
                cCWhitelistText.getChatStyle().setChatHoverEvent(hoverEvent);


                ClickEvent clickEvent = f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%w" , uuid));
                cCWhitelistText.getChatStyle().setChatClickEvent(clickEvent);

                cCText.appendSibling(cCWhitelistText);
            }
        }
        return cCText;
    }
}
