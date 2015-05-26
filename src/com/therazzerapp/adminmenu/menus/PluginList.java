package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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
        ChatComponent cCText = f.newChatComponent("");

        int counter = 0;
        for (Plugin plugin : Canary.pluginManager().getPlugins()) {
            counter++;
            ChatComponent cCPluginText = f.newChatComponent(plugin.getName());

            String status;
            if(plugin.isDisabled()){
                status = translator.localeTranslate("atl_pg_disabled",player.getLocale());
                cCPluginText.getChatStyle().setColor(f.colorRed());
            }else {
                status = translator.localeTranslate("atl_pg_enabled",player.getLocale());
                cCPluginText.getChatStyle().setColor(f.colorYellow());
            }

            cCPluginText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + plugin.getName())));

            if(AdminMenu.settings.isPluginInfos()){
                cCPluginText.getChatStyle().getChatHoverEvent().getValue()
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_pg_status", player.getLocale()) + " " + status))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_pg_author", player.getLocale()) + " §a" + plugin.getAuthor()))
                        .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_pg_version", player.getLocale()) + " §a" + plugin.getVersion()));

                if(plugin.getDescriptor().getDependencies().length != 0){
                    String dependencies = "\n";
                    for (String deps : plugin.getDescriptor().getDependencies()){
                        dependencies += "    - §a" + deps + " (" + Canary.pluginManager().getPlugin(deps).getVersion() + ")\n";
                    }
                    cCPluginText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_dependencies", player.getLocale()) + " " + dependencies.substring(0, dependencies.length()-1)));
                }
            }

            cCPluginText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%pl" , plugin.getName())));
            cCText.appendSibling(cCPluginText);

            if(counter %5 == 0){
                cCText.appendText(",\n");
            } else {
                cCText.appendText(", ");
            }
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
