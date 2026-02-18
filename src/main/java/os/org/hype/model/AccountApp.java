package os.org.hype.model;

import jakarta.persistence.*;
import lombok.*;
import os.org.hype.model.base.BaseEntity;
import os.org.hype.model.enums.AccountStatus;

@Entity
@Table(name = "account")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountApp extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String rib;
    private String amount;
    private String currency;
    private boolean isBlocked = false;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
