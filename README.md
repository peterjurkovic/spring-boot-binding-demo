
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
com.text.property.v1.v2=test
```
Run `DemoApplication.java` - the applications starts proppelly, in the stdout you will see expected `property={v1={v2=test}}` 


Setup ENV variale `export COM_TEXT_PROPERTY_XXX_YYY=VALUE`


Run `DemoApplication.java` - The application fails to start


```
Binding to target Props [property={v1={v2=test}}] failed:

    Property: com.text.property[XXX_YYY]
    Value: VALUE
    Reason: Failed to convert property value of type 'java.lang.String' to required type 'java.util.Map' for property 'property[XXX_YYY]'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'java.util.Map' for property 'property[XXX_YYY]': no matching editors or conversion strategy found

```
