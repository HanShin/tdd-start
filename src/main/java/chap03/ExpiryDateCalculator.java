package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Create by hanshin on 2020/06/09 11:23 오전
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData){
        int monthsToAdd = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;
        if(payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, monthsToAdd);
        }else{
            return payData.getBillingDate().plusMonths(monthsToAdd);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int monthsToAdd) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(monthsToAdd);
        int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if(isSameDayOfMonth(candidateExp, dayOfFirstBilling)){
            int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if(dayLenOfCandiMon < dayOfFirstBilling){
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else{
            return candidateExp;
        }
    }

    private int lastDayOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(LocalDate candidateExp, int dayOfFirstBilling) {
        return dayOfFirstBilling != candidateExp.getDayOfMonth();
    }
}
