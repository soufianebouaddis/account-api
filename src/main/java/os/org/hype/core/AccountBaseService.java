package os.org.hype.core;

import os.org.hype.model.context.AccountContext;
import os.org.hype.model.enums.AccountPipeline;
import os.org.hype.processor.AppProcessors;

public abstract class AccountBaseService {
    protected AccountPipelineRegistry registry;

    protected AccountContext process(AccountPipeline pipeline, AccountContext ctx) {
        AppProcessors processor = registry.getContext(pipeline);
        processor.execute(ctx);
        return ctx;
    }
}
