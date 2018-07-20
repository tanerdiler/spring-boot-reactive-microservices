package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{
}
