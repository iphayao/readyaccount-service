package io.digitalready.billary.product;

import io.digitalready.billary.common.model.ApiResponse;
import io.digitalready.billary.common.model.ApiSuccessResponse;
import io.digitalready.billary.product.model.ProductReq;
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
                .map(mapper::toProductRes)
                .collectList()
                .map(ApiSuccessResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse> getProductById(@PathVariable String id) {
        return productService.findProductById(id)
                .map(mapper::toProductRes)
                .map(ApiSuccessResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse> postProduct(@RequestBody ProductReq product) {
        return productService.createNewProduct(mapper.toProduct(product))
                .map(mapper::toProductRes)
                .map(ApiSuccessResponse::of);
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse> editProductById(@PathVariable String id, @RequestBody ProductReq product) {
        return productService.editProductById(id, mapper.toProduct(product))
                .map(mapper::toProductRes)
                .map(ApiSuccessResponse::of);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable String id) {
        return productService.removeProductById(id);
    }

}
