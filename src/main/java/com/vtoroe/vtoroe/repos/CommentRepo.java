package com.vtoroe.vtoroe.repos;

import com.vtoroe.vtoroe.domain.Comment;
import com.vtoroe.vtoroe.domain.Rating;
import com.vtoroe.vtoroe.domain.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findByText(String text);
}
