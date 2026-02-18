package os.org.hype.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import os.org.hype.model.base.BaseModel;
import os.org.hype.model.enums.AccountStatus;
@Getter
@Setter
@Builder
public class AccountCreateResponse extends BaseModel {
    private Long id;
    private String reference;
    private String rib;
    private String balance;
    private String currency;
    private boolean isBlocked = false;
    private AccountStatus accountStatus;
}
