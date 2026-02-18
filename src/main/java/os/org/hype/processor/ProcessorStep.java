package os.org.hype.processor;

import os.org.hype.model.context.AccountContext;

@FunctionalInterface
public interface ProcessorStep<T extends AccountContext> {
    void execute(T ctx);
}
