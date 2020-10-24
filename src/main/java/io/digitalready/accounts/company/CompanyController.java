package io.digitalready.accounts.company;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.common.model.ApiSuccessResponse;
import io.digitalready.accounts.company.model.CompanyBodyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @GetMapping
    public Mono<ApiResponse> getCompany() {
        return companyService.findCompanyInfo()
                .map(companyMapper::toDto)
                .collectList()
                .map(ApiSuccessResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse> postCompany(@RequestBody CompanyBodyDto company) {
        return companyService.createCompany(companyMapper.toEntity(company))
                .doOnSuccess(c -> log.info("Created company info of '{}' - {}", c.getId(), c.getName()))
                .map(companyMapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse> putCompany(@PathVariable Long id, @RequestBody CompanyBodyDto company) {
        return companyService.editCompanyById(id, companyMapper.toEntity(company))
                .doOnSuccess(c -> log.info("Updated company info of '{}' - {}", c.getId(), c.getName()))
                .map(companyMapper::toDto)
                .map(ApiSuccessResponse::of);

    }

}
