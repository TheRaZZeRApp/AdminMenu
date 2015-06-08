package de.therazzerapp.adminmenu;

import de.therazzerapp.adminmenu.items.Back;
import de.therazzerapp.adminmenu.items.BackToMainMenu;
import de.therazzerapp.adminmenu.items.Exit;
import de.therazzerapp.adminmenu.items.Forward;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.menu.Menu;
import de.myelitecraft.elitelib.api.menu.MenuEntry;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * A collection of useful {@link Menu} editing methods.
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.com>
 * @since AdminMenu v.1.0.0
 */
public abstract class AdminMenuUtils {

    private final static boolean extendedHoverInfos = AdminMenu.settings.isExtendedHoverInfos();
    private final static boolean disableHoverInfos = AdminMenu.settings.isDisableHoverInfos();
    private final static ChatComponentFactory f = Canary.factory().getChatComponentFactory();

    /**
     * Creates a {@link Menu} which is designed for gameRule commands.<br>
     * It contains a Turn On, Turn Off and Status button.<br>
     * Every command starts with: "<i>/gamerule </i>"
     *
     * @param menuName
     *          The {@link Menu} name
     * @param menuPermission
     *          The permission to get the {@link Menu} displayed
     * @param itemPermission
     * @param onHover
     * @param offHover
     * @param statusHover
     * @param gameRule
     *          The gamerule
     * @param commandBack
     *          The command to get back
     * @param permissionBack
     *          The permission to get back
     * @param translator
     *          The {@link LocaleHelper} who translates every text
     * @return a {@link Menu}
     */
    public static Menu getGameruleMenu(String menuName, String menuPermission, String itemPermission, String onHover, String offHover, String statusHover, String gameRule, String commandBack, String permissionBack, LocaleHelper translator){
        Menu menu = EliteLib.getMenuFactory().newMenu(menuName,menuPermission, f.colorWhite(),translator);
        menu.addEntry(getBreakLine());
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnon", itemPermission + ".turnon", f.colorYellow(), f.getShowText(), getProvedHover(f.newChatComponent(onHover + "_hover")), f.getRunCommand(), "/gamerule " + gameRule + " true", translator));
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnoff", itemPermission + ".turnoff", f.colorYellow(), f.getShowText(), getProvedHover(f.newChatComponent(offHover + "_hover")), f.getRunCommand(), "/gamerule " + gameRule + " false", translator));
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_status", itemPermission + ".status", f.colorYellow(), f.getShowText(), getProvedHover(f.newChatComponent(statusHover + "_hover")), f.getRunCommand(), "/gamerule " + gameRule, translator));
        return addNavigation(menu,translator,null,null,permissionBack,commandBack);
    }

    /**
     * Creates a {@link MenuEntry} which contains the following text:<br><i>============================</i>
     *
     * @return a {@link MenuEntry}
     */
    public static MenuEntry getBreakLine(){
        return EliteLib.getMenuFactory().newMenuEntry("============================");
    }

    /**
     * Adds a back to main and close button to the menu.
     *
     * @param menu
     *          The {@link Menu} to edit
     * @param translator
     *          The {@link LocaleHelper} who translates every text
     * @return a {@link Menu} with navigation elements
     */
    public static Menu addNavigation(Menu menu,LocaleHelper translator){
        menu.addEntry(getBreakLine());
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    /**
     * Adds a forward, back, back to main and close button to the menu.<br>
     * Normally the commands are <i>/chatclick chatmenu adm_menuName</i><br>
     * The permissions are the menu permissions.
     *
     * @param menu
     *          The {@link Menu} to edit
     * @param translator
     *          The {@link LocaleHelper} who translates every text
     * @param permissionForward
     *          The permission to get forward
     * @param commandForward
     *          The command to get forward
     * @param permissionBack
     *          The permission to get back
     * @param commandBack
     *          The command to get back
     * @return a {@link Menu} with navigation elements
     */
    public static Menu addNavigation(Menu menu, LocaleHelper translator, String permissionForward, String commandForward, String permissionBack, String commandBack){
        if(commandForward != null){
            if(permissionForward == null){
                menu.addEntry(new Forward("",commandForward,translator).getItem());
            } else {
                menu.addEntry(new Forward(permissionForward,commandForward, translator).getItem());
            }
        }

        if(commandBack != null){
            if(permissionBack == null){
                menu.addEntry(new Back("",commandBack,translator).getItem());
            } else {
                menu.addEntry(new Back(permissionBack,commandBack,translator).getItem());
            }
        }
        menu.addEntry(new BackToMainMenu(translator).getItem());
        menu.addEntry(getBreakLine());
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    /**
     * Proves hover {@link ChatComponent}. If hover infos are disabled in the admin menu config file<br>
     * the method returns null, if extended hover infos are disabled the method returns a new {@link ChatComponent}<br>
     * without siblings and the text from the <i>chatComponent</i>.
     *
     * @param chatComponent
     *          The hover {@link ChatComponent}
     * @return the proved hover {@link ChatComponent}, <tt>null</tt> if hover infos are disabled
     */
    public static ChatComponent getProvedHover(ChatComponent chatComponent){
        if(disableHoverInfos){
            return null;
        } else {
            if(extendedHoverInfos){
                return chatComponent;
            } else {
                return f.newChatComponent(chatComponent.getText());
            }
        }
    }
}
