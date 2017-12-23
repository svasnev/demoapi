package pro.finance.demoapi.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import pro.finance.demoapi.domain.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, UUID> {

	List<Wallet> findAllBySystemAccountId(UUID systemAccountId);

}
