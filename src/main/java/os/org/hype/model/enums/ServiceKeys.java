package os.org.hype.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceKeys {
    ACCOUNT_SERVICE("ACCOUNT_SERVICE", "Service Keys: ServiceKeys");
    public final String code;
    public final String description;
}
