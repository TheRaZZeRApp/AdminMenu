package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import de.myelitecraft.elitelib.EliteStringUtils;
import de.myelitecraft.elitelib.api.StringUtils;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.api.world.World;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 12/05/2015
 * Time: 20:11 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class WorldList {
    public static ChatComponent getBody(String tooltip, String command, Player player, LocaleHelper translator){

        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent cCText = f.newChatComponent("");

        for (World w : Canary.getServer().getWorldManager().getAllWorlds()) {

            ChatComponent cCWorldText;
            if (player.getWorld() == w){
                cCWorldText = f.newChatComponent("- " + w.getName() + " §c" + translator.localeTranslate("atl_w_currentw",player.getLocale()));
                cCWorldText.getChatStyle().setColor(f.colorYellow());
            } else {
                cCWorldText = f.newChatComponent("- " + w.getName());
                cCWorldText.getChatStyle().setColor(f.colorYellow());
            }



            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCWorldText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(translator.localeTranslate(tooltip, player.getLocale()) + " §a" + w.getName())));
                if (AdminMenu.settings.isWorldInfos()) {
                    StringUtils stringUtils = new EliteStringUtils();
                    cCWorldText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_player", player.getLocale()) + " §a" + w.getPlayerList().size()))
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_dimension", player.getLocale()) + " §a" + stringUtils.charToUpperCase(w.getWorldType().toString().toLowerCase(), 0)))
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_gm", player.getLocale()) + " §a" + stringUtils.charToUpperCase(w.getGameMode().name().toLowerCase(), 0)))
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_w_type", player.getLocale()) + " §a" + stringUtils.charToUpperCase(w.getType().getName().toLowerCase(),0)));
                }
            }

            cCWorldText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%wo" , w.getName()+ "_" +w.getType().getName())));

            cCText.appendSibling(cCWorldText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
