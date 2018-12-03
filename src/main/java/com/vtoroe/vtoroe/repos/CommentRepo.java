package com.vtoroe.vtoroe.repos;
import com.vtoroe.vtoroe.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findByText(String text);
}
