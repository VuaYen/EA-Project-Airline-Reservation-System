package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository<T extends Account> extends CrudRepository<T, String> {

}

