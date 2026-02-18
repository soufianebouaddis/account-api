package os.org.hype.processor;

import os.org.hype.model.context.AccountContext;

@FunctionalInterface
public interface AppProcessors {
    void execute(AccountContext ctx);
}
