/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum03;

import java.io.Serializable;

/**
 *
 * @author biobii
 */
public class Participant implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    
    public Participant(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
}
