package com.vtoroe.vtoroe.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="bd")
public class Summ{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String descript;
    private String number;
    private String text;

    @ManyToMany
    @JoinTable(
            name="summary_tags",
            joinColumns = @JoinColumn(name="summary_id"),
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private List<Tags> tags;

    @ManyToMany
    @JoinTable(
            name="Comment",
            joinColumns = @JoinColumn(name="summary_id"),
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    private List<User> users;

    public Summ(List<User> users) {
        this.users = users;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Summ() {
    }

    public Summ(String title, String descript, String number, String text) {
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


}
