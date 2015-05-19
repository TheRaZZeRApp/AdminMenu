package com.therazzerapp.adminmenu.items;

import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Sonny
 * Date: 07/05/2015
 * Time: 10:53 PM
 * Package: com.therazzerapp.adminmenu.items
 */
public class Refresh extends SpecialItem {
    public Refresh(String hovertext, String command, LocaleHelper translator) {
        super("i_c_refresh", "", "adminmenu.command.refresh", hovertext, command, translator);
    }
}
