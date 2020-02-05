package it.contrader.dynsearch.service.mapper;

import it.contrader.dynsearch.domain.*;
import it.contrader.dynsearch.service.dto.IngredientDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Ingredient and its DTO IngredientDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IngredientMapper extends EntityMapper<IngredientDTO, Ingredient> {


    @Mapping(target = "assoDishIngs", ignore = true)
    @Mapping(target = "assoCocktailIngs", ignore = true)
    @Mapping(target = "assoDessertIngs", ignore = true)
    Ingredient toEntity(IngredientDTO ingredientDTO);

    default Ingredient fromId(Long id) {
        if (id == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        return ingredient;
    }
}
