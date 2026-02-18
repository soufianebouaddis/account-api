package os.org.hype.api;

import org.springframework.stereotype.Component;
import os.org.hype.core.AccountServiceLocator;
import os.org.hype.dto.request.AccountCreateRequest;
import os.org.hype.model.context.AccountContext;
import os.org.hype.model.context.AccountPageContext;
import os.org.hype.model.enums.ServiceKeys;
import os.org.hype.service.AccountService;

import java.util.Objects;

@Component
public class AccountBuilder {
    private static AccountServiceLocator locator;

    public AccountBuilder(AccountServiceLocator locator) {
        AccountBuilder.locator = locator;
    }

    public static AccountContext save(AccountCreateRequest request) {
        AccountService service = locator.get(
                ServiceKeys.ACCOUNT_SERVICE.getCode(),
                AccountService.class
        );
        return service.save(request);
    }

    public static AccountContext update(AccountCreateRequest request,Long id) {
        Objects.requireNonNull(request, "request");
        Objects.requireNonNull(id, "id");

        AccountService service = locator.get(
                ServiceKeys.ACCOUNT_SERVICE.getCode(),
                AccountService.class
        );
        return service.update(request,id);
    }

    public static AccountContext findById(Long id) {
        Objects.requireNonNull(id, "id");
        AccountService service = locator.get(
                ServiceKeys.ACCOUNT_SERVICE.getCode(),
                AccountService.class
        );
        return service.findById(id);
    }

    public static AccountPageContext findAll(int page, int size) {
        AccountService service = locator.get(
                ServiceKeys.ACCOUNT_SERVICE.getCode(),
                AccountService.class
        );
        return service.findAll(page, size);
    }


    public static void deleteById(Long id) {
        Objects.requireNonNull(id, "id");
        AccountService service = locator.get(
                ServiceKeys.ACCOUNT_SERVICE.getCode(),
                AccountService.class
        );
        service.deleteById(id);
    }
}
