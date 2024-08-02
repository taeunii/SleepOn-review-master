package bitc.fullstack.sleepon.repository;

import bitc.fullstack.sleepon.model.SleepOnUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepOnUserRepository extends JpaRepository<SleepOnUser, String> {
}
