package Evizinhotest2.controller;

import java.util.List;
import java.util.Optional;

import Evizinhotest2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Evizinhotest2.model.Post;
import Evizinhotest2.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	 @RequestMapping(value = "/posts")
	  public List<Post> getAllPosts(Model model) 
	  {		
		 List<Post> posts = postService.getAllPosts();
		 model.addAttribute("posts", posts);
		 return posts;
	  }	
	 
	 
	 @RequestMapping(value = "/posts/{id}")
	 public Optional<Post> getPost(@PathVariable Integer id) {
	 	return postService.getPost(id);
	 }
	 
	 
	 @RequestMapping(value = "/posts", method = RequestMethod.POST)
	 public void addPost(@RequestBody Post post) {
		 postService.addPost(post);
	 }
	 
	 @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	 public void updatePost(@RequestBody Post post,@PathVariable Integer id ) {
		 postService.updatePost(id, post);
	 }
	 
	 @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	 public void deletePost(@PathVariable Integer id) {
		 postService.deletePost(id);
		 	 
	 }

	@GetMapping("/posts/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Post post = postService.getPost(id).get();
			model.addAttribute("post", post);
		}
		return "showPost";
	}
}
