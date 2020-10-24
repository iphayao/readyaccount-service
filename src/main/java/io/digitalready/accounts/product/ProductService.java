package io.digitalready.accounts.product;

import io.digitalready.accounts.common.exception.ProductNotFoundException;
import io.digitalready.accounts.product.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Flux<Product> findProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> findProductById(String id) {
        return productRepository.findById(UUID.fromString(id))
                .switchIfEmpty(Mono.error(new ProductNotFoundException(id)));
    }

    public Mono<Product> createNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> editProductById(String id, Product product) {
        return productRepository.findById(UUID.fromString(id))
                .flatMap(p -> {
                    productMapper.update(product, p);
                    return productRepository.save(p);
                });
    }

    public Mono<Void> removeProductById(String id) {
        return productRepository.findById(UUID.fromString(id))
                .flatMap(productRepository::delete);
    }

}
