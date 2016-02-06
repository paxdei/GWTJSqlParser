package java.util.regex;

import com.google.gwt.regexp.shared.RegExp;

public class Pattern {
  

  /**
   * Enables Unix lines mode.
   *
   * <p> In this mode, only the <tt>'\n'</tt> line terminator is recognized
   * in the behavior of <tt>.</tt>, <tt>^</tt>, and <tt>$</tt>.
   *
   * <p> Unix lines mode can also be enabled via the embedded flag
   * expression&nbsp;<tt>(?d)</tt>.
   */
  public static final int UNIX_LINES = 0x01;

  /**
   * Enables case-insensitive matching.
   *
   * <p> By default, case-insensitive matching assumes that only characters
   * in the US-ASCII charset are being matched.  Unicode-aware
   * case-insensitive matching can be enabled by specifying the {@link
   * #UNICODE_CASE} flag in conjunction with this flag.
   *
   * <p> Case-insensitive matching can also be enabled via the embedded flag
   * expression&nbsp;<tt>(?i)</tt>.
   *
   * <p> Specifying this flag may impose a slight performance penalty.  </p>
   */
  public static final int CASE_INSENSITIVE = 0x02;

  /**
   * Permits whitespace and comments in pattern.
   *
   * <p> In this mode, whitespace is ignored, and embedded comments starting
   * with <tt>#</tt> are ignored until the end of a line.
   *
   * <p> Comments mode can also be enabled via the embedded flag
   * expression&nbsp;<tt>(?x)</tt>.
   */
  public static final int COMMENTS = 0x04;

  /**
   * Enables multiline mode.
   *
   * <p> In multiline mode the expressions <tt>^</tt> and <tt>$</tt> match
   * just after or just before, respectively, a line terminator or the end of
   * the input sequence.  By default these expressions only match at the
   * beginning and the end of the entire input sequence.
   *
   * <p> Multiline mode can also be enabled via the embedded flag
   * expression&nbsp;<tt>(?m)</tt>.  </p>
   */
  public static final int MULTILINE = 0x08;

  /**
   * Enables literal parsing of the pattern.
   *
   * <p> When this flag is specified then the input string that specifies
   * the pattern is treated as a sequence of literal characters.
   * Metacharacters or escape sequences in the input sequence will be
   * given no special meaning.
   *
   * <p>The flags CASE_INSENSITIVE and UNICODE_CASE retain their impact on
   * matching when used in conjunction with this flag. The other flags
   * become superfluous.
   *
   * <p> There is no embedded flag character for enabling literal parsing.
   * @since 1.5
   */
  public static final int LITERAL = 0x10;

  /**
   * Enables dotall mode.
   *
   * <p> In dotall mode, the expression <tt>.</tt> matches any character,
   * including a line terminator.  By default this expression does not match
   * line terminators.
   *
   * <p> Dotall mode can also be enabled via the embedded flag
   * expression&nbsp;<tt>(?s)</tt>.  (The <tt>s</tt> is a mnemonic for
   * "single-line" mode, which is what this is called in Perl.)  </p>
   */
  public static final int DOTALL = 0x20;

  /**
   * Enables Unicode-aware case folding.
   *
   * <p> When this flag is specified then case-insensitive matching, when
   * enabled by the {@link #CASE_INSENSITIVE} flag, is done in a manner
   * consistent with the Unicode Standard.  By default, case-insensitive
   * matching assumes that only characters in the US-ASCII charset are being
   * matched.
   *
   * <p> Unicode-aware case folding can also be enabled via the embedded flag
   * expression&nbsp;<tt>(?u)</tt>.
   *
   * <p> Specifying this flag may impose a performance penalty.  </p>
   */
  public static final int UNICODE_CASE = 0x40;

  /**
   * Enables canonical equivalence.
   *
   * <p> When this flag is specified then two characters will be considered
   * to match if, and only if, their full canonical decompositions match.
   * The expression <tt>"a&#92;u030A"</tt>, for example, will match the
   * string <tt>"&#92;u00E5"</tt> when this flag is specified.  By default,
   * matching does not take canonical equivalence into account.
   *
   * <p> There is no embedded flag character for enabling canonical
   * equivalence.
   *
   * <p> Specifying this flag may impose a performance penalty.  </p>
   */
  public static final int CANON_EQ = 0x80;

  /**
   * Enables the Unicode version of <i>Predefined character classes</i> and
   * <i>POSIX character classes</i>.
   *
   * <p> When this flag is specified then the (US-ASCII only)
   * <i>Predefined character classes</i> and <i>POSIX character classes</i>
   * are in conformance with
   * <a href="http://www.unicode.org/reports/tr18/"><i>Unicode Technical
   * Standard #18: Unicode Regular Expression</i></a>
   * <i>Annex C: Compatibility Properties</i>.
   * <p>
   * The UNICODE_CHARACTER_CLASS mode can also be enabled via the embedded
   * flag expression&nbsp;<tt>(?U)</tt>.
   * <p>
   * The flag implies UNICODE_CASE, that is, it enables Unicode-aware case
   * folding.
   * <p>
   * Specifying this flag may impose a performance penalty.  </p>
   * @since 1.7
   */
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
