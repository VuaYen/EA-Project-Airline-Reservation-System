package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends CrudRepository<Agent,String> {
}
