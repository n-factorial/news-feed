package org.nfactorial.newsfeed.domain.profile.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileCreateResponse {

	private String code;
	private String message;

	public ProfileCreateResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
