package org.nfactorial.newsfeed.domain.postcomment.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record WriteCommentToPostResponse(
	long id,
	String content,
	LocalDateTime createdAt) {
	public static WriteCommentToPostResponse of(WriteCommentToPostResult result) {
		return new WriteCommentToPostResponse(result.id(), result.content(), result.createdAt());
	}
}
