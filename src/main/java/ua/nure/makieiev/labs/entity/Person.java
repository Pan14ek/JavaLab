package ua.nure.makieiev.labs.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

}