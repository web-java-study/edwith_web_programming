package com.example.reservation.domain;

public class CategoryDisplay {
    private Integer id;
    private Integer product_id;
    private String opening_hours;
    private String place_name;
    private String place_lot;
    private String place_street;
    private String tel;
    private String homepage;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_lot() {
        return place_lot;
    }

    public void setPlace_lot(String place_lot) {
        this.place_lot = place_lot;
    }

    public String getPlace_street() {
        return place_street;
    }

    public void setPlace_street(String place_street) {
        this.place_street = place_street;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
