package org.nfactorial.newsfeed.domain.post.dto;

public record PostCountDto(
	Long profileId,
	Long postCount
) {
	// 생성자를 통한 타입 안전성 보장
	public PostCountDto {
		if (profileId == null) {
			throw new IllegalArgumentException("Profile ID cannot be null");
		}
		if (postCount == null) {
			postCount = 0L;
		}
	}
}