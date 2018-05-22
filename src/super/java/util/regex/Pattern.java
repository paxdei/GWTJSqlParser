package java.util.regex;

import com.google.gwt.regexp.shared.RegExp;

public class Pattern {
  
  public static final int UNIX_LINES = 0x01;

  public static final int CASE_INSENSITIVE = 0x02;

  public static final int COMMENTS = 0x04;

  public static final int MULTILINE = 0x08;

  public static final int LITERAL = 0x10;

  public static final int DOTALL = 0x20;

  public static final int UNICODE_CASE = 0x40;

  public static final int CANON_EQ = 0x80;

  public static final int UNICODE_CHARACTER_CLASS = 0x100;
  
  public static Pattern compile(String pattern)
  {
    return new Pattern(pattern);
  }
  
  public static Pattern compile(String regex, int flags) {
    return new Pattern(regex, flags);
  }
  
  private String regex;
  private RegExp regExp;
  private int flags;
  
  protected Pattern(String regex)
  {
    this.regex = regex;
    this.regExp = RegExp.compile(regex);
  }
  
  protected Pattern(String regex, int flags)
  {
    this.regex = regex;
    this.flags = flags;

    String fl = "";
    
    if((flags & CASE_INSENSITIVE) > 0)
    {
      fl += "i";
    }
    if((flags & MULTILINE) > 0)
    {
      fl += "m";
    }
    this.regExp = RegExp.compile(regex, fl);
  }
  
  public Matcher matcher(CharSequence input)
  {
      return new Matcher(regExp, input.toString());
  }
}
