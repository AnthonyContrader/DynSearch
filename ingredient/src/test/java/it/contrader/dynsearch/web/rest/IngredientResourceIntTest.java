package it.contrader.dynsearch.web.rest;

import it.contrader.dynsearch.IngredientApp;

import it.contrader.dynsearch.domain.Ingredient;
import it.contrader.dynsearch.domain.AssoDishIng;
import it.contrader.dynsearch.domain.AssoCocktailIng;
import it.contrader.dynsearch.domain.AssoDessertIng;
import it.contrader.dynsearch.repository.IngredientRepository;
import it.contrader.dynsearch.service.IngredientService;
import it.contrader.dynsearch.service.dto.IngredientDTO;
import it.contrader.dynsearch.service.mapper.IngredientMapper;
import it.contrader.dynsearch.web.rest.errors.ExceptionTranslator;
import it.contrader.dynsearch.service.dto.IngredientCriteria;
import it.contrader.dynsearch.service.IngredientQueryService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.dynsearch.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the IngredientResource REST controller.
 *
 * @see IngredientResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IngredientApp.class)
public class IngredientResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_URL_IMG = "AAAAAAAAAA";
    private static final String UPDATED_URL_IMG = "BBBBBBBBBB";

    @Autowired
    private IngredientRepository ingredientRepository;


    @Autowired
    private IngredientMapper ingredientMapper;
    

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientQueryService ingredientQueryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restIngredientMockMvc;

    private Ingredient ingredient;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final IngredientResource ingredientResource = new IngredientResource(ingredientService, ingredientQueryService);
        this.restIngredientMockMvc = MockMvcBuilders.standaloneSetup(ingredientResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ingredient createEntity(EntityManager em) {
        Ingredient ingredient = new Ingredient()
            .name(DEFAULT_NAME)
            .urlImg(DEFAULT_URL_IMG);
        return ingredient;
    }

    @Before
    public void initTest() {
        ingredient = createEntity(em);
    }

    @Test
    @Transactional
    public void createIngredient() throws Exception {
        int databaseSizeBeforeCreate = ingredientRepository.findAll().size();

        // Create the Ingredient
        IngredientDTO ingredientDTO = ingredientMapper.toDto(ingredient);
        restIngredientMockMvc.perform(post("/api/ingredients")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ingredientDTO)))
            .andExpect(status().isCreated());

        // Validate the Ingredient in the database
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeCreate + 1);
        Ingredient testIngredient = ingredientList.get(ingredientList.size() - 1);
        assertThat(testIngredient.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testIngredient.getUrlImg()).isEqualTo(DEFAULT_URL_IMG);
    }

    @Test
    @Transactional
    public void createIngredientWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ingredientRepository.findAll().size();

        // Create the Ingredient with an existing ID
        ingredient.setId(1L);
        IngredientDTO ingredientDTO = ingredientMapper.toDto(ingredient);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIngredientMockMvc.perform(post("/api/ingredients")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ingredientDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Ingredient in the database
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = ingredientRepository.findAll().size();
        // set the field null
        ingredient.setName(null);

        // Create the Ingredient, which fails.
        IngredientDTO ingredientDTO = ingredientMapper.toDto(ingredient);

        restIngredientMockMvc.perform(post("/api/ingredients")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ingredientDTO)))
            .andExpect(status().isBadRequest());

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUrlImgIsRequired() throws Exception {
        int databaseSizeBeforeTest = ingredientRepository.findAll().size();
        // set the field null
        ingredient.setUrlImg(null);

        // Create the Ingredient, which fails.
        IngredientDTO ingredientDTO = ingredientMapper.toDto(ingredient);

        restIngredientMockMvc.perform(post("/api/ingredients")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ingredientDTO)))
            .andExpect(status().isBadRequest());

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllIngredients() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList
        restIngredientMockMvc.perform(get("/api/ingredients?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ingredient.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].urlImg").value(hasItem(DEFAULT_URL_IMG.toString())));
    }
    

    @Test
    @Transactional
    public void getIngredient() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get the ingredient
        restIngredientMockMvc.perform(get("/api/ingredients/{id}", ingredient.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(ingredient.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.urlImg").value(DEFAULT_URL_IMG.toString()));
    }

    @Test
    @Transactional
    public void getAllIngredientsByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList where name equals to DEFAULT_NAME
        defaultIngredientShouldBeFound("name.equals=" + DEFAULT_NAME);

        // Get all the ingredientList where name equals to UPDATED_NAME
        defaultIngredientShouldNotBeFound("name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllIngredientsByNameIsInShouldWork() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList where name in DEFAULT_NAME or UPDATED_NAME
        defaultIngredientShouldBeFound("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME);

        // Get all the ingredientList where name equals to UPDATED_NAME
        defaultIngredientShouldNotBeFound("name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllIngredientsByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList where name is not null
        defaultIngredientShouldBeFound("name.specified=true");

        // Get all the ingredientList where name is null
        defaultIngredientShouldNotBeFound("name.specified=false");
    }

    @Test
    @Transactional
    public void getAllIngredientsByUrlImgIsEqualToSomething() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList where urlImg equals to DEFAULT_URL_IMG
        defaultIngredientShouldBeFound("urlImg.equals=" + DEFAULT_URL_IMG);

        // Get all the ingredientList where urlImg equals to UPDATED_URL_IMG
        defaultIngredientShouldNotBeFound("urlImg.equals=" + UPDATED_URL_IMG);
    }

    @Test
    @Transactional
    public void getAllIngredientsByUrlImgIsInShouldWork() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList where urlImg in DEFAULT_URL_IMG or UPDATED_URL_IMG
        defaultIngredientShouldBeFound("urlImg.in=" + DEFAULT_URL_IMG + "," + UPDATED_URL_IMG);

        // Get all the ingredientList where urlImg equals to UPDATED_URL_IMG
        defaultIngredientShouldNotBeFound("urlImg.in=" + UPDATED_URL_IMG);
    }

    @Test
    @Transactional
    public void getAllIngredientsByUrlImgIsNullOrNotNull() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        // Get all the ingredientList where urlImg is not null
        defaultIngredientShouldBeFound("urlImg.specified=true");

        // Get all the ingredientList where urlImg is null
        defaultIngredientShouldNotBeFound("urlImg.specified=false");
    }

    @Test
    @Transactional
    public void getAllIngredientsByAssoDishIngIsEqualToSomething() throws Exception {
        // Initialize the database
        AssoDishIng assoDishIng = AssoDishIngResourceIntTest.createEntity(em);
        em.persist(assoDishIng);
        em.flush();
        ingredient.addAssoDishIng(assoDishIng);
        ingredientRepository.saveAndFlush(ingredient);
        Long assoDishIngId = assoDishIng.getId();

        // Get all the ingredientList where assoDishIng equals to assoDishIngId
        defaultIngredientShouldBeFound("assoDishIngId.equals=" + assoDishIngId);

        // Get all the ingredientList where assoDishIng equals to assoDishIngId + 1
        defaultIngredientShouldNotBeFound("assoDishIngId.equals=" + (assoDishIngId + 1));
    }


    @Test
    @Transactional
    public void getAllIngredientsByAssoCocktailIngIsEqualToSomething() throws Exception {
        // Initialize the database
        AssoCocktailIng assoCocktailIng = AssoCocktailIngResourceIntTest.createEntity(em);
        em.persist(assoCocktailIng);
        em.flush();
        ingredient.addAssoCocktailIng(assoCocktailIng);
        ingredientRepository.saveAndFlush(ingredient);
        Long assoCocktailIngId = assoCocktailIng.getId();

        // Get all the ingredientList where assoCocktailIng equals to assoCocktailIngId
        defaultIngredientShouldBeFound("assoCocktailIngId.equals=" + assoCocktailIngId);

        // Get all the ingredientList where assoCocktailIng equals to assoCocktailIngId + 1
        defaultIngredientShouldNotBeFound("assoCocktailIngId.equals=" + (assoCocktailIngId + 1));
    }


    @Test
    @Transactional
    public void getAllIngredientsByAssoDessertIngIsEqualToSomething() throws Exception {
        // Initialize the database
        AssoDessertIng assoDessertIng = AssoDessertIngResourceIntTest.createEntity(em);
        em.persist(assoDessertIng);
        em.flush();
        ingredient.addAssoDessertIng(assoDessertIng);
        ingredientRepository.saveAndFlush(ingredient);
        Long assoDessertIngId = assoDessertIng.getId();

        // Get all the ingredientList where assoDessertIng equals to assoDessertIngId
        defaultIngredientShouldBeFound("assoDessertIngId.equals=" + assoDessertIngId);

        // Get all the ingredientList where assoDessertIng equals to assoDessertIngId + 1
        defaultIngredientShouldNotBeFound("assoDessertIngId.equals=" + (assoDessertIngId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned
     */
    private void defaultIngredientShouldBeFound(String filter) throws Exception {
        restIngredientMockMvc.perform(get("/api/ingredients?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ingredient.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].urlImg").value(hasItem(DEFAULT_URL_IMG.toString())));
    }

    /**
     * Executes the search, and checks that the default entity is not returned
     */
    private void defaultIngredientShouldNotBeFound(String filter) throws Exception {
        restIngredientMockMvc.perform(get("/api/ingredients?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @Transactional
    public void getNonExistingIngredient() throws Exception {
        // Get the ingredient
        restIngredientMockMvc.perform(get("/api/ingredients/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIngredient() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        int databaseSizeBeforeUpdate = ingredientRepository.findAll().size();

        // Update the ingredient
        Ingredient updatedIngredient = ingredientRepository.findById(ingredient.getId()).get();
        // Disconnect from session so that the updates on updatedIngredient are not directly saved in db
        em.detach(updatedIngredient);
        updatedIngredient
            .name(UPDATED_NAME)
            .urlImg(UPDATED_URL_IMG);
        IngredientDTO ingredientDTO = ingredientMapper.toDto(updatedIngredient);

        restIngredientMockMvc.perform(put("/api/ingredients")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ingredientDTO)))
            .andExpect(status().isOk());

        // Validate the Ingredient in the database
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeUpdate);
        Ingredient testIngredient = ingredientList.get(ingredientList.size() - 1);
        assertThat(testIngredient.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testIngredient.getUrlImg()).isEqualTo(UPDATED_URL_IMG);
    }

    @Test
    @Transactional
    public void updateNonExistingIngredient() throws Exception {
        int databaseSizeBeforeUpdate = ingredientRepository.findAll().size();

        // Create the Ingredient
        IngredientDTO ingredientDTO = ingredientMapper.toDto(ingredient);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restIngredientMockMvc.perform(put("/api/ingredients")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ingredientDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Ingredient in the database
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIngredient() throws Exception {
        // Initialize the database
        ingredientRepository.saveAndFlush(ingredient);

        int databaseSizeBeforeDelete = ingredientRepository.findAll().size();

        // Get the ingredient
        restIngredientMockMvc.perform(delete("/api/ingredients/{id}", ingredient.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        assertThat(ingredientList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Ingredient.class);
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(ingredient1.getId());
        assertThat(ingredient1).isEqualTo(ingredient2);
        ingredient2.setId(2L);
        assertThat(ingredient1).isNotEqualTo(ingredient2);
        ingredient1.setId(null);
        assertThat(ingredient1).isNotEqualTo(ingredient2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IngredientDTO.class);
        IngredientDTO ingredientDTO1 = new IngredientDTO();
        ingredientDTO1.setId(1L);
        IngredientDTO ingredientDTO2 = new IngredientDTO();
        assertThat(ingredientDTO1).isNotEqualTo(ingredientDTO2);
        ingredientDTO2.setId(ingredientDTO1.getId());
        assertThat(ingredientDTO1).isEqualTo(ingredientDTO2);
        ingredientDTO2.setId(2L);
        assertThat(ingredientDTO1).isNotEqualTo(ingredientDTO2);
        ingredientDTO1.setId(null);
        assertThat(ingredientDTO1).isNotEqualTo(ingredientDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(ingredientMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(ingredientMapper.fromId(null)).isNull();
    }
}
