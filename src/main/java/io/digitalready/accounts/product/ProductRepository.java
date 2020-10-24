package io.digitalready.accounts.product;

import io.digitalready.accounts.product.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

    Flux<Product> findByCompanyId(Long companyId);
    Mono<Product> findByIdAndCompanyId(Long id, Long companyId);

}
