package org.nfactorial.newsfeed.domain.post.repository;

import java.util.List;
import java.util.Map;

import org.nfactorial.newsfeed.domain.post.entity.Post;
import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

	long countByProfileId(Long profileId);

	@Query("SELECT p.profile.id, COUNT(p) FROM Post p WHERE p.profile IN :profiles GROUP BY p.profile.id")
	Map<Long, Long> countPostsByProfile(List<Profile> profiles);
}
