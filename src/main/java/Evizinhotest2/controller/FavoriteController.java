package Evizinhotest2.controller;

import Evizinhotest2.model.Favorite;
import Evizinhotest2.model.Post;
import Evizinhotest2.service.FavoriteService;
import Evizinhotest2.service.PostService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

public class FavoriteController {
    private FavoriteService favoriteService;

    @RequestMapping(value = "/favorite", method= RequestMethod.GET)
    public String getAllPostsFavorite(Model model)
    {
        System.out.println("teste");
        List<Post> posts = favoriteService.getAll();
        model.addAttribute("favorite", posts);
        return "favorite";
    }

    @RequestMapping(value="favorite2/", method= RequestMethod.POST)
    public void addPostFavorite(Favorite favorite){
        favoriteService.addPostFavorite(favorite);
    }
}
