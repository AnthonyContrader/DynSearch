package it.contrader.dynsearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Ingredient.
 */
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "url_img", nullable = false)
    private String urlImg;

    @OneToMany(mappedBy = "idingredient")
    private Set<AssoDishIng> assoDishIngs = new HashSet<>();

    @OneToMany(mappedBy = "idingredient")
    private Set<AssoCocktailIng> assoCocktailIngs = new HashSet<>();

    @OneToMany(mappedBy = "idingredient")
    private Set<AssoDessertIng> assoDessertIngs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Ingredient name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public Ingredient urlImg(String urlImg) {
        this.urlImg = urlImg;
        return this;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Set<AssoDishIng> getAssoDishIngs() {
        return assoDishIngs;
    }

    public Ingredient assoDishIngs(Set<AssoDishIng> assoDishIngs) {
        this.assoDishIngs = assoDishIngs;
        return this;
    }

    public Ingredient addAssoDishIng(AssoDishIng assoDishIng) {
        this.assoDishIngs.add(assoDishIng);
        assoDishIng.setIdingredient(this);
        return this;
    }

    public Ingredient removeAssoDishIng(AssoDishIng assoDishIng) {
        this.assoDishIngs.remove(assoDishIng);
        assoDishIng.setIdingredient(null);
        return this;
    }

    public void setAssoDishIngs(Set<AssoDishIng> assoDishIngs) {
        this.assoDishIngs = assoDishIngs;
    }

    public Set<AssoCocktailIng> getAssoCocktailIngs() {
        return assoCocktailIngs;
    }

    public Ingredient assoCocktailIngs(Set<AssoCocktailIng> assoCocktailIngs) {
        this.assoCocktailIngs = assoCocktailIngs;
        return this;
    }

    public Ingredient addAssoCocktailIng(AssoCocktailIng assoCocktailIng) {
        this.assoCocktailIngs.add(assoCocktailIng);
        assoCocktailIng.setIdingredient(this);
        return this;
    }

    public Ingredient removeAssoCocktailIng(AssoCocktailIng assoCocktailIng) {
        this.assoCocktailIngs.remove(assoCocktailIng);
        assoCocktailIng.setIdingredient(null);
        return this;
    }

    public void setAssoCocktailIngs(Set<AssoCocktailIng> assoCocktailIngs) {
        this.assoCocktailIngs = assoCocktailIngs;
    }

    public Set<AssoDessertIng> getAssoDessertIngs() {
        return assoDessertIngs;
    }

    public Ingredient assoDessertIngs(Set<AssoDessertIng> assoDessertIngs) {
        this.assoDessertIngs = assoDessertIngs;
        return this;
    }

    public Ingredient addAssoDessertIng(AssoDessertIng assoDessertIng) {
        this.assoDessertIngs.add(assoDessertIng);
        assoDessertIng.setIdingredient(this);
        return this;
    }

    public Ingredient removeAssoDessertIng(AssoDessertIng assoDessertIng) {
        this.assoDessertIngs.remove(assoDessertIng);
        assoDessertIng.setIdingredient(null);
        return this;
    }

    public void setAssoDessertIngs(Set<AssoDessertIng> assoDessertIngs) {
        this.assoDessertIngs = assoDessertIngs;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredient ingredient = (Ingredient) o;
        if (ingredient.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ingredient.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", urlImg='" + getUrlImg() + "'" +
            "}";
    }
}
