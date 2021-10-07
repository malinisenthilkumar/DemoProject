package org.basic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators extends Baseclass{
public Locators() {
	PageFactory.initElements(driver, this);
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
public WebElement gettxtlogBtn() {
return logBtn;
}
////public WebElement gettxtcreate() {
//	return txtcreate;
//}
//public WebElement gettxtFname() {
//	return txtFname;
//}
//public WebElement gettxtLname() {
//	return Lname;
//}
//public WebElement gettxtmail() {
//	return tmail;
//}
//public WebElement gettxtRemail() {
//	return Remail;
//}
//public WebElement gettxtpass() {
//	return pass;
//}
//public WebElement gettxtDate() {
//	return Date;
//}
//public WebElement gettxtMonth() {
//	return Month;
//}
//public WebElement gettxtYear() {
//	return Year;
//}
//public WebElement gettxtDate() {
//	return create;
//}

}
