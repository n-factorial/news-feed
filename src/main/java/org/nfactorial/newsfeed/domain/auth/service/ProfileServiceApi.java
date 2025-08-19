package org.nfactorial.newsfeed.domain.auth.service;

import lombok.Builder;

public interface ProfileServiceApi {
	boolean isNicknameDuplicated(String nickname);

	String createProfile(createProfile createProfileCommand);

	@Builder
	record createProfile(
		String nickname,
		String introduce,
		String mbti
	) {

	}
}
