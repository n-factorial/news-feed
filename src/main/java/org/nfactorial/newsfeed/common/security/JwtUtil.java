package org.nfactorial.newsfeed.common.security;

import java.time.Instant;

import org.nfactorial.newsfeed.common.code.ErrorCode;
import org.nfactorial.newsfeed.common.exception.BusinessException;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {
	private static final String SECRET_KEY = "비밀키이다이것은비밀키이다이것은비밀키이다이것은비밀키이다이것은비밀키이다이것은"; // 비밀키
	private static final long EXPIRATION_SECONDS = 3600;

	private Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

	public String createToken(final long accountId) {
		final var issuedAt = Instant.now();
		return JWT.create()
			.withIssuedAt(issuedAt)
			.withSubject(String.valueOf(accountId))
			.withExpiresAt(issuedAt.plusSeconds(EXPIRATION_SECONDS))
			.sign(algorithm);
	}

	public Long getAccountId(final String token) {
		try {
			String subject = JWT.require(algorithm).build().verify(token).getSubject();
			return Long.parseLong(subject);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.INVALID_TOKEN);
		}
	}
}