package Evizinhotest2.service;

import Evizinhotest2.model.Favorite;
import Evizinhotest2.model.Post;
import Evizinhotest2.repository.FavoriteRepository;
import Evizinhotest2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FavoriteService {

    public FavoriteRepository favoriteRepository;
    public PostRepository postRepository;

    /*public List<Post> getByUserId(Integer userId) {
        return favoriteRepository.findPostsByUserId(userId);
    }*/

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();

        for (Favorite favorite: favoriteRepository.findAll()){
            posts.add(postRepository.findById(favorite.getPostId()).get());
        }

        return posts;
    }

    public void addPostFavorite(Favorite favorite) {
        favoriteRepository.save(favorite);
    }



}
