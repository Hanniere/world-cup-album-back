package com.springboot.microservice.worldcup.albumservice.model.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springboot.microservice.worldcup.albumservice.model.AbstractModel;

@Entity
@Table(name = "sticker")
public class Sticker extends AbstractModel implements Serializable  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Album required")
    private String team;

    @NotNull(message = "Price required")
    private String picture;

    @NotNull(message = "Price required")
    private String name;

    public Sticker() {
        // TODO Auto-generated constructor stub
    }
    public Sticker(Long id, String team, String picture, String name) {
        super(id);
        this.team = team;
        this.picture = picture;
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
