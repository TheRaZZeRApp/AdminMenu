package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.plugin.Plugin;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 19:30 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class PluginList {
    public static ChatComponent getBody(String tooltip, String command,Player player, LocaleHelper translator) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        int counter = 0;
        String komma;
        for (Plugin plugin : Canary.pluginManager().getPlugins()) {

            counter++;
            komma = ", ";
            if (counter >= Canary.pluginManager().getPlugins().size()){
                komma = "";
            }else if((counter % 5) == 0){
                komma = ",\n";
            }

            ChatComponent pluginText = f.newChatComponent(plugin.getName() + komma);

            String status;
            if(plugin.isDisabled()){
                status = translator.localeTranslate("atl_pg_disabled",player.getLocale());
            }else {
                status = translator.localeTranslate("atl_pg_enabled",player.getLocale());
            }

            pluginText.getChatStyle().setColor(f.colorYellow());

            pluginText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + plugin.getName())));

            if(AdminMenu.settings.isPluginInfos()){
                pluginText.getChatStyle().getChatHoverEvent().getValue()
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_pg_status", player.getLocale()) + " " + status))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_pg_author", player.getLocale()) + " §a" + plugin.getAuthor()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_pg_version", player.getLocale()) + " §a" + plugin.getVersion()));
            }

            pluginText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%pl" , plugin.getName())));
            text.appendSibling(pluginText);
        }

        return text;
    }
}
