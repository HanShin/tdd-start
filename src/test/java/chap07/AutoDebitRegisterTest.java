package chap07;

import chap07.stub.StubCardNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegisterTest {
	private AutoDebitRegister register;
	private StubCardNumberValidator stubCardNumberValidator;
	private StubAutoDebitInfoRepository stubRepository;

	@BeforeEach
	void setUp(){
		CardNumberValidator validator = new CardNumberValidator();
		AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
		register = new AutoDebitRegister(validator,repository);
	}

	@Test
	void validCard(){
		// 업체에서 받은 테스트용 유효한 카드번호 사용
		AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
		RegisterResult result = this.register.register(req);
		assertEquals(CardValidity.VALID, result.getValidty());
	}

	@Test
	void theftCard(){
		// 업체0에서 받은 도난 테스트용 카드번호 사용
		AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
		RegisterResult result = this.register.register(req);
		assertEquals(CardValidity.THEFT, result.getValidty());
	}
}
