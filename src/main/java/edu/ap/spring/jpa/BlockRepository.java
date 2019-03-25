package edu.ap.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ap.spring.service.Block;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> { 

}
