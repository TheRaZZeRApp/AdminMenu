package com.therazzerapp.adminmenu.items;

import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.menu.MenuEntry;
import net.canarymod.Canary;
import net.canarymod.api.factory.ChatComponentFactory;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 08/04/2015
 * Time: 16:23 PM
 * Package: com.therazzerapp.adminmenu.items
 * E-Mail: rezzer101@googlemail.com
 */

public abstract class SpecialItem {

    private String PERMISSION;
    private String HOVERTEXT;
    private String COMMAND;
    private String NAME;
    private LocaleHelper TRANSLATOR;


    public SpecialItem(String NAME, String PERMISSION, String HOVERTEXT, String COMMAND, LocaleHelper TRANSLATOR) {
        this.NAME = NAME;
        this.PERMISSION = PERMISSION;
        this.HOVERTEXT = HOVERTEXT;
        this.COMMAND = COMMAND;
        this.TRANSLATOR = TRANSLATOR;
    }

    public MenuEntry getItem(){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        return EliteLib.getMenuFactory().newMenuEntry(NAME,PERMISSION,f.colorYellow(),f.getShowText(),f.newChatComponent(HOVERTEXT),f.getRunCommand(),COMMAND,TRANSLATOR);
    }
}
