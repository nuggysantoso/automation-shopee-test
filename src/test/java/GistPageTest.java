import common.BaseWebTest;
import org.junit.Test;
import pages.GistHomePage;
import pages.GistLoginPage;
import pages.GistNewEditorPage;
import pages.YourGistPage;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class GistPageTest extends BaseWebTest {
    GistHomePage gistHomePage;
    GistLoginPage gistLoginPage;
    GistNewEditorPage gistNewEditorPage;
    YourGistPage yourGistPage;

    @Test()
    public void GPT_01(){
        gistHomePage = new GistHomePage(getWebDriver());
        gistLoginPage = new GistLoginPage(getWebDriver());
        gistNewEditorPage = new GistNewEditorPage(getWebDriver());

        gistHomePage.checkGistHomePageIsDisplayed();
        gistHomePage.clickSignInGist();

        gistLoginPage.checkGistLoginPageIsDisplayed();
        gistLoginPage.inputGistUsernameTxtBox("nuggysantoso1");
        gistLoginPage.inputGistPasswordTxtBox("Demidevil1");
        gistLoginPage.clickSignInGistBtn();

        gistHomePage.checkGistHomePageAfterLoginIsDisplayed();
        gistHomePage.clickNewGistBtn();

        gistNewEditorPage.checkGistNewEditorPageIsDisplayed();
        gistNewEditorPage.inputGistNewEditorTxtBox(10);
        gistNewEditorPage.inputGistFileNameTxtBox(10);
        gistNewEditorPage.inputGistEditorTxtBox(1000);
        gistNewEditorPage.clickCreatePublicGistBtn();
    }

    @Test()
    public void GPT_02(){
        gistHomePage = new GistHomePage(getWebDriver());
        gistLoginPage = new GistLoginPage(getWebDriver());
        gistNewEditorPage = new GistNewEditorPage(getWebDriver());

        gistHomePage.checkGistHomePageIsDisplayed();
        gistHomePage.clickSignInGist();

        gistLoginPage.checkGistLoginPageIsDisplayed();
        gistLoginPage.inputGistUsernameTxtBox("nuggysantoso1");
        gistLoginPage.inputGistPasswordTxtBox("Demidevil1");
        gistLoginPage.clickSignInGistBtn();

        gistHomePage.checkGistHomePageAfterLoginIsDisplayed();
        gistHomePage.clickYourGistDropDown();
        gistHomePage.clickYourGistOption();

        yourGistPage.checkYourGistPageIsDisplayed();
        yourGistPage.clickGistCreated();
        yourGistPage.checkGistSelectedIsDisplayed();
        yourGistPage.clickEditGistBtn();
    }

    @Test
    public void GPT_03(){
        gistHomePage = new GistHomePage(getWebDriver());
        gistLoginPage = new GistLoginPage(getWebDriver());
        gistNewEditorPage = new GistNewEditorPage(getWebDriver());
        yourGistPage = new YourGistPage(getWebDriver());

        gistHomePage.checkGistHomePageIsDisplayed();
        gistHomePage.clickSignInGist();

        gistLoginPage.checkGistLoginPageIsDisplayed();
        gistLoginPage.inputGistUsernameTxtBox("nuggysantoso1");
        gistLoginPage.inputGistPasswordTxtBox("Demidevil1");
        gistLoginPage.clickSignInGistBtn();

        gistHomePage.checkGistHomePageAfterLoginIsDisplayed();
        gistHomePage.clickYourGistDropDown();
        gistHomePage.clickYourGistOption();

        yourGistPage.checkYourGistPageIsDisplayed();
        yourGistPage.clickGistCreated();
        yourGistPage.checkGistSelectedIsDisplayed();
        yourGistPage.clickDeletGistBtn();
    }

    @Test
    public void GPT_04(){
        gistHomePage = new GistHomePage(getWebDriver());
        gistLoginPage = new GistLoginPage(getWebDriver());
        gistNewEditorPage = new GistNewEditorPage(getWebDriver());
        yourGistPage = new YourGistPage(getWebDriver());

        gistHomePage.checkGistHomePageIsDisplayed();
        gistHomePage.clickSignInGist();

        gistLoginPage.checkGistLoginPageIsDisplayed();
        gistLoginPage.inputGistUsernameTxtBox("nuggysantoso1");
        gistLoginPage.inputGistPasswordTxtBox("Demidevil1");
        gistLoginPage.clickSignInGistBtn();

        gistHomePage.checkGistHomePageAfterLoginIsDisplayed();
        gistHomePage.clickYourGistDropDown();
        gistHomePage.clickYourGistOption();

        yourGistPage.checkYourGistPageIsDisplayed();
    }
}
