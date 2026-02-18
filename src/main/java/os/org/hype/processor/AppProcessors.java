package os.org.hype.processor;

import org.springframework.stereotype.Service;
import os.org.hype.model.context.AccountContext;

import java.util.List;

@Service
public class AppProcessors {
    private final List<ProcessorStep<AccountContext>> steps;

    public AppProcessors(List<ProcessorStep<AccountContext>> steps) {
        this.steps = steps;
    }

    public void execute(AccountContext ctx) {
        for (ProcessorStep<AccountContext> step : steps) {
            step.execute(ctx);
        }
    }
}
