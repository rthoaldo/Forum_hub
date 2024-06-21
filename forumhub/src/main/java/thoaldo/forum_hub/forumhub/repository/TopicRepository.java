package thoaldo.forum_hub.forumhub.repository;

import thoaldo.forum_hub.forumhub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
