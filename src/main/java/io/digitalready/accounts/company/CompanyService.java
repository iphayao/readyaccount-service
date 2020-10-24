package io.digitalready.accounts.company;

import io.digitalready.accounts.company.model.Company;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public Flux<Company> findCompanyInfo() {
        return companyRepository.findAll();
    }

    public Mono<Company> createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Mono<Company> editCompanyById(Long id, Company company) {
        return companyRepository.findById(id)
                .flatMap(c -> {
                    companyMapper.update(company, c);
                    return companyRepository.save(c);
                });
    }

}
