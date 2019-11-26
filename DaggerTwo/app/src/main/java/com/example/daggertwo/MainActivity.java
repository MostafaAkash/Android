package com.example.daggertwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daggertwo.Information.Address;
import com.example.daggertwo.Information.Employee;
import com.example.daggertwo.Information.FamilyMember;
import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
   @Inject
   Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.builder().petrolModule(new PetrolModule(100)).build();
         //car = component.getCar();
        component.inject(this);
        //car.setContext(this);
        car.drive(this);


        Gson gson = new Gson();/*
        Address addressOne = new Address("Bangladesh","Dhaka");
        FamilyMember memberOne = new FamilyMember("Father",50);
        FamilyMember memberTwo = new FamilyMember("Daughter",22);
        ArrayList<FamilyMember>members = new ArrayList<>();
        members.add(memberOne);
        members.add(memberTwo);*/
        /*
        Employee employee = new Employee("Golam Mostafa",24,false,addressOne,members);
        String json = gson.toJson(employee);
        json.trim();*/


      /*
      String json = "{\"age\":24,\"isMarried\":false,\"first_name\":\"Golam Mostafa\"}";
      Employee employee = gson.fromJson(json,Employee.class);
      Employee employee1 =employee;*/

      String json ="[\n" +
              "    {\n" +
              "      \"age\": 50,\n" +
              "      \"memberType\": \"Father\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"age\": 22,\n" +
              "      \"memberType\": \"Daughter\"\n" +
              "    }\n" +
              "  ]";
      FamilyMember[] familyMembers = gson.fromJson(json,FamilyMember[].class);
      FamilyMember[] familyMembers1 = familyMembers;
    }

}
