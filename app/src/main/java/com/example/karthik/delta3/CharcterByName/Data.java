package com.example.karthik.delta3.CharcterByName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by karthik on 03-07-2018.
 */

public class Data {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("dateOfBirth")
    @Expose
    private Integer dateOfBirth;
    @SerializedName("imageLink")
    @Expose
    private String imageLink;
    @SerializedName("male")
    @Expose
    private Boolean male;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("pageRank")
    @Expose
    private Double pageRank;
    @SerializedName("hasPath")
    @Expose
    private Boolean hasPath;
    @SerializedName("books")
    @Expose
    private List<String> books = null;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("titles")
    @Expose
    private List<Object> titles = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Double getPageRank() {
        return pageRank;
    }

    public void setPageRank(Double pageRank) {
        this.pageRank = pageRank;
    }

    public Boolean getHasPath() {
        return hasPath;
    }

    public void setHasPath(Boolean hasPath) {
        this.hasPath = hasPath;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Object> getTitles() {
        return titles;
    }

    public void setTitles(List<Object> titles) {
        this.titles = titles;
    }

}
