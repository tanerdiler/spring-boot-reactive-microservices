package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>
{
}
