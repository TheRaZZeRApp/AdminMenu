package com.therazzerapp.adminmenu.items;

import com.therazzerapp.adminmenu.Translator;
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
    public Exit(String HOVERTEXT, LocaleHelper TRANSLATOR) {
        super("extras_close", "adminmenu.command.close", HOVERTEXT, "/adminmenu exit", TRANSLATOR);
    }
}
