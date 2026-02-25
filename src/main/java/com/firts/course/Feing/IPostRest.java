package com.firts.course.Feing;

import com.firts.course.entity.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts", url = "${post.url}")
public interface IPostRest {

    @GetMapping
    List<Post> getPosts();

    @GetMapping("/{id}")
    Post getPostbyId(@PathVariable Integer id);
}