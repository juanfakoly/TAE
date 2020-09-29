# ESPN TEST AUTOMATION

## HOW RUN IT



first you need finding the file here `src/test/java/com/automation/espn/Suite.xml` 

once there you should choose the web browser to run the test 

`chrome` or `firefox`

```xml
<parameter name="browser" value="" />
```
there you should find another parameters

```xml
<parameter name="firstName" value="" />
<parameter name="lastName" value="" />
<parameter name="email" value="" />
<parameter name="password" value="" />
```

* IS NECESSARY SET EVERY VALUE TO THESE PARAMETERS.


- You should add the drivers in the following path `src/test/`
and modify the property `System.setProperty()` into `MyDriver.java`

`MyDriver.java` could found in `src/java/com/automation/espn/`