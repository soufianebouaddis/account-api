package os.org.hype.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import os.org.hype.model.AccountApp;
import os.org.hype.model.context.AccountContext;
import os.org.hype.model.context.AccountPageContext;
import os.org.hype.model.context.AccountViewContext;
import os.org.hype.repository.AccountRepository;

import java.util.List;

@Component("step.account.findAll")
@RequiredArgsConstructor
public class FindAllProcessor implements ProcessorStep<AccountContext> {
    private final AccountRepository repository;


    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        AccountPageContext pageCtx = (AccountPageContext) ctx;
        PageRequest pageable = PageRequest.of(
                pageCtx.getPage(),
                pageCtx.getSize()
        );

        Page<AccountApp> page = repository.findAll(pageable);
        List<AccountViewContext> users = page.getContent().stream()
                .map(acc -> AccountViewContext.builder()
                        .id(acc.getId())
                        .reference(acc.getReference())
                        .rib(acc.getRib())
                        .balance(acc.getBalance())
                        .currency(acc.getCurrency())
                        .isBlocked(acc.isBlocked())
                        .accountStatus(acc.getAccountStatus())
                        .build()
                )
                .toList();
        pageCtx.setAccounts(users);
        pageCtx.setTotalElements(page.getTotalElements());
    }
}
