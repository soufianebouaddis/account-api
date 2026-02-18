package os.org.hype.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import os.org.hype.model.base.BaseModel;
import os.org.hype.model.enums.AccountStatus;
@Getter
@Setter
public class AccountCreateRequest extends BaseModel {
    @NotNull
    private String reference;
    @NotNull
    private String rib;
    @NotNull
    private String balance;
    @NotNull
    private String currency;
    private boolean isBlocked = false;
    private AccountStatus accountStatus;
}
