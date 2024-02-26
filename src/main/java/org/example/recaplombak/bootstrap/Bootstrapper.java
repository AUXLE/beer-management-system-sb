package org.example.recaplombak.bootstrap;

import org.example.recaplombak.entities.Beer;
import org.example.recaplombak.entities.Customer;
import org.example.recaplombak.model.BeerStyle;
import org.example.recaplombak.repositories.BeerRepository;
import org.example.recaplombak.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class Bootstrapper implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;
    Bootstrapper(CustomerRepository customerRepository, BeerRepository beerRepository)
    {
        this.beerRepository = beerRepository;
        this.customerRepository = customerRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Customer tony = Customer.builder()
                .customerName("Tony Stark")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer bruce = Customer.builder()
                .customerName("Bruce Wayne")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer das = Customer.builder()
                .customerName("Lord Labaku Das")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Beer beer1 = Beer.builder()
                .beerName("Adnan")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("hello")
                .price(BigDecimal.valueOf(10))
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .quantityOnHand(122)
                .version(1).build();

        Beer beer2 = Beer.builder()
                .beerName("Mohammed")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("hi")
                .price(BigDecimal.valueOf(50))
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .quantityOnHand(100)
                .version(1).build();

        Beer beer3 = Beer.builder()
                .beerName("Pulla")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("bye")
                .price(BigDecimal.valueOf(100))
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .quantityOnHand(90)
                .version(1).build();

        customerRepository.saveAll(List.of(tony, bruce, das));
        beerRepository.saveAll(List.of(beer1, beer2, beer3));

    }
}
