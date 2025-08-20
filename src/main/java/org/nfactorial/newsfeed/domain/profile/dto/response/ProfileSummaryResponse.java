package org.nfactorial.newsfeed.domain.profile.dto.response;

import org.nfactorial.newsfeed.domain.profile.entity.Profile;

import lombok.Builder;

@Builder
public record ProfileSummaryResponse(
	long id,
	String nickname,
	String introduce,
	String mbti,
	int followCount,
	long postCount
) {
	public static ProfileSummaryResponse of(Profile profile, long postCount) {
		return ProfileSummaryResponse.builder()
			.id(profile.getId())
			.nickname(profile.getNickname())
			.introduce(profile.getIntroduce())
			.mbti(profile.getMbti())
			.followCount(profile.getFollowCount())
			.postCount(postCount)
			.build();
	}
}

