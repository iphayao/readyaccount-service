package io.digitalready.accounts.company;

import io.digitalready.accounts.company.model.Company;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyRepository extends ReactiveCrudRepository<Company, Long> {

    Flux<Company> findByUserId(Long userId);
    Mono<Company> findByIdAndUserId(Long id, Long userId);

}
