package org.example.recaplombak.repositories;

import jakarta.validation.ConstraintViolationException;
import org.example.recaplombak.entities.Beer;
import org.example.recaplombak.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(
                Beer.builder()
                        .beerName("My Beer")
                        .beerStyle(BeerStyle.GOSE)
                        .upc("12344")
                        .price(new BigDecimal(19.99))
                        .build()
        );

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }

    @Test
    void testSaveBeerNameTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(
                    Beer.builder()
                            .beerName("My Beermmmmmmmmmmmmmmmmmmmmmmmmmmmdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
                            .beerStyle(BeerStyle.GOSE)
                            .upc("12344")
                            .price(new BigDecimal(19.99))
                            .build()
            );

            beerRepository.flush();
        });


    }
}