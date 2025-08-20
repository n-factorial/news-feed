package org.nfactorial.newsfeed.domain.profile.dto.response;

import org.nfactorial.newsfeed.domain.profile.entity.Profile;

import lombok.Builder;

@Builder
public record ProfileResponse(
	String nickname,
	String mbti,
	String introduce,
	int followCount,
	int postCount
) {
	public static ProfileResponse of(Profile profile, int postCount) {
		return ProfileResponse.builder()
			.nickname(profile.getNickname())
			.mbti(profile.getMbti())
			.introduce(profile.getIntroduce())
			.followCount(profile.getFollowCount())
			.postCount(postCount)
			.build();
	}
}
