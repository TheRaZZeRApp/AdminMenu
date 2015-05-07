package com.therazzerapp.adminmenu.listener;

import de.myelitecraft.elitelib.api.chatclick.ChatClickHook;
import net.canarymod.hook.HookHandler;
import net.canarymod.plugin.PluginListener;

/**
 * Project: AdminMenu
 * User: Sonny
 * Date: 07/05/2015
 * Time: 10:16 PM
 * Package: com.therazzerapp.adminmenu.listener
 */

public class BlankLineListener implements PluginListener {
    @HookHandler
    public void onChatClick(ChatClickHook hook){
        if(hook.getName().equals("chatmenu") && hook.getParameters()[0].startsWith("adm_")){
            hook.getPlayer().message("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
