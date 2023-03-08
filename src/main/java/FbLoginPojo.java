

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FbLoginPojo {
	//1.Non parameterized constrcuter
	public FbLoginPojo() {
		
	}
	//2.Private WebElement
	//WebElement email = driver.findElement(By.id("email"));
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(xpath = "//input[@aria-label='Password']")
	private WebElement Password;
	
	@FindBy(name = "login")
	private WebElement loginBtn;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//3.Getters to Access WebElemnt outside the class
	
	

}
