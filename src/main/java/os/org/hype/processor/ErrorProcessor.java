package os.org.hype.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import os.org.hype.model.context.AccountContext;

@Component("step.account.errorLogger")
@Slf4j
public class ErrorProcessor implements ProcessorStep<AccountContext> {
    @Override
    public void execute(AccountContext ctx) {
        if (!ctx.isSuccess()) {
            log.error("[ACCOUNT-ERROR] {}", ctx.getErrorMessage());
        }
    }
}