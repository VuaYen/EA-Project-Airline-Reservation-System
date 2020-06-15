package miu.edu.cs544.eaproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miu.edu.cs544.eaproject.domain.Airline;

@Repository
public interface AccountRepository<T extends Airline> extends CrudRepository<T, String> {

}

