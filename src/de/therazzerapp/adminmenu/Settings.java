package de.therazzerapp.adminmenu;

import com.google.gson.JsonObject;
import de.myelitecraft.elitelib.api.config.ConfigSection;

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
    private final boolean disableHoverInfos;
    private final boolean extendedHoverInfos;

    public Settings(ConfigSection root) {
        this.muteChatInMenu = root.getBoolean("mute_chat_in_menu");
        this.playermenu = root.getBoolean("playermenu");
        this.servermenu = root.getBoolean("servermenu");
        this.worldmenu = root.getBoolean("worldmenu");
        this.groupmenu = root.getBoolean("groupmenu");
        this.playerInfos = root.getBoolean("player_infos");
        this.worldInfos = root.getBoolean("world_infos");
        this.pluginInfos = root.getBoolean("plugin_infos");
        this.banInfos = root.getBoolean("ban_infos");
        this.groupInfos = root.getBoolean("group_infos");
        this.atlEmptyItem = root.getBoolean("atl_empty_item");
        this.multiLanguageReasons = root.getBoolean("multi_language_reasons");
        this.extendedHoverInfos = root.getBoolean("extended_hover_infos");
        this.disableHoverInfos = root.getBoolean("disable_hover_infos");
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

    public boolean isExtendedHoverInfos() {
        return extendedHoverInfos;
    }

    public boolean isDisableHoverInfos() {
        return disableHoverInfos;
    }
}
