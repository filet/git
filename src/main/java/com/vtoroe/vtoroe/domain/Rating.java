package com.vtoroe.vtoroe.domain;

import javax.persistence.*;

@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int rating;


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

    public Rating(int rating) {
        this.rating = rating;
    }


//    public Rating(String summary_id) {
//        this.summary_id = summary_id;
//    }
//
//    public String getSummary_id() {
//        return summary_id;
//    }
//
//    public void setSummary_id(String summary_id) {
//        this.summary_id = summary_id;
//    }
//
//    public String getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
