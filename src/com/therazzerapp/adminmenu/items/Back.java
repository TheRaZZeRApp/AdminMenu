package com.therazzerapp.adminmenu.items;

import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 08/04/2015
 * Time: 16:06 PM
 * Package: com.therazzerapp.adminmenu.items
 * E-Mail: rezzer101@googlemail.com
 */

public class Back extends SpecialItem{
    public Back(String PERMISSION, String COMMAND, LocaleHelper TRANSLATOR) {
        super("item_name_const_back", PERMISSION, "item_name_const_back_hover", COMMAND, TRANSLATOR);
    }
}
