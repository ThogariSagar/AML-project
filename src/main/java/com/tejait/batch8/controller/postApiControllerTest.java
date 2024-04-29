package com.tejait.batch8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch8.api.PostsApi;
import com.tejait.batch8.dto.CommentsDto;
import com.tejait.batch8.dto.PostsDto;

@RestController
@RequestMapping("api")
public class postApiControllerTest {
	@Autowired
	PostsApi postsApi;
	@GetMapping("/getPosts")
	public ResponseEntity<List<PostsDto>>getAllPostsDetails(){
		List<PostsDto> list=postsApi.getAllPosts();
		return new  ResponseEntity<>(list,HttpStatus.OK);
		
	}
	@GetMapping("/getComments")
	public ResponseEntity<List<CommentsDto>>getAllCommentsDetails(){
	  List<CommentsDto>list=postsApi.getAllComments();
	return new ResponseEntity<List<CommentsDto>>(list,HttpStatus.OK);
	}

}
