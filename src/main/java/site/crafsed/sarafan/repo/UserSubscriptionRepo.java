package site.crafsed.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import site.crafsed.sarafan.domain.User;
import site.crafsed.sarafan.domain.UserSubscription;
import site.crafsed.sarafan.domain.UserSubscriptionId;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);

    List<UserSubscription> findByChannel(User channel);

    UserSubscription findByChannelAndSubscriber(User channel, User subscriber);
}
