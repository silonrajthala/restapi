package test.clon.restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "users")  // Map this class to the "users" table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // This maps to the "id" column (Auto Increment)
    private int id;

    @Column(name = "bin")
    private Integer bin;

    @Column(name = "fname", nullable = false)  // Map to "fname" column
    private String fname;

    @Column(name = "lname", nullable = false)  // Map to "lname" column
    private String lname;

    @Column(name = "mobilenumber", nullable = false)  // Map to "mobilenumber" column
    private String mobilenumber;

    @Column(name = "countrycode", nullable = false)  // Map to "countrycode" column
    private String countrycode;

    @Column(name = "usertype", nullable = false)
    private int usertype;

    @Column(name = "isactive", nullable = false)  // Map to "isactive" column
    private String isactive;

    @Column(name = "email", nullable = false)  // Map to "email" column
    private String email;

//    @Column(name = "email_verified_at")  // Map to "email_verified_at" column
//    private Date emailVerifiedAt;

    @Column(name = "password", nullable = false)  // Map to "password" column
    private String password;

//    @Column(name = "remember_token")  // Map to "remember_token" column
//    private String rememberToken;
//
//    @Column(name = "created_at")  // Map to "created_at" column
//    private Date createdAt;
//
//    @Column(name = "updated_at")  // Map to "updated_at" column
//    private Date updatedAt;

    // Getters and Setters for all fields

}