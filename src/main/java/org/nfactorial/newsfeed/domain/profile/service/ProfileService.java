package org.nfactorial.newsfeed.domain.profile.service;

import lombok.RequiredArgsConstructor;

import org.nfactorial.newsfeed.common.code.ErrorCode;
import org.nfactorial.newsfeed.common.exception.BusinessException;
import org.nfactorial.newsfeed.domain.post.service.PostService;
import org.nfactorial.newsfeed.domain.profile.dto.request.CreateProfileCommand;
import org.nfactorial.newsfeed.domain.profile.dto.response.ProfileResponse;
import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.nfactorial.newsfeed.domain.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileService implements ProfileServiceApi {

	private final ProfileRepository profileRepository;
	private final PostService postService;

	@Override
	public boolean isNicknameDuplicated(String nickname) {
		return profileRepository.existsByNickname(nickname);
	}

	@Override
	@Transactional
	public long createProfile(CreateProfileCommand createProfileCommand) {

		Profile newProfile = new Profile(
			createProfileCommand.nickname(),
			createProfileCommand.mbti(),
			createProfileCommand.introduce()
		);

		Profile savedProfile = profileRepository.save(newProfile);
		return savedProfile.getId();
	}

	@Override
	@Transactional
	public void deleteFromAccountId(long accountId) {
		Profile profile = profileRepository.findById(accountId)
			.orElseThrow(() -> new BusinessException(ErrorCode.PROFILE_NOT_FOUND));

		profile.softDelete();
	}

	@Override
	@Transactional(readOnly = true)
	public ProfileResponse getProfileById(long profileId) {
		Profile profile = profileRepository.findById(profileId)
			.orElseThrow(() -> new BusinessException(ErrorCode.PROFILE_NOT_FOUND));

		long postCount = postService.countPostsByProfile(profile);

		return ProfileResponse.of(profile, (int) postCount);
	}
}