package org.nfactorial.newsfeed.domain.profile.controller;

import org.nfactorial.newsfeed.common.dto.GlobalApiResponse;
import org.nfactorial.newsfeed.domain.auth.entity.Account;
import org.nfactorial.newsfeed.domain.profile.dto.request.ProfileCreateRequest;
import org.nfactorial.newsfeed.domain.profile.dto.response.ProfileCreateResponse;
import org.nfactorial.newsfeed.domain.profile.service.ProfileServiceApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfileController {

	private final ProfileServiceApi profileServiceApi;

	@PostMapping("/api/v1/profile")
	public ResponseEntity<GlobalApiResponse<ProfileCreateResponse>> createProfile(
		Account account,
		@Valid @RequestBody ProfileCreateRequest request
	) {
		ProfileCreateResponse response = profileServiceApi.createProfile(account, request);
		return ResponseEntity.ok(
			GlobalApiResponse.<ProfileCreateResponse>builder()
				.code(response.getCode())
				.message(response.getMessage())
				.data(response)
				.build()
		);
	}
}
