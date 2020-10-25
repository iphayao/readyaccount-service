package io.digitalready.accounts.contact;

import io.digitalready.accounts.contact.model.Contract;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ContractRepository extends ReactiveCrudRepository<Contract, Long> {

    Mono<Contract> findByIdAndCompanyId(Long id, Long companyId);

}
