package org.nfactorial.newsfeed.domain.auth.service;

import lombok.Builder;

public interface ProfileServiceApi {
	boolean isNicknameDuplicated(String nickname);

	String createProfile(CreateProfileCommand createProfileCommand);

	@Builder
	record CreateProfileCommand(
		String nickname,
		String introduce,
		String mbti
	) {

	}
}
