package com.firts.course.controller;

import com.firts.course.Feing.IPostRest;
import com.firts.course.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostsController {

    private final IPostRest  postRest;

    @GetMapping
    public List<Post> getPosts(){
        return postRest.getPosts();
    }

    @GetMapping("{id")
    public Post getPostById (@PathVariable Integer id){
        return postRest.getPostbyId(id);
    }


}