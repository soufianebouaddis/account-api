package os.org.hype.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.org.hype.model.context.AccountContext;
import os.org.hype.repository.AccountRepository;

@Component("step.accout.update")
@RequiredArgsConstructor
public class UpdateProcessor implements ProcessorStep<AccountContext> {

    private final AccountRepository repository;

    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        repository.findById(ctx.getId())
                .ifPresentOrElse(account -> {
                    account.setReference(ctx.getReference());
                    account.setRib(ctx.getRib());
                    account.setBalance(ctx.getBalance());
                    account.setCurrency(ctx.getCurrency());
                    account.setBlocked(ctx.isBlocked());
                    account.setAccountStatus(ctx.getAccountStatus());
                    repository.save(account);
                }, () -> ctx.fail("Account not found"));
    }
}
