package com.matheusreato.workshopmongo.repositories;

import com.matheusreato.workshopmongo.domain.Post;
import com.matheusreato.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
