package os.org.hype.function;

import os.org.hype.api.AccountBuilder;
import os.org.hype.core.AccountServiceLocatorHolder;
import os.org.hype.dto.request.AccountCreateRequest;
import os.org.hype.model.context.AccountContext;
import os.org.hype.model.enums.ServiceKeys;
import os.org.hype.service.AccountService;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public interface AccountFunctions {
    static AccountContext create(AccountCreateRequest request) {
        requireNonNull(request, "request");
        AccountService service = AccountServiceLocatorHolder.get(
                ServiceKeys.ACCOUNT_SERVICE,
                AccountService.class);
        return service.save(request);
    }

    static AccountContext update(AccountCreateRequest request,Long id) {
        Objects.requireNonNull(request, "request");
        Objects.requireNonNull(id, "id");
        return AccountBuilder.update(request,id);
    }

    static AccountContext findById(Long id) {
        Objects.requireNonNull(id, "id");
        return AccountBuilder.findById(id);
    }

    static AccountContext findAll(int page, int size) {
        return AccountBuilder.findAll(page, size);
    }

    static void deleteById(Long id) {
        Objects.requireNonNull(id, "id");
        AccountBuilder.deleteById(id);

    }
}
