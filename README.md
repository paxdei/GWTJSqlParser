# GWTJsqlParser

GWT wrapper to enable using the (JSqlParser)[https://github.com/JSQLParser/JSqlParser] in GWT browser applications. Provides necessary super sources to support parsing of Strings, but not InputStreams.

## Disclaimer

JSqlParser uses javacc to generate java sources from a jjt file, these are not included in the source distributions of their releases. GWT needs all the sources in the build path to be able to compile to javascript.

So you have to generate these sources yourself using the maven target on their project and add those sources to your project's classpath.

Or you can download a (zip file with all necessary jars for the 0.9.5-SNAPSHOT release here)[https://github.com/paxdei/GWTJsqlParser/releases/download/0.9.5-SNAPSHOT/gwt-jsqlparser-0.9.5-SNAPSHOT.zip]


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
