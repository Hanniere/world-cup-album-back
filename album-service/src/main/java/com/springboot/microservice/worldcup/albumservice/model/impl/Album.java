package com.springboot.microservice.worldcup.albumservice.model.impl;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull(message = "User id required")
	private Integer userId;

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

	public Album(Integer id, Integer userId,
			Double price, Set<Sticker> stickerList) {
		super();
		this.id = id;
		this.userId = userId;
		this.price = price;
		this.stickerSet = stickerList;
	}


	@SuppressWarnings("unchecked")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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
