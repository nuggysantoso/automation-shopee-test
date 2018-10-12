package pages;

import common.Constants;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class GistHomePage extends AbstractPage{
    private String gistHomeLogo = "body > div.position-relative.js-header-wrapper > div.Header.gist-header.header-logged-out > div > div > div.d-flex > a";
    private String gistLoginBtn = "body > div.position-relative.js-header-wrapper > div.Header.gist-header.header-logged-out > div > div > div.header-actions > a:nth-child(2)";
    private String newGistBtn = "#user-links > li:nth-child(1) > a";
    private String yourGistDropDown = "#user-links > li.dropdown > details > summary > span";
    private String yourGistOption = "//*[a='Your gists']";

    public GistHomePage(WebDriver webDriver){
        super(webDriver);
        webDriver.get(Constants.DEFAULT_WEB_URL_GIST);
    }

    public void checkGistHomePageIsDisplayed(){
        waitForPresenceOfElementByCssSelector(gistHomeLogo);
    }

    public void checkGistHomePageAfterLoginIsDisplayed(){
        waitForPresenceOfElementByCssSelector(newGistBtn);
    }

    public void clickSignInGist(){
        clickElement(getElementByCssSelector(gistLoginBtn));
    }

    public void clickNewGistBtn(){
        clickElement(getElementByCssSelector(newGistBtn));
    }

    public void clickYourGistDropDown(){
        clickElement(getElementByCssSelector(yourGistDropDown));
    }

    public void clickYourGistOption(){
        clickElement(getElementByXPath(yourGistOption));
    }
}
