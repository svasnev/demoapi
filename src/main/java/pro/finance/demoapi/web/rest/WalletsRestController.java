package pro.finance.demoapi.web.rest;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import pro.finance.demoapi.domain.Wallet;
import pro.finance.demoapi.repository.WalletRepository;

@RestController
@RequestMapping("/api/{systemAccountId}/wallets")
public class WalletsRestController {

	@Autowired
	private WalletRepository walletRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Wallet> findAllByAccount(@PathVariable UUID systemAccountId) {
		return walletRepository.findAllBySystemAccountId(systemAccountId);
	}


}
