package org.nfactorial.newsfeed.domain.postcomment.controller;

import org.nfactorial.newsfeed.common.code.SuccessCode;
import org.nfactorial.newsfeed.common.dto.GlobalApiResponse;
import org.nfactorial.newsfeed.common.security.AuthProfile;
import org.nfactorial.newsfeed.common.security.AuthProfileDto;
import org.nfactorial.newsfeed.domain.postcomment.dto.CommentListByPostResult;
import org.nfactorial.newsfeed.domain.postcomment.dto.GetCommentsFromPostResponse;
import org.nfactorial.newsfeed.domain.postcomment.dto.WriteCommentToPostCommand;
import org.nfactorial.newsfeed.domain.postcomment.dto.WriteCommentToPostRequest;
import org.nfactorial.newsfeed.domain.postcomment.dto.WriteCommentToPostResponse;
import org.nfactorial.newsfeed.domain.postcomment.dto.WriteCommentToPostResult;
import org.nfactorial.newsfeed.domain.postcomment.service.PostCommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostCommentController {
    private final PostCommentService postCommentService;

    @GetMapping("/posts/{postId}/comments")
    public GlobalApiResponse<?> getCommentsFromPost(@PathVariable("postId")
    long postId) {
        CommentListByPostResult result = postCommentService.commentListByPost(postId);
        return GlobalApiResponse.of(SuccessCode.OK, GetCommentsFromPostResponse.of(result));
    }

    @PostMapping("/posts/{postId}/comments")
    public GlobalApiResponse<?> writeComment(@PathVariable("postId")
    long postId,
        @AuthProfile
        AuthProfileDto authProfile,
        @Valid @RequestBody
        WriteCommentToPostRequest request) {
        WriteCommentToPostCommand command = WriteCommentToPostCommand.of(postId, authProfile.profileId(),
            request.content());
        WriteCommentToPostResult result = postCommentService.writeCommentToPost(command);
        WriteCommentToPostResponse response = WriteCommentToPostResponse.of(result);
        return GlobalApiResponse.of(SuccessCode.OK, response);
    }
}
