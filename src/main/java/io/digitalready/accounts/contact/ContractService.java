package io.digitalready.accounts.contact;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.contact.model.Contract;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    public ContractService(ContractRepository contractRepository, ContractMapper contractMapper) {
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
    }

    public Flux<Contract> findAllContract(Long companyId) {
        return contractRepository.findAll();
    }

    public Mono<Contract> createNewContract(Long companyId, Contract contract) {
        contract.setCompanyId(companyId);
        return contractRepository.save(contract);
    }

    public Mono<Contract> editContractById(Long companyId, Long id, Contract contract) {
        return contractRepository.findByIdAndCompanyId(id, companyId)
                .flatMap(c -> {
                    contractMapper.update(contract, c);
                    return contractRepository.save(c);
                });

    }

    public Mono<Contract> findContractById(Long companyId, Long id) {
        return contractRepository.findByIdAndCompanyId(id, companyId);
    }
}
