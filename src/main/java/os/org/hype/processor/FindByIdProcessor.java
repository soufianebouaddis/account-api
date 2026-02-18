package os.org.hype.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.org.hype.model.context.AccountContext;
import os.org.hype.repository.AccountRepository;

@Component("step.account.findById")
@RequiredArgsConstructor
public class FindByIdProcessor implements ProcessorStep<AccountContext> {
    private final AccountRepository repository;

    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        var account = repository.findById(ctx.getId()).orElseGet(
                () -> {
                    ctx.fail("Account not found");
                    return null;
                }
        );
        if (!ctx.isSuccess()) return;
        ctx.setReference(account.getReference());
        ctx.setRib(account.getRib());
        ctx.setBalance(account.getBalance());
        ctx.setCurrency(account.getCurrency());
        ctx.setBlocked(account.isBlocked());
        ctx.setAccountStatus(account.getAccountStatus());
    }
}
