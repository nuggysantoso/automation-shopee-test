package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class GistNewEditorPage extends AbstractPage {
    private String gistDescriptionTxtBox = "#gists > input";
    private String gistFileNameTxtBox = "#gists > div.js-gist-file > div > div.file-header > div.input-group.gist-filename-input > input.form-control.filename.js-gist-filename.js-blob-filename";
    private String gistIndentModeDropDown = "#gists > div.js-gist-file > div > div.file-header > div.file-actions > select.form-select.select-sm.js-code-indent-mode";
    private String gistIndentSizeDropDown = "#gists > div.js-gist-file > div > div.file-header > div.file-actions > select.form-select.select-sm.js-code-indent-width";
    private String gistLineWrapModeDropDown = "#gists > div.js-gist-file > div > div.file-header > div.file-actions > select.form-select.select-sm.js-code-wrap-mode";
    private String gistEditorTxtBox = "#gists > div:nth-child(3) > div > div.commit-create > div > div.CodeMirror-scroll > div.CodeMirror-sizer > div > div";
    private String gistEditorTxtBoxSpan = "#gists > div.js-gist-file > div > div.commit-create > div > div.CodeMirror-scroll > div.CodeMirror-sizer > div > div > div > div.CodeMirror-code > div > pre > span > span";
    private String createPublicGistBtn = "#new_gist > div > div.form-actions > button:nth-child(1)";
    private String titleGistCreated = "#file-sadsadsadsadsaasdasdasdasda > div.file-header > div.file-info > a";
    private String editGistBtn = "#gist-pjax-container > div.gisthead.pagehead.repohead.instapaper_ignore.readability-menu.experiment-repo-nav.mb-4 > div > div.container.repohead-details-container > ul > li:nth-child(1) > a";

    private String gistTitleCreated;

    public String getGistTitleCreated() {
        return gistTitleCreated;
    }

    public void setGistTitleCreated(String gistTitleCreated) {
        this.gistTitleCreated = gistTitleCreated;
    }

    public GistNewEditorPage(WebDriver webDriver){
        super(webDriver);
    }

    public void checkGistNewEditorPageIsDisplayed(){
        waitForPresenceOfElementByCssSelector(gistDescriptionTxtBox);
    }

    public void inputGistNewEditorTxtBox(int length){
        setGistTitleCreated(getRandomStringGenerator(length));
        inputTextToElement(getElementByCssSelector(gistDescriptionTxtBox), getGistTitleCreated());
    }

    public void inputGistFileNameTxtBox(int length){
        inputTextToElement(getElementByCssSelector(gistFileNameTxtBox), getRandomStringGenerator(length));
    }

    public void selectGistIndentModeDropDown(String gistIndentMode){
        selectDropDownByVisibleText(getElementByCssSelector(gistIndentModeDropDown), gistIndentMode);
    }

    public void selectGistIndentSizeDropDown(String gistIndentSize){
        selectDropDownByVisibleText(getElementByCssSelector(gistIndentSizeDropDown), gistIndentSize);
    }

    public void selectLineWrapModeDropDown(String lineWrapMode){
        selectDropDownByVisibleText(getElementByCssSelector(gistLineWrapModeDropDown), lineWrapMode);
    }

    public void inputGistEditorTxtBox(int length){
        setValueToElement(getElementByCssSelector(gistEditorTxtBoxSpan), getRandomStringGenerator(length));
    }

    public void clickCreatePublicGistBtn(){
        clickElement(getElementByCssSelector(createPublicGistBtn));
    }

    public void checkGistCreatedPageIsDisplayed(){
        waitForPresenceOfElementByCssSelector(editGistBtn);
    }

    public void checkGistHasCreated(){
        String actual = getTextOrValueElement(getElementByCssSelector(titleGistCreated)).replace(" ", "");
        assertEquals("Gist Not Created", getGistTitleCreated(), actual);
    }
}
