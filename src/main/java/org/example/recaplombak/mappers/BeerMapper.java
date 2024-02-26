package org.example.recaplombak.mappers;

import org.example.recaplombak.entities.Beer;
import org.example.recaplombak.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
