package os.org.hype.core;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountServiceLocator {
    private final AccountServiceRouter accountServiceRouter;

    public <T extends AccountServiceMarker> T get(@NotNull String key, Class<T> type) {
        return accountServiceRouter.get(key, type);
    }
}
