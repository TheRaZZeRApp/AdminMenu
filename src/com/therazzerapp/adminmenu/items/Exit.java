package com.therazzerapp.adminmenu.items;

import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 19:09 PM
 * Package: com.therazzerapp.adminmenu.items
 * E-Mail: rezzer101@googlemail.com
 */

public class Exit extends SpecialItem {
    public Exit(LocaleHelper TRANSLATOR) {
        super("i_c_close", "" ,"adminmenu.command.close", "i_c_hover", "/admin exit", TRANSLATOR);
    }
}
