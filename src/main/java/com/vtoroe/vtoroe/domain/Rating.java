package com.vtoroe.vtoroe.domain;

import javax.persistence.*;

@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double rating;


    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "summ", referencedColumnName = "id")
    private Summ summ;

    public Summ getSumm() {
        return summ;
    }

    public void setSumm(Summ summ) {
        this.summ = summ;
    }

    public Rating() {
    }

    public Rating(double rating, User user, Summ summ) {
        this.rating = rating;
        this.user = user;
        this.summ = summ;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
