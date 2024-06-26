package com.sparta.fifteen.repository;

import com.sparta.fifteen.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByNewsfeedId(long newsfeedId);
    @Transactional
    void deleteAllByNewsfeedId(long newsfeedId);
}
