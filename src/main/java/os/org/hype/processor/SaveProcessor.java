package os.org.hype.processor;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.org.hype.model.AccountApp;
import os.org.hype.model.context.AccountContext;
import os.org.hype.repository.AccountRepository;

@Component("step.account.save")
@RequiredArgsConstructor
public class SaveProcessor implements ProcessorStep<AccountContext> {
    private final AccountRepository repository;

    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        AccountApp account = AccountApp.builder()
                .reference(ctx.getReference())
                .rib(ctx.getRib())
                .balance(ctx.getBalance())
                .currency(ctx.getCurrency())
                .isBlocked(ctx.isBlocked())
                .accountStatus(ctx.getAccountStatus())
                .build();
        AccountApp saved = repository.save(account);
        ctx.setId(saved.getId());
    }
}
