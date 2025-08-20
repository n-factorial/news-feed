package org.nfactorial.newsfeed.domain.profile.controller;

import org.nfactorial.newsfeed.common.code.SuccessCode;
import org.nfactorial.newsfeed.common.dto.GlobalApiResponse;
import org.nfactorial.newsfeed.domain.profile.dto.response.ProfileResponse;
import org.nfactorial.newsfeed.domain.profile.service.ProfileServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfileController {

	private final ProfileServiceApi profileServiceApi;

	@GetMapping("/api/v1/profiles/{id}")
	public GlobalApiResponse<ProfileResponse> getProfile(@PathVariable long id) {
		ProfileResponse profile = profileServiceApi.getProfileById(id);

		return GlobalApiResponse.of(SuccessCode.OK, profile);
	}
}
