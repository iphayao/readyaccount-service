package io.digitalready.accounts.company;

import io.digitalready.accounts.company.model.Company;
import io.digitalready.accounts.user.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserService userService;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper, UserService userService) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.userService = userService;
    }

    public Flux<Company> findCompanyInfo() {
        return userService.findUserCurrentAuthenticated()
                .flatMapMany(user -> companyRepository.findByUserId(user.getId()));
    }

    public Mono<Company> createCompany(Company company) {
        return userService.findUserCurrentAuthenticated()
                .flatMap(user -> {
                    company.setUserId(user.getId());
                    return companyRepository.save(company);
                });
    }

    public Mono<Company> editCompanyById(Long id, Company company) {
        return userService.findUserCurrentAuthenticated()
                .flatMap(user -> companyRepository.findByIdAndUserId(id, user.getId())
                        .flatMap(exist -> {
                            companyMapper.update(company, exist);
                            return companyRepository.save(exist);
                        })
                );
    }

}
