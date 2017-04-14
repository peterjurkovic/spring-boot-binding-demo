
# spring-boot-binding-demo


Demo application to ilustrate binding inconsitency between ENV variables and properties from properties file

The application contains a bean, which maps properties `"com.text.*"` to a map

```java
@Component
@ConfigurationProperties("com.text")
public class Props {
    private Map<String, Map<String, String>> property;
}
```

in the `application.properties` is defined 

```
com.test.property.foo.bar=value
```
Run `DemoApplication.java` - the applications starts proppelly, in the stdout you will see expected `Props [property={foo={bar=value}}]` 


Setup ENV variale `export COM_TEST_PROPERTY_XXX_YYY=VALUE`


Run `DemoApplication.java` - The application fails to start


```
Binding to target Props [property={foo={bar=value}}] failed:

    Property: com.test.property[XXX_YYY]
    Value: VALUE
    Reason: Failed to convert property value of type 'java.lang.String' to required type 'java.util.Map' for property 'property[XXX_YYY]'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'java.util.Map' for property 'property[XXX_YYY]': no matching editors or conversion strategy found

```
