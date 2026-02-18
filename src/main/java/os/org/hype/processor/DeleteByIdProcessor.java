package os.org.hype.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.org.hype.model.context.AccountContext;
import os.org.hype.repository.AccountRepository;


// here spring will automatically create and register this
// bean in the application context with the name "step.account.deleteById"
// and inject the required dependencies (AccountRespository) into it.
// The execute method will be called when this processor step is executed in the pipeline,
// allowing you to implement the logic for deleting an account by its ID using the repository.

@Component("step.account.deleteById")
@RequiredArgsConstructor
public class DeleteByIdProcessor implements ProcessorStep<AccountContext> {
    private final AccountRepository respository;
    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) return;
        respository.deleteById(ctx.getId());
    }
}
