package com.castilho.workshopmongo.repository;

import com.castilho.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") //"?'x'" -> pega o parâmetro da posição x
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query( "{ $and: [ {date: {$gte: ?1} }, {date: {$lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text':  { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);


}
