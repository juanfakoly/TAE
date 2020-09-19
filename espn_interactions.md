# INTERACTIONS INTO ESPN PAGE

## CREATE AN ACCOUNT

```java
btnUser.click();
btnLogIn.click();
btnSignIn.click();
txtName.sendKeys("Juan");
txtLastName.sendKeys("Munoz");
txtEmail.sendKeys("juan1234@gmail.com");
txtNewPassword.sendKeys("12345678");
btnCreateAccount.click();
btnUser.click();
Assert.assertTrue(userNameDisplayed.isDisplayed());
```

## LOG IN

```java
btnUser.click();
btnLogIn.click();
txtUserName.sendKeys("juan1234@gmail.com");
txtPassword.sendKeys("12345678");
btnEnter.click();
btnUser.click();
Assert.assertTrue(userNameDisplayed.isDisplayed());
```

## LOG OUT

```java
btnUser.click();
if (userNameDisplayed.isDisplayed()) btnLogOut.click();
Assert.assertTrue(!userNameDisplayed.isDisplayed());
```

## DELETE ACCOUNT

```java
btnUser.click();
if (userNameDisplayed.isDisplayed()) {
	btnModifyAccount.click();
	btnDeleteAccount.click();
	btnDeleteConfirmation.click();
} else {
	Login();
}
Assert.assertTrue(!userNameDisplayed.isDisplayed());
```