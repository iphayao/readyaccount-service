package io.digitalready.accounts.product;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.product.model.ProductBodyDto;
import io.digitalready.accounts.product.model.ProductRespDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public Mono<ApiResponse<List<ProductRespDto>>> getProducts(@RequestHeader("Company-ID") Long companyId) {
        return productService.findProducts(companyId)
                .map(mapper::toDto).collectList()
                .map(ApiResponse::success);
    }

    @GetMapping("/{productId}")
    public Mono<ApiResponse<ProductRespDto>> getProductById(@RequestHeader("Company-ID") Long companyId,
                                                            @PathVariable Long productId) {
        return productService.findProductById(companyId, productId)
                .map(mapper::toDto)
                .map(ApiResponse::success);
    }

    @PostMapping
    public Mono<ApiResponse<ProductRespDto>> postProduct(@RequestHeader("Company-ID") Long companyId,
                                                         @RequestBody ProductBodyDto product) {
        return productService.createNewProduct(companyId, mapper.toEntity(product))
                .map(mapper::toDto)
                .map(ApiResponse::success);
    }

    @PutMapping("/{productId}")
    public Mono<ApiResponse<ProductRespDto>> editProductById(@RequestHeader("Company-ID") Long companyId,
                                                             @PathVariable Long productId,
                                                             @RequestBody ProductBodyDto product) {
        return productService.editProductById(companyId, productId, mapper.toEntity(product))
                .map(mapper::toDto)
                .map(ApiResponse::success);
    }

    @DeleteMapping("/{productId}")
    public Mono<ApiResponse<Void>> deleteProductById(@RequestHeader("Company-ID") Long companyId,
                                                     @PathVariable Long productId) {
        return productService.removeProductById(companyId, productId)
                .map(ApiResponse::success);
    }

}
