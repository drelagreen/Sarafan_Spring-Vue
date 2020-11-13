package site.crafsed.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import site.crafsed.sarafan.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
