package io.digitalready.accounts.product;

import io.digitalready.accounts.common.exception.ProductNotFoundException;
import io.digitalready.accounts.product.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Flux<Product> findProducts(Long companyId) {
        return productRepository.findByCompanyId(companyId);
    }

    public Mono<Product> findProductById(Long companyId, Long id) {
        return productRepository.findByIdAndCompanyId(id, companyId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException(String.valueOf(id))));
    }

    public Mono<Product> createNewProduct(Long companyId, Product product) {
        product.setCompanyId(companyId);
        return productRepository.save(product);
    }

    public Mono<Product> editProductById(Long companyId, Long id, Product product) {
        return productRepository.findByIdAndCompanyId(id, companyId)
                .flatMap(p -> {
                    productMapper.update(product, p);
                    return productRepository.save(p);
                });
    }

    public Mono<Void> removeProductById(Long companyId, Long id) {
        return productRepository.findByIdAndCompanyId(id, companyId)
                .flatMap(productRepository::delete);
    }

}
