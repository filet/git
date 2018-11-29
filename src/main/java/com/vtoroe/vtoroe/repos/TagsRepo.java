package com.vtoroe.vtoroe.repos;

import com.vtoroe.vtoroe.domain.Tags;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo extends JpaRepository<Tags,Long> {

    Tags findByTags(String tag);

}
