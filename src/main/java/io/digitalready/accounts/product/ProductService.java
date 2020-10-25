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

    public Mono<Product> findProductById(Long companyId, Long productId) {
        return productRepository.findByIdAndCompanyId(productId, companyId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException(String.valueOf(productId))));
    }

    public Mono<Product> createNewProduct(Long companyId, Product product) {
        product.setCompanyId(companyId);
        return productRepository.save(product);
    }

    public Mono<Product> editProductById(Long companyId, Long productId, Product product) {
        return productRepository.findByIdAndCompanyId(productId, companyId)
                .flatMap(p -> {
                    productMapper.update(product, p);
                    return productRepository.save(p);
                });
    }

    public Mono<Void> removeProductById(Long companyId, Long productId) {
        return productRepository.findByIdAndCompanyId(productId, companyId)
                .flatMap(productRepository::delete);
    }

}
