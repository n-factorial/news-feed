package org.nfactorial.newsfeed.domain.auth.entity;

import java.time.LocalDateTime;

public class AuthMockProfile {
	private Long id;
	private Account account;
	private String nickname;
	private String mbti;
	private String introduce;
	private int followCount;
	private LocalDateTime deletedAt;
}
