package com.therazzerapp.adminmenu;

import com.google.gson.JsonObject;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 18:59 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class Settings {

    private final boolean muteChatInMenu;
    private final boolean playermenu;
    private final boolean servermenu;
    private final boolean worldmenu;
    private final boolean groupmenu;
    private final boolean playerInfos;
    private final boolean worldInfos;
    private final boolean pluginInfos;
    private final boolean banInfos;
    private final boolean groupInfos;
    private final boolean atlEmptyItem;
    private final boolean multiLanguageReasons;

    public Settings(JsonObject root) {
        this.muteChatInMenu = root.getAsJsonPrimitive("mute_chat_in_menu").getAsBoolean();
        this.playermenu = root.getAsJsonPrimitive("playermenu").getAsBoolean();
        this.servermenu = root.getAsJsonPrimitive("servermenu").getAsBoolean();
        this.worldmenu = root.getAsJsonPrimitive("worldmenu").getAsBoolean();
        this.groupmenu = root.getAsJsonPrimitive("groupmenu").getAsBoolean();
        this.playerInfos = root.getAsJsonPrimitive("player_infos").getAsBoolean();
        this.worldInfos = root.getAsJsonPrimitive("world_infos").getAsBoolean();
        this.pluginInfos = root.getAsJsonPrimitive("plugin_infos").getAsBoolean();
        this.banInfos = root.getAsJsonPrimitive("ban_infos").getAsBoolean();
        this.groupInfos = root.getAsJsonPrimitive("group_infos").getAsBoolean();
        this.atlEmptyItem = root.getAsJsonPrimitive("atl_empty_item").getAsBoolean();
        this.multiLanguageReasons = root.getAsJsonPrimitive("multi_language_reasons").getAsBoolean();
    }

    public boolean isMuteChatInMenu() {
        return muteChatInMenu;
    }

    public boolean isPlayermenu() {
        return playermenu;
    }

    public boolean isServermenu() {
        return servermenu;
    }

    public boolean isWorldmenu() {
        return worldmenu;
    }

    public boolean isGroupmenu() {
        return groupmenu;
    }

    public boolean isPlayerInfos() {
        return playerInfos;
    }

    public boolean isWorldInfos() {
        return worldInfos;
    }

    public boolean isPluginInfos() {
        return pluginInfos;
    }

    public boolean isBanInfos() {
        return banInfos;
    }

    public boolean isGroupInfos() {
        return groupInfos;
    }

    public boolean isAtlEmptyItem() {
        return atlEmptyItem;
    }

    public boolean isMultiLanguageReasons() {
        return multiLanguageReasons;
    }
}
