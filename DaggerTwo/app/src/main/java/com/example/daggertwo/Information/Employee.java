package com.example.daggertwo.Information;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Employee {
    @SerializedName("first_name")
    private String name;
    @SerializedName("age")
    private int age;
    @SerializedName("isMarried")
    private boolean isMarried;
    private Address address;
    private ArrayList<FamilyMember>members;
    public Employee(String name, int age, boolean isMarried,Address address,ArrayList<FamilyMember>members) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.address = address;
        this.members = members;
    }
}
