# BOOKING TEST AUTOMATION

## HOW RUN IT



first you need finding the file here `src/test/java/com/automation/booking/Suite.xml` 

once there you should choose the web browser to run the test 

`chrome` or `firefox`

```xml
<parameter name="browser" value="" />
```
there you should find another parameters

```xml
<parameter name="browser" value="" />
<parameter name="destination" value="Bogotá" />
<parameter name="adultNumber" value="" />
<parameter name="childrenNumber" value="" />
<parameter name="roomsNumber" value="" />
<parameter name="lastName" value="" />
<parameter name="email" value="" />
<parameter name="phoneNumber" value="" />
<parameter name="creditCardNumber" value="" />
<parameter name="cvc" value="" />
```

* IS NECESSARY SET EVERY VALUE TO THESE PARAMETERS.

only destination parameter works with `Bogotá` value.


- You should add the drivers in the following path `src/test/`
and modify the property `System.setProperty()` into `MyDriver.java`

`MyDriver.java` could found in `src/java/com/automation/booking/`