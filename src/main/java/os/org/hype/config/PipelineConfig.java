package os.org.hype.config;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import os.org.hype.model.context.AccountContext;
import os.org.hype.processor.AppProcessors;
import os.org.hype.processor.ProcessorStep;

import java.util.List;

@Configuration
public class PipelineConfig {

    @Bean("pipeline.account.create")
    public AppProcessors createPipeline(
            @Qualifier("step.account.validate") ProcessorStep<AccountContext> validate,
            @Qualifier("step.account.save") ProcessorStep<AccountContext> save,
            @Qualifier("step.account.errorLogger") ProcessorStep<AccountContext> error) {
        return new AppProcessors(List.of(
                validate,
                save,
                error
        ));
    }

    @Bean("pipeline.account.update")
    public AppProcessors updatePipeline(
            @Qualifier("step.account.exist") ProcessorStep<AccountContext> exists,
            @Qualifier("step.account.validate") ProcessorStep<AccountContext> validate,
            @Qualifier("step.account.update") ProcessorStep<AccountContext> save,
            @Qualifier("step.account.errorLogger") ProcessorStep<AccountContext> error) {
        return new AppProcessors(List.of(
                exists,
                validate,
                save,
                error
        ));
    }

    @Bean("pipeline.account.findById")
    public AppProcessors findByIdPipeline(
            @Qualifier("step.account.findById") ProcessorStep<AccountContext> find,
            @Qualifier("step.account.errorLogger") ProcessorStep<AccountContext> error) {
        return new AppProcessors(List.of(
                find,
                error
        ));
    }

    @Bean("pipeline.account.findAll")
    public AppProcessors findAllPipeline(
            @Qualifier("step.account.findAll") ProcessorStep<AccountContext> find,
            @Qualifier("step.account.errorLogger") ProcessorStep<AccountContext> error) {
        return new AppProcessors(List.of(
                find,
                error
        ));
    }

     @Bean
    public AppProcessors deletePipeline(
            @Qualifier("step.account.exist") ProcessorStep<AccountContext> exists,
            @Qualifier("step.account.deleteById") ProcessorStep<AccountContext> delete,
            @Qualifier("step.account.errorLogger") ProcessorStep<AccountContext> error) {
        return new AppProcessors(List.of(
                exists,
                delete,
                error
        ));
     }
}

