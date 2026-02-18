package os.org.hype.core;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import os.org.hype.dto.response.AccountCreateReponse;
import os.org.hype.model.context.AccountContext;
import os.org.hype.model.context.AccountPageContext;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class AccountResponseFactory {
    public static ResponseEntity<AccountCreateReponse> from(AccountContext ctx) {
        if (!ctx.isSuccess()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(
                AccountCreateReponse.builder()
                        .id(ctx.getId())
                        .reference(ctx.getReference())
                        .rib(ctx.getRib())
                        .balance(ctx.getBalance())
                        .currency(ctx.getCurrency())
                        .isBlocked(ctx.isBlocked())
                        .accountStatus(ctx.getAccountStatus())
                        .build()
        );
    }

    public static ResponseEntity<Map<String, Object>> from(AccountPageContext ctx) {
        if (!ctx.isSuccess()) {
            return ResponseEntity.badRequest().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("page", ctx.getPage());
        response.put("size", ctx.getSize());
        response.put("totalElements", ctx.getTotalElements());
        response.put("data", ctx.getAccounts());
        return ResponseEntity.ok(response);
    }
}
