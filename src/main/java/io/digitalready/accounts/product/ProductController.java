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
    public Mono<ApiResponse> getProducts(@RequestHeader("Company-ID") Long companyId) {
        return productService.findProducts(companyId)
                .map(mapper::toDto)
                .collectList()
                .map(ApiSuccessResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse> getProductById(@RequestHeader("Company-ID") Long companyId,
                                            @PathVariable Long id) {
        return productService.findProductById(companyId, id)
                .map(mapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse> postProduct(@RequestHeader("Company-ID") Long companyId,
                                         @RequestBody ProductBodyDto product) {
        return productService.createNewProduct(companyId, mapper.toEntity(product))
                .map(mapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse> editProductById(@RequestHeader("Company-ID") Long companyId,
                                             @PathVariable Long id, @RequestBody ProductBodyDto product) {
        return productService.editProductById(companyId, id, mapper.toEntity(product))
                .map(mapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@RequestHeader("Company-ID") Long companyId,
                                        @PathVariable Long id) {
        return productService.removeProductById(companyId, id);
    }

}
