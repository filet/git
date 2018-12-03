package com.vtoroe.vtoroe.repos;

import com.vtoroe.vtoroe.domain.Summ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummRepo extends JpaRepository<Summ,Long> {
     List<Summ> findByTitle(String title);
}
