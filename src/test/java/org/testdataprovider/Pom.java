package org.testdataprovider;

import org.basic.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom extends Baseclass {
	 public Pom()  {
			PageFactory.initElements(driver,this);
			}
		@FindBy(id="email")
		private WebElement txtUserName;
		@FindBy(id="pass")
		private WebElement txtPassword;
		@FindBy(xpath="//buttton[@name='login']")
		private WebElement logBtn;
		
		
		public WebElement getTxtUserName() {
			return txtUserName;
			}
		public WebElement getTxtPassword() {
			return txtPassword;
		}
		public WebElement getlogBtn() {
		return logBtn;
		}
}
