package org.nfactorial.newsfeed.domain.post.service;

import org.nfactorial.newsfeed.common.code.ErrorCode;
import org.nfactorial.newsfeed.common.exception.BusinessException;
import org.nfactorial.newsfeed.domain.post.dto.request.PostCreateRequest;
import org.nfactorial.newsfeed.domain.post.dto.request.PostUpdateRequest;
import org.nfactorial.newsfeed.domain.post.dto.response.PostCreateResponse;
import org.nfactorial.newsfeed.domain.post.dto.response.PostGetOneResponse;
import org.nfactorial.newsfeed.domain.post.dto.response.PostUpdateResponse;
import org.nfactorial.newsfeed.domain.post.entity.Post;
import org.nfactorial.newsfeed.domain.post.mock.MockAuthProfileDto;
import org.nfactorial.newsfeed.domain.post.repository.PostRepository;
import org.nfactorial.newsfeed.domain.profile.entity.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	//TODO 프로필 받고 변경
	@Transactional
	public PostCreateResponse save(PostCreateRequest request, MockAuthProfileDto currentUserProfile) {

		Post savedPost = postRepository.save(Post.of(request, currentUserProfile));
		return PostCreateResponse.of(savedPost);
	}

	//TODO 프로필 받고 변경
	@Transactional
	public PostUpdateResponse update(Long postId, PostUpdateRequest request,
		MockAuthProfileDto currentUserProfile) {

		Post foundPost = postRepository.findById(postId)
			.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));

		// if (!ObjectUtils.nullSafeEquals(foundPost.getProfile().getId(), currentUserProfile.getId())) {
		// 	throw new BusinessException(ErrorCode.POST_ACCESS_DENIED);
		// }

		foundPost.updateContent(request);

		return PostUpdateResponse.of(foundPost);
	}

	@Transactional(readOnly = true)
	public PostGetOneResponse findById(Long postId) {

		Post foundPost = postRepository.findById(postId)
			.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));

		//TODO comment 받고 변경
		int commentCount = 0;

		return PostGetOneResponse.of(foundPost, commentCount);
	}

	//TODO 프로필의 게시물 수 계산을 구현해주세요!
	public long countPostsByProfile(Profile profile) {
		return 0;
	}
}
