package it.contrader.dynsearch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import it.contrader.dynsearch.domain.Ingredient;
import it.contrader.dynsearch.domain.*; // for static metamodels
import it.contrader.dynsearch.repository.IngredientRepository;
import it.contrader.dynsearch.service.dto.IngredientCriteria;

import it.contrader.dynsearch.service.dto.IngredientDTO;
import it.contrader.dynsearch.service.mapper.IngredientMapper;

/**
 * Service for executing complex queries for Ingredient entities in the database.
 * The main input is a {@link IngredientCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link IngredientDTO} or a {@link Page} of {@link IngredientDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class IngredientQueryService extends QueryService<Ingredient> {

    private final Logger log = LoggerFactory.getLogger(IngredientQueryService.class);

    private final IngredientRepository ingredientRepository;

    private final IngredientMapper ingredientMapper;

    public IngredientQueryService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    /**
     * Return a {@link List} of {@link IngredientDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<IngredientDTO> findByCriteria(IngredientCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Ingredient> specification = createSpecification(criteria);
        return ingredientMapper.toDto(ingredientRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link IngredientDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<IngredientDTO> findByCriteria(IngredientCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Ingredient> specification = createSpecification(criteria);
        return ingredientRepository.findAll(specification, page)
            .map(ingredientMapper::toDto);
    }

    /**
     * Function to convert IngredientCriteria to a {@link Specification}
     */
    private Specification<Ingredient> createSpecification(IngredientCriteria criteria) {
        Specification<Ingredient> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Ingredient_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Ingredient_.name));
            }
            if (criteria.getUrlImg() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUrlImg(), Ingredient_.urlImg));
            }
            if (criteria.getAssoDishIngId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getAssoDishIngId(), Ingredient_.assoDishIngs, AssoDishIng_.id));
            }
            if (criteria.getAssoCocktailIngId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getAssoCocktailIngId(), Ingredient_.assoCocktailIngs, AssoCocktailIng_.id));
            }
            if (criteria.getAssoDessertIngId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getAssoDessertIngId(), Ingredient_.assoDessertIngs, AssoDessertIng_.id));
            }
        }
        return specification;
    }

}
