package org.nfactorial.newsfeed.domain.profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProfileCreateRequest {

	@NotBlank(message = "닉네임은 필수입니다.")
	@Size(max = 20, message = "닉네임은 20자 이내로 입력해주세요.")
	private String nickname;

	private String mbti;
	private String introduce;
}
