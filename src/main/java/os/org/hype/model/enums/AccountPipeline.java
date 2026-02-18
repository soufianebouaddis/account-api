package os.org.hype.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountPipeline {
    ACCOUNT_CREATE("pipeline.account.create"),
    ACCOUNT_UPDATE("pipeline.account.update"),
    ACCOUNT_FIND_BY_ID("pipeline.account.findById"),
    ACCOUNT_FIND_ALL("pipeline.account.findAll"),
    ACCOUNT_DELETE("pipeline.account.delete");//delete mean block it
    private final String beanName;
}
