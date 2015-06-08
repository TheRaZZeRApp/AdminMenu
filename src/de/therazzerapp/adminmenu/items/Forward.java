package de.therazzerapp.adminmenu.items;

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
    public Forward(String permission, String command, LocaleHelper translator) {

        super("i_c_forward", "=> ", permission, "i_c_forward_hover", command, translator);

    }
}
