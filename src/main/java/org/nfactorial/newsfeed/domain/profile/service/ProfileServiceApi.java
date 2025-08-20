package org.nfactorial.newsfeed.domain.profile.service;

import org.nfactorial.newsfeed.domain.profile.dto.request.CreateProfileCommand;
import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.nfactorial.newsfeed.domain.profile.dto.response.ProfileResponse;

public interface ProfileServiceApi {
	boolean isNicknameDuplicated(String nickname);

	long createProfile(CreateProfileCommand createProfileCommand);

	void deleteFromAccountId(long accountId);

	ProfileResponse getProfileById(long profileId);
}
