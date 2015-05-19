package com.therazzerapp.adminmenu.items;

import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 19:06 PM
 * Package: com.therazzerapp.adminmenu.items
 * E-Mail: rezzer101@googlemail.com
 */

public class BackToMainMenu extends SpecialItem {
    public BackToMainMenu(LocaleHelper translator) {
        super("i_c_backtomain", "<< ","adminmenu.command.admin", "i_c_backtomain_hover", "/admin", translator);
    }
}
