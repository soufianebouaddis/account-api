package os.org.hype.core;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import os.org.hype.model.enums.AccountPipeline;

@Component
@RequiredArgsConstructor
public class AccountPipelineRegistry {
    private final ApplicationContext context;

    public AppProcessors getContext(AccountPipeline accountPipeline) {
        return context.getBean(accountPipeline.getBeanName(), AppProcessors.class);
    }
}
