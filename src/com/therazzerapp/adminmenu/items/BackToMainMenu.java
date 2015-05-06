package com.therazzerapp.adminmenu.items;

import com.therazzerapp.adminmenu.Translator;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 19:06 PM
 * Package: com.therazzerapp.adminmenu.items
 * E-Mail: rezzer101@googlemail.com
 */

public class BackToMainMenu extends SpecialItem {
    public BackToMainMenu(Translator TRANSLATOR) {
        super("item_name_const_backtomain", "adminmenu.command.admin", "item_name_const_backtomain_hover", "/admin", TRANSLATOR);
    }
}
