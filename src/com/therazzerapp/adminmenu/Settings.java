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

    public Settings(JsonObject root) {
        this.muteChatInMenu = root.getAsJsonPrimitive("muteChatInMenu").getAsBoolean();
        this.playermenu = root.getAsJsonPrimitive("playermenu").getAsBoolean();
        this.servermenu = root.getAsJsonPrimitive("servermenu").getAsBoolean();
        this.worldmenu = root.getAsJsonPrimitive("worldmenu").getAsBoolean();
        this.groupmenu = root.getAsJsonPrimitive("groupmenu").getAsBoolean();
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
}
