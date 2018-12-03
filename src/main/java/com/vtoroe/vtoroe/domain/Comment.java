package com.vtoroe.vtoroe.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "summ", referencedColumnName = "id")
    private Summ summ;

    public Summ getSumm() {
        return summ;
    }

    public void setSumm(Summ summ) {
        this.summ = summ;
    }

    @ManyToMany
    @JoinTable(
            name="Likes",
            joinColumns = @JoinColumn(name="comment_id"),
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    private Set<User> likes = new HashSet<>();

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
