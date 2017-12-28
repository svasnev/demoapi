package pro.finance.demoapi.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

	public void validateCardNumber(String cardNumber) throws IllegalArgumentException{

		if(cardNumber == null && cardNumber.length()==16){
			throw new IllegalArgumentException();
		}
	}


}
