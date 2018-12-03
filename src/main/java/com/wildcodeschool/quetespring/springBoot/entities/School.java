package com.wildcodeschool.quetespring.springBoot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class School {
	
	public School() {
		
	}
	
	public School (String name, int numberStudents, String language) {
		this.name = name;
		this.numberStudents = numberStudents;
		this.language = language;		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
	
	private String name;
	
	private int numberStudents;
	
	private String language;
	
	
	@Override
    public String toString() { 
        return "School [id=" + id + ", name=" + name + 
                ", numberStudents=" + numberStudents + ", languages=" + language + "]";
    }                    

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }    
}
