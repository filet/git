package com.vtoroe.vtoroe.domain;

import javax.persistence.*;

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
