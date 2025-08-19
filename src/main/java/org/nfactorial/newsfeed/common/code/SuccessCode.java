package org.nfactorial.newsfeed.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SuccessCode implements GlobalResponseCode {
	ACCOUNT_CREATED("AUTH-201", "회원가입 성공"),
	PROFILE_CREATED("PROFILE-201", "프로필이 생성 성공");

	private final String code;
	private final String message;
}
