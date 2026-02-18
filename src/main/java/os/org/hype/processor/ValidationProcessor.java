package os.org.hype.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.org.hype.model.context.AccountContext;
import os.org.hype.repository.AccountRepository;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component("step.account.validate")
public class ValidationProcessor implements ProcessorStep<AccountContext> {
    private final AccountRepository repository;

    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        if (isNull(ctx.getRib()) || ctx.getRib().isBlank()) {
            ctx.fail("Email is required");
            return;
        }
        if (isNull(ctx.getId()) && repository.existsByRib(ctx.getRib())) {
            ctx.fail("Email already exists");
        }
    }
}
