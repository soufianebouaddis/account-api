package os.org.hype.model.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import os.org.hype.model.enums.AccountStatus;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountContext extends AppContext{
    private Long id;
    private String reference;
    private String rib;
    private String amount;
    private String currency;
    private boolean isBlocked = false;
    private AccountStatus accountStatus;
}
