package com.tanerdiler.reactivemicroservices.repository;

import com.tanerdiler.reactivemicroservices.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<Account, String>
{
}
