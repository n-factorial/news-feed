package org.nfactorial.newsfeed.common.dto;

import lombok.Builder;

@Builder
public record GlobalApiResponse<T>(
	// TODO: ErrorCode와 SuccessCode를 GlobalResponseCode로 새롭게 만들어야함
	String message,
	T data
) {
}
