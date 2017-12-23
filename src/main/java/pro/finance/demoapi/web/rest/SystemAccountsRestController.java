package pro.finance.demoapi.web.rest;


import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pro.finance.demoapi.domain.SystemAccount;
import pro.finance.demoapi.repository.SystemAccountRepository;

@RestController
@RequestMapping("/api/systemAccounts")
public class SystemAccountsRestController {

	@Autowired
	private SystemAccountRepository systemAccountRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SystemAccount getById(@PathVariable("id") UUID id){

		return systemAccountRepository.findOneById(id)
			.orElseThrow(() -> new EntityNotFoundException("System account with id" + id.toString() +  "not found"));

	}

}
