package cbachallenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Choosebattlefield {
	
	WebDriver driver;
	@FindBy(id="welcome_text")
	WebElement welcometext_msg;
	
	@FindBy(id="news")
	WebElement gameintro_lnk;
	
	@FindBy(id="bus")
	WebElement takethebus_lnk;
	
	@FindBy(id="restaurant")
	WebElement publicplace_lnk;
	
	@FindBy(id="office")
	WebElement gotooffice_lnk;
	
	public Choosebattlefield (WebDriver driver) {
      this.driver =driver;
      PageFactory.initElements(driver, this);
	}
public String getWelcomeText() {
	return welcometext_msg.getText();
}
	

}
