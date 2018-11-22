package com.vtoroe.vtoroe.repos;

import com.vtoroe.vtoroe.domain.Summ;
import com.vtoroe.vtoroe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SummRepo extends JpaRepository<Summ,Long> {
     List<Summ> findByTitle(String title);
}
