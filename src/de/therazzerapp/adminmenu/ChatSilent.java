package de.therazzerapp.adminmenu;

import de.myelitecraft.elitelib.api.EliteLib;
import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ChatHook;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;
import net.visualillusionsent.utils.LocaleHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 08/04/2015
 * Time: 16:05 PM
 * Package: com.therazzerapp.adminmenu.commands
 * E-Mail: rezzer101@googlemail.com
 */
public class ChatSilent implements PluginListener{
    public static final Map<Player, List<String>> chatMap = new HashMap<>();

    static {
        EliteLib.getPlayerQuitHelper().registerPlayerMap(chatMap);
    }

    public static void activate(Player player, LocaleHelper translator) {
        if (!chatMap.containsKey(player)) {
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.showTitle(f.newChatComponent(translator.localeTranslate("chatsilent_00", player.getLocale())));
            chatMap.put(player, new ArrayList<String>());
        }
    }

    public static void deactivate(Player player, LocaleHelper translator) {
        List<String> msgs = chatMap.remove(player);
        if (msgs != null) {
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.showTitle(f.newChatComponent(translator.localeTranslate("chatsilent_01", player.getLocale())));
            for (String msg : msgs) {
                player.message(msg);
            }
        }

    }

    @HookHandler(priority = Priority.LOW, ignoreCanceled = true)
    public void onChat(ChatHook hook) {
        String format = hook.getFormat();

        for (Map.Entry<String, String> entry : hook.getPlaceholderMapping().entrySet()) {
            format = format.replace(entry.getKey(), entry.getValue());
        }

        ArrayList<Player> getter = new ArrayList<>();

        for (Player player : hook.getReceiverList()) {
            List<String> chat = chatMap.get(player);
            if (chat == null) {
                getter.add(player);
            } else {
                chat.add(format);
            }
        }

        hook.setReceiverList(getter);
    }
}
