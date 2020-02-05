package it.contrader.dynsearch.service.dto;

import java.io.Serializable;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;






/**
 * Criteria class for the Ingredient entity. This class is used in IngredientResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ingredients?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class IngredientCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private StringFilter name;

    private StringFilter urlImg;

    private LongFilter assoDishIngId;

    private LongFilter assoCocktailIngId;

    private LongFilter assoDessertIngId;

    public IngredientCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(StringFilter urlImg) {
        this.urlImg = urlImg;
    }

    public LongFilter getAssoDishIngId() {
        return assoDishIngId;
    }

    public void setAssoDishIngId(LongFilter assoDishIngId) {
        this.assoDishIngId = assoDishIngId;
    }

    public LongFilter getAssoCocktailIngId() {
        return assoCocktailIngId;
    }

    public void setAssoCocktailIngId(LongFilter assoCocktailIngId) {
        this.assoCocktailIngId = assoCocktailIngId;
    }

    public LongFilter getAssoDessertIngId() {
        return assoDessertIngId;
    }

    public void setAssoDessertIngId(LongFilter assoDessertIngId) {
        this.assoDessertIngId = assoDessertIngId;
    }

    @Override
    public String toString() {
        return "IngredientCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
                (urlImg != null ? "urlImg=" + urlImg + ", " : "") +
                (assoDishIngId != null ? "assoDishIngId=" + assoDishIngId + ", " : "") +
                (assoCocktailIngId != null ? "assoCocktailIngId=" + assoCocktailIngId + ", " : "") +
                (assoDessertIngId != null ? "assoDessertIngId=" + assoDessertIngId + ", " : "") +
            "}";
    }

}
