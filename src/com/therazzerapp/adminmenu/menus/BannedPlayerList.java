package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.bansystem.Ban;
import net.visualillusionsent.utils.LocaleHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project: AdminMenu
 * User: Sonny
 * Date: 12/05/2015
 * Time: 08:55 PM
 * Package: com.therazzerapp.adminmenu.menus
 */
public class BannedPlayerList {
    public static ChatComponent getBody(String tooltip, String command, Player player, LocaleHelper translator) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        for (Ban ban : Canary.bans().getAllBans()) {

            ChatComponent cCBannedText = f.newChatComponent(ban.getSubject());
            cCBannedText.getChatStyle().setColor(f.colorYellow());

            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCBannedText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + ban.getSubject())));

                if (AdminMenu.settings.isBanInfos()) {

                    String reason = translator.localeTranslate("atl_ban_noreason", player.getLocale());
                    if (ban.getReason() != null || !ban.getReason().isEmpty() || !ban.getReason().equals("Permanently Banned") || !ban.getReason().startsWith("Temporarily banned until ")) {
                        reason = ban.getReason();
                    }

                    cCBannedText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_ban_banner", player.getLocale()) + " §a" + ban.getBanningPlayer() + " (" + Canary.getServer().getPlayer(ban.getBanningPlayer()).getGroup().getName() + ")"))
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_ban_reason", player.getLocale()) + " §a" + reason));

                    if (ban.isIpBan()) {
                        cCBannedText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_ip", player.getLocale()) + " " + ban.getIp()));
                    }

                    cCBannedText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_ban_creaton", player.getLocale()) + " §a" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(ban.getIssuedDate() * 1000))));

                    if (ban.getExpiration() != -1L) {
                        cCBannedText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_ban_expiration", player.getLocale()) + " §a" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(ban.getExpiration() * 1000))));
                    }
                }
            }

            cCBannedText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%bp" , ban.getSubject())));

            cCText.appendSibling(cCBannedText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
