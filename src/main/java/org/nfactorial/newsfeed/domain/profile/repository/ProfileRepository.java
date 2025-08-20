package org.nfactorial.newsfeed.domain.profile.repository;

import java.util.List;
import java.util.Map;

import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	boolean existsByNickname(String nickname);
	@Query("SELECT p.profile.id, COUNT(p) FROM Post p WHERE p.profile IN :profiles GROUP BY p.profile.id")
	Map<Long, Long> countPostsByProfileIn(@Param("profiles") List<Profile> profiles);
}
