# BANK INTERACTIONS 

## BACKGROUND 

```java
@Before
public void init() {
	cardScanning();
	verifyAccount();
	getTransactionMenu();
}

@After
public void closeTransaction() {
	closeAccount();
	ejectCard();
}
```

## CHECK ACCOUNT BALANCE

```java
btnCheckBalance.click();
txtCheckBalance.isDisplayed();
```

## WITHDRAW CASH

```java
checkAccountBalance = checkAccountBalance();
btnWithdrawCash.click();
txtAmountOfCash.sendKey(amount);
btnAcceptWithdraw.click();
if (checkAccountBalance > 0 && checkAccountBalance > amount) btnConfirmWithdraw.click(); btnCancelWithdraw.click(); 
```

## TRANSFER MONEY

```java
checkAccountBalance = checkAccountBalance();
btnTransferMoney.click();
txtBankName.sendKey(bankName);
txtAccountType.sendKey(accountType);
txtAccountNumber.sendKey(accountNumber);
txtAmountOfMoney.sendKey(amountOfMoney);
btnSend.click();
if (checkAccountBalance > 0 && checkAccountBalance > amountOfMoney) btnConfirmTransfer.click(); btnCancelTransfer.click(); 
```