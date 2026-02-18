package os.org.hype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.org.hype.model.AccountApp;

@Repository
public interface AccountRespository extends JpaRepository<AccountApp, Long> {
}
