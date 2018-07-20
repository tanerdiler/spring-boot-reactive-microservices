package com.tanerdiler.reactivemicroservices.repository;

import com.tanerdiler.reactivemicroservices.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>
{
}
