package Evizinhotest2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evizinhotest2.model.Post;
import Evizinhotest2.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	public PostRepository postRepository;
		
	public List<Post> getAllPosts() {
		
	    List<Post> posts = new ArrayList<>();
		
	    postRepository.findAll()
	    .forEach(posts::add);
		
	    return posts;		
	}
	
	public void addPost(Post post) {
	     postRepository.save(post);
	}
	
	public Optional<Post> getUser(Integer id) {
	     return postRepository.findById(id);
	}
	
	public void updatePost(Integer id, Post post) {
	     postRepository.save(post);
	}
	
	public void deletePost(Integer id) {
	     postRepository.deleteById(id);
	}
	
	public List<Post> getPostsByUser(String id) {
		List<Post> posts = new ArrayList<>();
		   
		postRepository.findByUserId(id)
		.forEach(posts::add);
		   
		return posts;	 
		}

}
