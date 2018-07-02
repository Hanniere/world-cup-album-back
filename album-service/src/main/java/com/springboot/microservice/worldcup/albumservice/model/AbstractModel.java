package com.springboot.microservice.worldcup.albumservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is Abstract Model which contains shared attributes and behavior between the concret models.
 * @author Hanniere
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractModel {

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    private Long id;


    public AbstractModel() {
        // TODO Auto-generated constructor stub
    }

    public AbstractModel (Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public boolean equals(AbstractModel obj) {
        return obj.id == this.id;
    }

}
