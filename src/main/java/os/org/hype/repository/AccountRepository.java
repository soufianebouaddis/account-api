package os.org.hype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import os.org.hype.model.AccountApp;

@Repository
public interface AccountRepository extends JpaRepository<AccountApp, Long> {
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AccountApp a WHERE a.rib = :rib")
    boolean existsByRib(@Param("rib") String rib);
}
