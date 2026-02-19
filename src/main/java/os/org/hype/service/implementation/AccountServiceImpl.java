package os.org.hype.service.implementation;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import os.org.hype.core.AccountBaseService;
import os.org.hype.core.AccountPipelineRegistry;
import os.org.hype.core.AppServiceName;
import os.org.hype.dto.request.AccountCreateRequest;
import os.org.hype.model.context.AccountContext;
import os.org.hype.model.context.AccountPageContext;
import os.org.hype.model.enums.AccountPipeline;
import os.org.hype.model.enums.AccountStatus;
import os.org.hype.model.enums.ServiceKeys;
import os.org.hype.repository.AccountRepository;
import os.org.hype.service.AccountService;

@Service
@AppServiceName(ServiceKeys.ACCOUNT_SERVICE)
public class AccountServiceImpl extends AccountBaseService implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(
            AccountRepository accountRespository,
            AccountPipelineRegistry pipelineRegistry
    ) {
        this.accountRepository = accountRespository;
        this.registry = pipelineRegistry;
    }

    @Override
    public AccountContext save(AccountCreateRequest account) {
        AccountContext ctx = AccountContext.builder()
                .reference(account.getReference())
                .rib(account.getRib())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .isBlocked(false)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
        // process is a function in AccountBaseService which takes a pipeline and a context, executes the pipeline with the context, and returns the processed context
        return process(AccountPipeline.ACCOUNT_CREATE, ctx);
    }

    @Override
    public AccountContext update(AccountCreateRequest account, Long id) {

        AccountContext ctx = AccountContext.builder()
                .id(id)
                .reference(account.getReference())
                .rib(account.getRib())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .isBlocked(false)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
        return process(AccountPipeline.ACCOUNT_UPDATE, ctx);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountContext findById(Long id) {
        AccountContext ctx = AccountContext.builder()
                    .id(id)
                    .build();
        return process(AccountPipeline.ACCOUNT_FIND_BY_ID, ctx);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountPageContext findAll(int page, int size) {
        AccountPageContext ctx = AccountPageContext.builder()
                    .page(page)
                    .size(size)
                    .build();
        process(AccountPipeline.ACCOUNT_FIND_ALL, ctx);
        return ctx;
    }

    @Override
    public void deleteById(Long id) {
        AccountContext ctx = AccountContext.builder()
                .id(id)
                .build();
        process(AccountPipeline.ACCOUNT_DELETE, ctx);
    }
}
