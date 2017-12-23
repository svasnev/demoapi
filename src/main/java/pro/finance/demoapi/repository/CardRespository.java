package pro.finance.demoapi.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import pro.finance.demoapi.domain.Card;

public interface CardRespository extends CrudRepository<Card, UUID>{

	List<Card> findAllBySystemAccountId(UUID systemAccountId);

}
