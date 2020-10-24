package io.digitalready.accounts.company;

import io.digitalready.accounts.company.model.Company;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CompanyRepository extends ReactiveCrudRepository<Company, Long> {
}
