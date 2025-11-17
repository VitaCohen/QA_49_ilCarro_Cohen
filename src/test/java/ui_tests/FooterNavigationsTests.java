package ui_tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.enums.FooterMenuItem;

public class FooterNavigationsTests extends ApplicationManager {


    @Test
    public void iconFacebookNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver())
                .clickFooterItem(FooterMenuItem.ICON_FACEBOOK, "Facebook"));
    }

    @Test
    public void iconTelegramNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver())
                .clickFooterItem(FooterMenuItem.ICON_TELEGRAM, "Telegram"));

    }

}
