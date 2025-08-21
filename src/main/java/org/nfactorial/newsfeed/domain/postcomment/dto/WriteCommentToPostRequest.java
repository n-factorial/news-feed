package org.nfactorial.newsfeed.domain.postcomment.dto;

import jakarta.validation.constraints.NotBlank;

public record WriteCommentToPostRequest(
	@NotBlank
	String content) {
}
