package org.nfactorial.newsfeed.domain.profile.service;

import org.nfactorial.newsfeed.domain.auth.entity.Account;
import org.nfactorial.newsfeed.domain.profile.dto.request.ProfileCreateRequest;
import org.nfactorial.newsfeed.domain.profile.dto.response.ProfileCreateResponse;

public interface ProfileServiceApi {
	ProfileCreateResponse createProfile(Account account, ProfileCreateRequest request);
}
