package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.bansystem.Ban;
import net.canarymod.bansystem.BanType;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Sonny
 * Date: 12/05/2015
 * Time: 08:55 PM
 * Package: com.therazzerapp.adminmenu.menus
 */
public class BannedPlayerList {
    public static ChatComponent getBody(String tooltip, String command,Player player, LocaleHelper translator) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        int counter = 0;
        String komma;
        for (Ban ban : Canary.bans().getAllBans()) {

            counter++;
            komma = ", ";
            if(counter >= Canary.bans().getAllBans().length){
                komma = "";
            }

            ChatComponent reserveText = f.newChatComponent(ban.getSubject() + komma);
            reserveText.getChatStyle().setColor(f.colorYellow());


            reserveText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + ban.getSubject())));

            if(AdminMenu.settings.isBanInfos()){

                String reason = translator.localeTranslate("atl_ban_noreason",player.getLocale());
                if(ban.getReason() != null || !ban.getReason().equals("") || !ban.getReason().equals("Permanently Banned") || !ban.getReason().startsWith("Temporarily banned until ")){
                    reason = ban.getReason();
                }



                reserveText.getChatStyle().getChatHoverEvent().getValue()
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_ban_banner", player.getLocale()) + " §a" + ban.getBanningPlayer()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_ban_reason",player.getLocale()) + " §a" + reason));

                if(ban.isIpBan()){
                    reserveText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_p_ip", player.getLocale()) + " " + ban.getIp()));
                }
                //todo ablaufdatum
            }



            reserveText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%bp" , ban.getSubject())));

            text.appendSibling(reserveText);
        }
        return text;
    }
}
