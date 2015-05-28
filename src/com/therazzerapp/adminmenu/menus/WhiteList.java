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

        for (String uuid : Canary.whitelist().getWhitelisted()) {

            PlayerReference reference = Canary.getServer().matchKnownPlayer(uuid);
            ChatComponent cCWhitelistText;
            HoverEvent hoverEvent;
            ClickEvent clickEvent;
            String whiteListText;

            if (reference != null) {
                whiteListText = reference.getName();
                hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip +  " §a" + reference.getName()));
                clickEvent = f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%w" , reference.getName()));

                if(AdminMenu.settings.isPlayerInfos() && !AdminMenu.settings.isDisableHoverInfos()){

                    String online = translator.localeTranslate("extras_no",player.getLocale());
                    if(reference.isOnline()){
                        online = translator.localeTranslate("extras_yes",player.getLocale());
                    }

                    hoverEvent.getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_online", player.getLocale()) + " §a" + online))
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_group", player.getLocale()) + " §a" + reference.getGroup().getName()));

                    if(reference.isOnline()){
                        hoverEvent.getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_world", player.getLocale()) + " §a" + reference.getWorld().getName()))
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_ip", player.getLocale()) + " §a" + reference.getIP()))
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_firstseen",player.getLocale()) + " §a" + reference.getFirstJoined().replaceAll("-",".")))
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_lastseen", player.getLocale()) + " §a" + reference.getLastJoined().replaceAll("-",".")));
                    }
                }

            } else {
                whiteListText = translator.localeTranslate("atl_w_unknown", player.getLocale());
                hoverEvent = f.newHoverEvent(f.getShowText(), f.newChatComponent("UUID: §a" + uuid));
                clickEvent = f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%w" , uuid));
            }

            cCWhitelistText = f.newChatComponent(whiteListText);
            cCWhitelistText.getChatStyle().setColor(f.colorYellow());
            cCWhitelistText.getChatStyle().setChatClickEvent(clickEvent);
            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCWhitelistText.getChatStyle().setChatHoverEvent(hoverEvent);
            }
            cCText.appendSibling(cCWhitelistText);
            cCText.appendText(", ");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
