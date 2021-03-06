package com.example.coleman.beans;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Long surveyId;
    public Person() {

    }
    public Person(String nom, String prenom, String email, String telephone){
        this.email =email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getsurveyId() {
        return surveyId;
    }

    public void setsurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return nom.equals(person.nom) && prenom.equals(person.prenom) && email.equals(person.email) && telephone.equals(person.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, email, telephone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
