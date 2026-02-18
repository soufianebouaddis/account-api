package os.org.hype.model.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPageContext extends AccountContext{
    private int page;
    private int size;
    private long totalElements;
    private List<AccountViewContext> accounts;
}
