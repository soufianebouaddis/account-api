package os.org.hype.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountStatus {
    ACTIVE("ACTIVE", "Account Status: ACTIVE"),
    INACTIVE("INACTIVE", "Account Status: INACTIVE");
    private final String code;
    private final String description;
}

