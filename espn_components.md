# CREATE AN ACOUNT, SIGN IN AND DELETE ACOUNT IN ESPN PAGE

## CREATE AN ACOUNT COMPONENTS

```java
@FindBy(id="global-user-trigger")
	private WebElement btnUser;

@FindBy(css="li:nth-child(2)  a[tref='/members/v3_1/login']")
	private WebElement btnLogIn;

@FindBy(css="[did-translate='login.label.CREATE_ACCOUNT']")
	private WebElement btnSignIn;

@FindBy(css="[name='firstName']")
	private WebElement txtName;

@FindBy(css="[name='lastName']")
	private WebElement txtLastName;

@FindBy(css="[name='email']")
	private WebElement txtEmail;

@FindBy(css="[name='newPassword']")
	private WebElement txtPassword;
```