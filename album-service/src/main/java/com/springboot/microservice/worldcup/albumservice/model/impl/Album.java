package com.springboot.microservice.worldcup.albumservice.model.impl;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.springboot.microservice.worldcup.albumservice.model.AbstractModel;


@Entity
@Table(name = "album")
public class Album extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "User id required")
    private Long userId;

    @NotNull(message = "Price required")
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "album_sticker",
            joinColumns = {@JoinColumn(name = "album_id")},
            inverseJoinColumns = {@JoinColumn(name = "sticker_id")})
    Set<Sticker> stickerSet;


    public Album() {
        // TODO Auto-generated constructor stub
    }

    public Album(Long id, Long userId,
            Double price, Set<Sticker> stickerList) {
        super(id);
        this.userId = userId;
        this.price = price;
        this.stickerSet = stickerList;
    }

    public Album(Long userId,
            Double price) {
        this.userId = userId;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Sticker> getStickerSet() {
        return stickerSet;
    }

    public void setStickerSet(Set<Sticker> stickerList) {
        this.stickerSet = stickerList;
    }

}
