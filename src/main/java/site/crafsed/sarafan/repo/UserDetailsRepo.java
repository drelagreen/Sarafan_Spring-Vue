package site.crafsed.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import site.crafsed.sarafan.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}
