package Evizinhotest2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Evizinhotest2.model.Post;
import Evizinhotest2.service.PostService;

@RestController
public class PostController {
	@Autowired
	private PostService postService;

	 @RequestMapping(value = "/post")
	  public List<Post> getAllPosts() 
	  {		
		 return postService.getAllPosts();
	  }	
	 
	 
	 @RequestMapping(value = "/post/{id}")
	 public Optional<Post> getUser(@PathVariable Integer id) {
	 	return postService.getUser(id);
	 }
	 
	 
	 @RequestMapping(value = "/post", method = RequestMethod.POST)
	 public void addUser(@RequestBody Post post) {
		 postService.addPost(post);
	 }
	 
	 @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
	 public void updateUser(@RequestBody Post post,@PathVariable Integer id ) {
		 postService.updatePost(id, post);
	 }
	 
	 @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
	 public void deleteStudent(@PathVariable Integer id) {
		 postService.deletePost(id);
		 	 
	 }
}
