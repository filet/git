package com.vtoroe.vtoroe.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Summ implements Comparable<Summ>{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String descript;
    private String number;
    private String text;
    private String DateRegistr;
    private String filename;

    @ManyToMany
    @JoinTable(
            name="summary_tags",
            joinColumns = @JoinColumn(name="summary_id"),
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private List<Tags> tags;


    @ManyToOne
    @JoinColumn (name="user",referencedColumnName = "id")
    private User user;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "summ")
    private List<Comment> comment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "summ")
    private List<Rating> ratings;

    public List<Rating> getRating() {
        return ratings;
    }

    public void setRating(List<Rating> rating) {
        this.ratings = rating;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public double getRatings() {
        double rating = 0;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++){
                rating += ratings.get(i).getRating();
            }
            rating = rating/ratings.size();
        }
        return rating;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public Summ() {
    }

    public Summ(String title, String descript, String number,String text) {
        this.title = title;
        this.descript = descript;
        this.number = number;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateRegistr() {
        return DateRegistr;
    }

    public void setDateRegistr(Date dateRegistr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        this.DateRegistr=simpleDateFormat.format(dateRegistr);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void addComment(Comment comment){
        this.comment.add(comment);
    }


    @Override
    public int compareTo(Summ o) {
        Date DateRegistrat = new Date();
        Date DateRegistration=new Date();
        try {
            DateRegistrat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").parse(DateRegistr);
            DateRegistration=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").parse(o.getDateRegistr());
        }catch (Exception e){
        }
        long DateRaz=DateRegistration.getTime()-DateRegistrat.getTime();
        return (int)DateRaz;
    }
}
