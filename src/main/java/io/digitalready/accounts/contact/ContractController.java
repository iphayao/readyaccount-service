package io.digitalready.accounts.contact;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.common.model.ApiSuccessResponse;
import io.digitalready.accounts.contact.model.ContractBodyDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;
    private final ContractMapper contractMapper;

    public ContractController(ContractService contractService, ContractMapper contractMapper) {
        this.contractService = contractService;
        this.contractMapper = contractMapper;
    }

    @GetMapping
    public Mono<ApiResponse> getContracts(@RequestHeader("Company-ID") Long companyId) {
        return contractService.findAllContract(companyId)
                .map(contractMapper::toDto)
                .collectList()
                .map(ApiSuccessResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse> getContract(@RequestHeader("Company-Id") Long companyId, @PathVariable Long id) {
        return contractService.findContractById(companyId, id)
                .map(contractMapper::toDto)
                .map(ApiSuccessResponse::of);

    }

    @PostMapping
    public Mono<ApiResponse> postContract(@RequestHeader("Company-ID") Long companyId,
                                          @RequestBody ContractBodyDto contractDto) {
        return contractService.createNewContract(companyId, contractMapper.toEntity(contractDto))
                .map(contractMapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse> putContract(@RequestHeader("Company-ID") Long companyId,
                                         @PathVariable Long id,
                                         @RequestBody ContractBodyDto contractDto) {
        return contractService.editContractById(companyId, id, contractMapper.toEntity(contractDto))
                .map(contractMapper::toDto)
                .map(ApiSuccessResponse::of);

     }

}
