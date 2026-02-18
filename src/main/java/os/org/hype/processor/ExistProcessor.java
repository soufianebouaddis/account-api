package os.org.hype.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.org.hype.model.context.AccountContext;
import os.org.hype.repository.AccountRepository;

@Component("step.account.exist")
@RequiredArgsConstructor
public class ExistProcessor implements ProcessorStep<AccountContext> {
    private final AccountRepository repository;

    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        if (ctx.getId() == null || !repository.existsById(ctx.getId())) {
            ctx.fail("Account not found");
        }
    }
}
