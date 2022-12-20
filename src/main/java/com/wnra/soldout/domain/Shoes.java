package com.wnra.soldout.domain;

import com.wnra.soldout.domain.crud.CrudListener;
import com.wnra.soldout.domain.crud.CrudOperations;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EntityListeners(CrudListener.class)
@DiscriminatorValue(ProductConstants.SHOE_TYPE)
public class Shoes extends Product implements CrudOperations {
    @Column(name = "shoes_attribute")
    private String shoesAttribute;
}