package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class GistLoginPage extends AbstractPage {
    private String usernameGistTxtBox = "login_field";
    private String passwordGistTxtBox = "password";
    private String signInGistBtn = "#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block";
    public GistLoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void checkGistLoginPageIsDisplayed(){
        waitForPresenceOfElementById(usernameGistTxtBox);
    }

    public void inputGistUsernameTxtBox(String username){
        inputTextToElement(getElementById(usernameGistTxtBox), username);
    }

    public void inputGistPasswordTxtBox(String password){
        inputTextToElement(getElementById(passwordGistTxtBox), password);
    }

    public void clickSignInGistBtn(){
        clickElement(getElementByCssSelector(signInGistBtn));
    }
}
