 package com.tejait.batch8.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

import com.tejait.batch8.dto.CommentsDto;
import com.tejait.batch8.dto.PostsDto;

@FeignClient(url="https://jsonplaceholder.typicode.com",
name="typicode",configuration = FeignClientConfiguration.class)
public interface PostsApi {
	@GetMapping("/posts")
	public List<PostsDto> getAllPosts();
	
	@GetMapping("/comments")
	public List<CommentsDto> getAllComments();

}
