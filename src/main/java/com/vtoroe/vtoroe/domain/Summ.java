package com.vtoroe.vtoroe.domain;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="bd")
public class Summ{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String descript;
    private String number;
    private String tags;
    private String text;

    public Summ() {
    }

    public Summ(String title, String descript, String number, String tags, String text) {
        this.title = title;
        this.descript = descript;
        this.number = number;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
