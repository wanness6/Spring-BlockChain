package edu.ap.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockChainEntityRepository extends CrudRepository<BlockEntity, Long> { 

}
