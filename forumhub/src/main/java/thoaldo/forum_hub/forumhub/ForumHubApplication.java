package thoaldo.forum_hub.forumhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "thoaldo.forum_hub")
@EnableJpaRepositories(basePackages = "thoaldo.forum_hub.repository")
public class ForumHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumHubApplication.class, args);
	}
}
