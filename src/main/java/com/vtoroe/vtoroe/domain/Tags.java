package com.vtoroe.vtoroe.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tags;

    @ManyToMany
    @JoinTable(
            name="summary_tags",
            joinColumns = @JoinColumn(name="tag_id"),
            inverseJoinColumns = {@JoinColumn(name="summary_id")}
    )
    private List<Summ> summs;

    public Tags() {
    }

    public Tags(String tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}