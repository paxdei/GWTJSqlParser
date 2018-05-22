package java.io;

import java.nio.charset.Charset;

import com.google.gwt.core.shared.GwtIncompatible;


public class InputStreamReader extends Reader {

    public InputStreamReader(InputStream in) {
    	throw new UnsupportedOperationException("Not Supported in GWT");
    }

    public InputStreamReader(InputStream in, String charsetName)
        throws UnsupportedEncodingException
    {
    	throw new UnsupportedOperationException("Not Supported in GWT");
    }

    public InputStreamReader(InputStream in, Charset cs) {
    	throw new UnsupportedOperationException("Not Supported in GWT");
    }

    public String getEncoding() {
        return "UTF-8";
    }

    public int read(char cbuf[], int offset, int length) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws IOException {

    }


}
