package org.nfactorial.newsfeed.domain.profile.service;

import org.nfactorial.newsfeed.common.code.SuccessCode;
import org.nfactorial.newsfeed.domain.auth.entity.Account;
import org.nfactorial.newsfeed.domain.profile.dto.request.ProfileCreateRequest;
import org.nfactorial.newsfeed.domain.profile.dto.response.ProfileCreateResponse;
import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.nfactorial.newsfeed.domain.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService implements ProfileServiceApi{

	private final ProfileRepository profileRepository;

	@Override
	@Transactional
	public ProfileCreateResponse createProfile(Account account, ProfileCreateRequest request) {
		Profile profile = new Profile(account, request.getNickname(), request.getMbti(), request.getIntroduce());
		profileRepository.save(profile);

		return new ProfileCreateResponse(
			SuccessCode.PROFILE_CREATED.getCode(),
			SuccessCode.PROFILE_CREATED.getMessage()
		);
	}

}
