package cbachallenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Covid19 {
	WebDriver driver;
	@FindBy(xpath="//*[@id='worrior_username']")
	WebElement warriorname_fld;
	
	@FindBy(id="warrior")
	WebElement createwarrior_btn;
	
	@FindBy(id="start")
	WebElement startgame_btn;
	
	@FindBy(id="popup")
	WebElement popupwarning;
	
	@FindBy(xpath="/html/body/div[1]/h1/p")
	WebElement pagebanner;
	
	
	public Covid19 (WebDriver driver) {
      this.driver =driver;
      PageFactory.initElements(driver, this);
	}

	public void setWarriorName(String strWarriorName){
		warriorname_fld.clear();
		warriorname_fld.sendKeys(strWarriorName);     
    }
	
	public void clickCreateWarrior(){
		createwarrior_btn.click();

}  
	public String getPopupmsg() {
		return popupwarning.getText();
	}
	
	public String getStartbtntxt() {
		return startgame_btn.getText();
}
	public String getPageBanner() {
		return pagebanner.getText();
}
	public String createwarrior(String username) {
		setWarriorName(username);
		return getStartbtntxt();
	}
}
