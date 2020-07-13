package chap07;

import org.junit.jupiter.api.BeforeEach;

public class AutoDebitRegisterTest {

	private AutoDebitRegister register;

	@BeforeEach
	void setUp(){
		CardNumberValidator validator = new CardNumberValidator();
		AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
	}
}
