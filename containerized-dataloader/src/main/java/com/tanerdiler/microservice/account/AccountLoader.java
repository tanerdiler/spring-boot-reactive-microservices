package com.tanerdiler.microservice.account;

import com.tanerdiler.microservice.account.model.Account;
import com.tanerdiler.microservice.account.model.Order;
import com.tanerdiler.microservice.account.model.Product;
import com.tanerdiler.microservice.account.repository.AccountRepository;
import com.tanerdiler.microservice.account.repository.OrderRepository;
import com.tanerdiler.microservice.account.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class AccountLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(AccountLoader.class, args);
    }

    public AccountLoader(AccountRepository accountRepository,
                         ProductRepository productRepository,
                         OrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        accountRepository.deleteAll();
        productRepository.deleteAll();
        orderRepository.deleteAll();

        RestTemplate uinamesService = new RestTemplate();

        ResponseEntity<Account[]> responseEntity
                = uinamesService.getForEntity("https://uinames.com/api/?ext&amount=100", Account[].class);

        Arrays.stream(responseEntity.getBody()).forEach(a -> accountRepository.save(a));
        Random random = new Random();
        IntStream.range(0,10).forEach(i->
        {
            productRepository.save(new Product("PRODUCT-"+i, random.nextInt(500)*1d));
        });

        accountRepository.findAll().stream().forEach(a->{
            productRepository.findAll().stream().forEach(p->{
                IntStream.range(0,10).forEach(i-> {
                     orderRepository.save(new Order(p.getId(),a.getId(), random.nextInt(10),p.getPrice(), p.getPrice()*0.1d));
                });
            });
        });
    }
}
