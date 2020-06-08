package chap02;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create by hanshin on 2020/06/08 11:03 오전
 */
public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    @Test
    public void meetsAllCriteria_Then_Strong(){

        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    public void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    public void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwr", PasswordStrength.NORMAL);
    }

    @Test
    public void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    public void emptyInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    public void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    public void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    public void meetsOnlyNumberCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    public void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    public void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
