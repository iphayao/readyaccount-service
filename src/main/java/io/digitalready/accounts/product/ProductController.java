package io.digitalready.accounts.product;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.common.model.ApiSuccessResponse;
import io.digitalready.accounts.product.model.ProductBodyDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper mapper;

    public ProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public Mono<ApiResponse> getProducts() {
        return productService.findProducts()
                .map(mapper::toDto)
                .collectList()
                .map(ApiSuccessResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse> getProductById(@PathVariable String id) {
        return productService.findProductById(id)
                .map(mapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse> postProduct(@RequestBody ProductBodyDto product) {
        return productService.createNewProduct(mapper.toEntity(product))
                .map(mapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse> editProductById(@PathVariable String id, @RequestBody ProductBodyDto product) {
        return productService.editProductById(id, mapper.toEntity(product))
                .map(mapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable String id) {
        return productService.removeProductById(id);
    }

}