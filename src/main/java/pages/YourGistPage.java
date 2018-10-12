package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Nuggy Santoso on 10/13/2018
 */
public class YourGistPage extends AbstractPage {
    private String gistCreated = "#gist-pjax-container > div.container.new-discussion-timeline.experiment-repo-nav > div.repository-content.gist-content > div:nth-child(1) > div.gist-snippet-meta > div > span.creator > a:nth-child(3)";
    private String deleteBtn = "#gist-pjax-container > div.gisthead.pagehead.repohead.instapaper_ignore.readability-menu.experiment-repo-nav.mb-4 > div > div.container.repohead-details-container > ul > li:nth-child(2) > form > button";
    private String editGistBnt = "#gist-pjax-container > div.gisthead.pagehead.repohead.instapaper_ignore.readability-menu.experiment-repo-nav.mb-4 > div > div.container.repohead-details-container > ul > li:nth-child(1) > a";

    public YourGistPage(WebDriver webDriver){
        super(webDriver);
    }

    public void checkYourGistPageIsDisplayed(){
        waitForPresenceOfElementByCssSelector(gistCreated);
    }

    public void clickGistCreated(){
        clickElement(getElementByCssSelector(gistCreated));
    }

    public void checkGistSelectedIsDisplayed(){
        waitForPresenceOfElementByCssSelector(deleteBtn);
    }

    public void clickEditGistBtn(){
        clickElement(getElementByCssSelector(editGistBnt));
    }

    public void clickDeletGistBtn(){
        clickElement(getElementByCssSelector(deleteBtn));
    }
}
