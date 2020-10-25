package io.digitalready.accounts.company;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.company.model.CompanyBodyDto;
import io.digitalready.accounts.company.model.CompanyRespDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public Mono<ApiResponse<List<CompanyRespDto>>> getCompany() {
        return companyService.findCompanyInfo()
                .map(companyMapper::toDto).collectList()
                .map(ApiResponse::success);
    }

    @PostMapping
    public Mono<ApiResponse<CompanyRespDto>> postCompany(@RequestBody CompanyBodyDto company) {
        return companyService.createCompany(companyMapper.toEntity(company))
                .map(companyMapper::toDto)
                .map(ApiResponse::success);
    }

    @PutMapping("/{companyId}")
    public Mono<ApiResponse<CompanyRespDto>> putCompany(@PathVariable Long companyId,
                                                        @RequestBody CompanyBodyDto company) {
        return companyService.editCompanyById(companyId, companyMapper.toEntity(company))
                .map(companyMapper::toDto)
                .map(ApiResponse::success);

    }

}
