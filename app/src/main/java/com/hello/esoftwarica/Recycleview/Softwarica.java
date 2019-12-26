package com.hello.esoftwarica.Recycleview;

public class Softwarica {

    private String name;
    private String gender;
    private String address;
    private int age;
    private int imgProfileId;
    private int imgRemoveId;


    public  Softwarica(String name, String gender, String address, int age){
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.imgProfileId = imgProfileId;
        this.imgRemoveId = imgRemoveId;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImgProfileId() {
        return imgProfileId;
    }

    public void setImgProfileId(int imgProfileId) {
        this.imgProfileId = imgProfileId;
    }

    public int getImgRemoveId() {
        return imgRemoveId;
    }

    public void setImgRemoveId(int imgRemoveId) {
        this.imgRemoveId = imgRemoveId;
    }


}
