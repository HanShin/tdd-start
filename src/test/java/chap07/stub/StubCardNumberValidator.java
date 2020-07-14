package chap07.stub;

import chap07.CardNumberValidator;
import chap07.CardValidity;

public class StubCardNumberValidator extends CardNumberValidator {
	private String invalidNo;

	public void setInvalidNo(String invalidNo){
		this.invalidNo = invalidNo;
	}

	public CardValidity validity(String cardNumber){
		if(invalidNo != null && invalidNo.equals(cardNumber)){
			return CardValidity.INVALID;
		}
		return CardValidity.VALID;
	}
}
