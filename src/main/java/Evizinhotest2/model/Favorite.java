package Evizinhotest2.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Favorite {

    @Id
    @Column
    private Integer postId;

    public Integer getPostId() {
        return postId;
    }

    public Favorite() {}
}
