package os.org.hype.model.context;

import lombok.*;
import os.org.hype.model.enums.AccountStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountViewContext {
    private Long id;
    private String reference;
    private String rib;
    private String balance;
    private String currency;
    private boolean isBlocked = false;
    private AccountStatus accountStatus;
}
