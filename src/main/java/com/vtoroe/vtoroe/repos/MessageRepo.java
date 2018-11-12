package com.vtoroe.vtoroe.repos;
import com.vtoroe.vtoroe.domain.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long>{

    List<Message> findByTag(String tag);
}
