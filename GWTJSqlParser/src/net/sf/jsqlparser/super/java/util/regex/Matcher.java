package java.util.regex;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

public class Matcher {

  private RegExp regexp;
  private String input;
  private MatchResult matchResult;
  
  public Matcher(RegExp regexp, String input) {
    this.regexp = regexp;
    this.input = input;
    
    this.matchResult = regexp.exec(input);
  }
  
  public boolean find()
  {
    return regexp.test(input);
  }
  
  public String group(int group)
  {
    return matchResult.getGroup(group);
  }

}
