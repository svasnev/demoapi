package pro.finance.demoapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import pro.finance.demoapi.domain.SystemAccount;

public interface SystemAccountRepository extends CrudRepository<SystemAccount, UUID> {
	Optional<SystemAccount> findOneById(UUID id);
}
