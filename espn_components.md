# CREATE AN ACCOUNT, LOG IN AND DELETE ACOUNT IN ESPN PAGE

## CREATE AN ACCOUNT COMPONENTS

```java
@FindBy(id="global-user-trigger")
	private WebElement btnUser;

@FindBy(css="li:nth-child(2) [tref='/members/v3_1/login']")
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
	private WebElement txtNewPassword;

@FindBy(css="[did-translate='create.SIGN_UP']")
	private WebElement btnCreateAccount;

@FindBy(css=".display-user span")
	private WebElement userNameDisplayed;
```

## LOG IN COMPONENTS

```java
@FindBy(id="global-user-trigger")
	private WebElement btnUser;

@FindBy(css="li:nth-child(2)  a[tref='/members/v3_1/login']")
	private WebElement btnLogIn;

@FindBy(css="[ng-model='vm.username']")
	private WebElement txtUserName;

@FindBy(css="[ng-model='vm.password']")
	private WebElement txtPassword;

@FindBy(css="[did-translate='login.label.SIGNIN']")
	private WebElement btnEnter;

@FindBy(css=".display-user span")
	private WebElement userNameDisplayed;
```

## LOG OUT

```java
@FindBy(id="global-user-trigger")
	private WebElement btnUser;

@FindBy(css="li:nth-child(2) [onclick='javascript:espn.memberservices.logout();return false;']")
	private WebElement btnLogIn;

@FindBy(css=".display-user span")
	private WebElement userNameDisplayed;

```

## DELETE ACCOUNT

```java
@FindBy(id="global-user-trigger")
	private WebElement btnUser;

@FindBy(css="li:nth-child(2) [tref='/members/v3_1/modifyAccount']")
	private WebElement btnModifyAccount;

@FindBy(id="cancel-account")
	private WebElement btnDeleteAccount;

@FindBy(css="[did-translate='deactivate.confirmation.buttons.confirm']")
	private WebElement btnDeleteConfirmation;

@FindBy(css=".display-user span")
	private WebElement userNameDisplayed;

```