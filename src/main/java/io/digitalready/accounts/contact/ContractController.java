package io.digitalready.accounts.contact;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.contact.model.ContractBodyDto;
import io.digitalready.accounts.contact.model.ContractRespDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public Mono<ApiResponse<List<ContractRespDto>>> getContracts(@RequestHeader("Company-ID") Long companyId) {
        return contractService.findAllContract(companyId)
                .map(contractMapper::toDto).collectList()
                .map(ApiResponse::success);
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse<ContractRespDto>> getContract(@RequestHeader("Company-Id") Long companyId,
                                                          @PathVariable Long id) {
        return contractService.findContractById(companyId, id)
                .map(contractMapper::toDto)
                .map(ApiResponse::success);

    }

    @PostMapping
    public Mono<ApiResponse<ContractRespDto>> postContract(@RequestHeader("Company-ID") Long companyId,
                                                           @RequestBody ContractBodyDto contractDto) {
        return contractService.createNewContract(companyId, contractMapper.toEntity(contractDto))
                .map(contractMapper::toDto)
                .map(ApiResponse::success);
    }

    @PutMapping("/{contractId}")
    public Mono<ApiResponse<ContractRespDto>> putContract(@RequestHeader("Company-ID") Long companyId,
                                                          @PathVariable Long contractId,
                                                          @RequestBody ContractBodyDto contractDto) {
        return contractService.editContractById(companyId, contractId, contractMapper.toEntity(contractDto))
                .map(contractMapper::toDto)
                .map(ApiResponse::success);

    }

    @DeleteMapping("/{contractId}")
    public Mono<ApiResponse<Void>> deleteContract(@RequestHeader("Company-ID") Long companyId,
                                                  @PathVariable Long contractId) {
        return contractService.deleteContractById(companyId, contractId)
                .map(ApiResponse::success);

    }

}
