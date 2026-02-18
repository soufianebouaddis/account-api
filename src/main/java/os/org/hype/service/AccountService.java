package os.org.hype.service;

import os.org.hype.core.AccountServiceMarker;
import os.org.hype.dto.request.AccountCreateRequest;
import os.org.hype.model.context.AccountContext;
import os.org.hype.model.context.AccountPageContext;


public interface AccountService extends AccountServiceMarker {
    AccountContext save(AccountCreateRequest account);
    AccountContext update (AccountCreateRequest account, Long id );
    AccountContext findById(Long id);
    AccountPageContext findAll(int page, int size); // Account page context already has a list of accounts
    void deleteById(Long id);
}
