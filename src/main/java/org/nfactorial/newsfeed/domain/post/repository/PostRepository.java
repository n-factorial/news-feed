package org.nfactorial.newsfeed.domain.post.repository;

import java.util.List;
import java.util.Map;

import org.nfactorial.newsfeed.domain.post.entity.Post;
import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

	long countByProfileId(Long profileId);

	Map<Long, Long> countPostsByProfile(List<Profile> profiles);
}
