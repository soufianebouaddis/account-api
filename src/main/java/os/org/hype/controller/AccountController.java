package os.org.hype.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.org.hype.core.AccountResponseFactory;
import os.org.hype.dto.request.AccountCreateRequest;
import os.org.hype.dto.response.AccountCreateResponse;
import os.org.hype.function.AccountFunctions;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts/")
@Tag(name = "Accounts", description = "Account management APIs")
public class AccountController {
    @PostMapping("create-account")
    @Operation(summary = "create account")
    public ResponseEntity<AccountCreateResponse> create(@RequestBody AccountCreateRequest request) {
        return AccountResponseFactory.from(
                AccountFunctions.create(request)
        );
    }

    @PutMapping("update-account/{id}")
    @Operation(summary = "update account")
    public ResponseEntity<AccountCreateResponse> update(@PathVariable Long id,
                                                        @RequestBody AccountCreateRequest request) {
        return AccountResponseFactory.from(
                AccountFunctions.update(request, id)
        );
    }

    @GetMapping("get-account/{id}")
    @Operation(summary = "get account by id")
    public ResponseEntity<AccountCreateResponse> findById(@PathVariable Long id) {
        return AccountResponseFactory.from(
                AccountFunctions.findById(id)
        );
    }

    @GetMapping("get-all-accounts")
    @Operation(summary = "get all accounts")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        return AccountResponseFactory.from(
                AccountFunctions.findAll(page, size)
        );
    }

    @DeleteMapping("delete-account/{id}")
    @Operation(summary = "delete account by id")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        AccountFunctions.deleteById(id);
        return ResponseEntity.ok().body("Account deleted successfully");
    }
}
