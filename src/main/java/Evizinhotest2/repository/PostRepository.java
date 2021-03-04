package Evizinhotest2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Evizinhotest2.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	public List<Post> findByUserId(Integer userId);

}
