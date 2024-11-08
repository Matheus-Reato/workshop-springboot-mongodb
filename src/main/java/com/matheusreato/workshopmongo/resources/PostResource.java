package com.matheusreato.workshopmongo.resources;

import com.matheusreato.workshopmongo.domain.Post;
import com.matheusreato.workshopmongo.domain.User;
import com.matheusreato.workshopmongo.dto.UserDTO;
import com.matheusreato.workshopmongo.resources.util.URL;
import com.matheusreato.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }
}
