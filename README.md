# GWTJsqlParser

GWT wrapper to enable using the [JSqlParser](https://github.com/JSQLParser/JSqlParser) in GWT browser applications. Provides necessary super sources to support parsing of Strings, but not InputStreams.

## Disclaimer

GWT needs all the sources in the build path to be able to compile to javascript.

Currently GWTJsqlParser configured to wrap version 1.2-SNAPSHOT which is not in a maven repo. So library jars are sought on local file system. Update path in `build.gradle` accordingly.
Run gradlew `jar` task to build GWTJsqlParser.

## Usage

Add net.sf.jsqlparser.JSqlParser to your module descriptor:

```xml
	<!-- Inherit JSqlParser GWT wrapper -->
	<inherits name='net.sf.jsqlparser.JSqlParser' />
```
Now you are free to use the parser in your client code

~~~
	Statement result = CCJSqlParserUtil.parse("SELECT A, B, C FROM TABL1 WHERE ID=5");
~~~

## Limitations

You can only use Strings as input to the parser, trying to use InputStream will fail on the client side. This is due to the fact that the GWT JRE emulation does not include these classes.

## Known issues

Compilation errors in `<super-source>` in IDE.
These may occur for example in `super/java.util.regex.Pattern#matcher`.
Due to the fact that jdk class takes precedence by being on the classpath before the module sources.
To change the order in Intellij IDEA go to `File/Project Structure.../Modules/Dependencies`

There are jars in git history. To avoid downloading them do a shallow clone.