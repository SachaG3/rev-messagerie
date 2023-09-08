package messagerie.technics;

public class speCharsRule implements Rule{
    protected final String SPE_CHARS="!@#$%^&*()_+{}[]:\";'<>?,./\\|`~-=";
    protected int nbrChar;
    public speCharsRule(){
        this(1);
    }
    public speCharsRule(int nbrChar){
        this.nbrChar=nbrChar;
    }
    @Override
    public boolean check(String passwordSeq) {
        int countCharsLeft= nbrChar;
        for(char c:SPE_CHARS.toCharArray()){
            if(passwordSeq.contains(c+"")){
                countCharsLeft--;
            }
            if (countCharsLeft==0){
                return true;
            }
        }
        return false;
    }
}
