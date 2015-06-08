package de.therazzerapp.adminmenu.items;

import de.therazzerapp.adminmenu.AdminMenuUtils;
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

    private String permission;
    private String hovertext;
    private String command;
    private String name;
    private LocaleHelper translator;
    private String titlePrefix;


    public SpecialItem(String name, String titlePrefix, String permission, String hovertext, String command, LocaleHelper translator) {
        this.name = name;
        this.permission = permission;
        this.hovertext = hovertext;
        this.command = command;
        this.translator = translator;
        this.titlePrefix = titlePrefix;
    }

    public MenuEntry getItem(){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        return EliteLib.getMenuFactory().newMenuEntry(name, f.newChatComponent(titlePrefix).appendSibling(f.newChatComponent(name)), permission, f.colorYellow(), f.getShowText(), AdminMenuUtils.getProvedHover(f.newChatComponent(hovertext)), f.getRunCommand(), command, translator);
    }

}
