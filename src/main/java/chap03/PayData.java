package chap03;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * Create by hanshin on 2020/06/09 2:14 오후
 */
@Getter
@Builder
public class PayData {
    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;
}
