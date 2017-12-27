package pro.finance.demoapi.web.rest;


import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(method = RequestMethod.GET, params  ="email" )
	public SystemAccount getByEmail(@RequestParam("email") String email){
		return systemAccountRepository.findOneByEmail(email)
			.orElseThrow(() -> new EntityNotFoundException("System account with such email" + email + " not found"));
	}

}
