package os.org.hype.model.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import os.org.hype.model.enums.AccountStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountViewContext {
    private Long id;
    private String reference;
    private String rib;
    private String amount;
    private String currency;
    private boolean isBlocked = false;
    private AccountStatus accountStatus;
}
