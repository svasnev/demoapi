package pro.finance.demoapi.web.rest;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import pro.finance.demoapi.domain.Card;
import pro.finance.demoapi.repository.CardRespository;

@RestController
@RequestMapping("/api/{systemAccountId}/cards")
public class CardsRestController {

	@Autowired
	private CardRespository cardRespository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Card> findAllByAccount(@PathVariable UUID systemAccountId) {
		return cardRespository.findAllBySystemAccountId(systemAccountId);
	}


}
