package pro.finance.demoapi.web.rest;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import pro.finance.demoapi.domain.Card;
import pro.finance.demoapi.repository.CardRespository;
import pro.finance.demoapi.repository.SystemAccountRepository;
import pro.finance.demoapi.services.ValidatorService;

@RestController
@RequestMapping("/api/{systemAccountId}/cards")
public class CardsRestController {

	@Autowired
	private CardRespository cardRespository;

	@Autowired
	private ValidatorService validatorService;

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Card> findAllByAccount(@PathVariable UUID systemAccountId) {
		return cardRespository.findAllBySystemAccountId(systemAccountId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addCard(@PathVariable UUID systemAccountId, @RequestBody String cardNumber){

		validatorService.validateCardNumber(cardNumber);

		cardRespository.save(new Card(systemAccountRepository.findOne(systemAccountId), cardNumber));
	}
}
