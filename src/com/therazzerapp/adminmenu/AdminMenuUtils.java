package com.therazzerapp.adminmenu;

import com.therazzerapp.adminmenu.items.Back;
import com.therazzerapp.adminmenu.items.BackToMainMenu;
import com.therazzerapp.adminmenu.items.Exit;
import com.therazzerapp.adminmenu.items.Forward;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.menu.Menu;
import de.myelitecraft.elitelib.api.menu.MenuEntry;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.factory.ChatComponentFactory;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * A collection of useful menu methods.
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.com>
 */
public abstract class AdminMenuUtils {

    private final static boolean extendedHoverInfos = AdminMenu.settings.isExtendedHoverInfos();
    private final static boolean disableHoverInfos = AdminMenu.settings.isDisableHoverInfos();
    private final static ChatComponentFactory f = Canary.factory().getChatComponentFactory();

    /**
     *
     * @param menuName
     * @param menuPermission
     * @param itemPermission
     * @param onHover
     * @param offHover
     * @param statusHover
     * @param gameRule
     * @param commandBack
     * @param permissionBack
     * @param translator
     * @return
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
     *
     * @return
     */
    public static MenuEntry getBreakLine(){
        return EliteLib.getMenuFactory().newMenuEntry("============================");
    }

    /**
     *
     * @param menu
     * @param translator
     * @return
     */
    public static Menu addNavigation(Menu menu,LocaleHelper translator){
        menu.addEntry(getBreakLine());
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    /**
     *
     * @param menu
     * @param translator
     * @param permissionForward
     * @param commandForward
     * @param permissionBack
     * @param commandBack
     * @return
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
     *
     * @param chatComponent
     * @return
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
