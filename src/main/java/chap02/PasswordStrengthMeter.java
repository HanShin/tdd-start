package chap02;

/**
 * Create by hanshin on 2020/06/08 11:44 오전
 */
public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        if(s == null || s.isEmpty()){
            return PasswordStrength.INVALID;
        }

        int metCounts = getMetCriteriaCounts(s);

        if(metCounts <= 1){
            return PasswordStrength.WEAK;
        }
        if(metCounts == 2){
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;

        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containUpp = meetsContainingUppercaseCriteria(s);

        if(lengthEnough) metCounts++;
        if(containsNum) metCounts++;
        if(containUpp) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                return true;
            }
        }
        return false;
    }
}
