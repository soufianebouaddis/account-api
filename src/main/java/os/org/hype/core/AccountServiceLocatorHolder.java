package os.org.hype.core;

import org.springframework.stereotype.Component;
import os.org.hype.model.enums.ServiceKeys;

@Component
public class AccountServiceLocatorHolder {

    private static AccountServiceLocator locator;

    public AccountServiceLocatorHolder(AccountServiceLocator locator) {
        AccountServiceLocatorHolder.locator = locator;
    }

    public static <T extends AccountServiceMarker> T get(ServiceKeys key, Class<T> type) {
        if (locator == null) {
            throw new IllegalStateException("ServiceLocator not initialized");
        }
        return locator.get(key.getCode(), type);
    }
}
