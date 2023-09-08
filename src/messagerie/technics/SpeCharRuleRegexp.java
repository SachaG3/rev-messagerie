package messagerie.technics;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SpeCharRuleRegexp extends speCharsRule{
    @Override
    public boolean check(String passwordSeq){
        String regExpr="["+ SPE_CHARS +"]{1}";
        Pattern pattern=Pattern.compile(regExpr);
        Matcher matcher = pattern.matcher(passwordSeq);
        return matcher.results().count()>= nbrChar;
    }

}
