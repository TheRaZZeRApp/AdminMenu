package com.therazzerapp.adminmenu.items;

import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 08/04/2015
 * Time: 16:20 PM
 * Package: com.therazzerapp.adminmenu.items
 * E-Mail: rezzer101@googlemail.com
 */

public class Forward extends SpecialItem {
    public Forward(String PERMISSION, String COMMAND, LocaleHelper TRANSLATOR) {
        super("item_name_const_forward", PERMISSION, "item_name_const_forward_hover", COMMAND, TRANSLATOR);
    }
}
