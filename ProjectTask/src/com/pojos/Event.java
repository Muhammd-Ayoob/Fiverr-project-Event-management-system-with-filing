/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class Event {
    private Integer id;
    private String name;
    
    private String organizer;
    
    private Date date;
    
    private double fees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

   

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    } 

    @Override
    public String toString() {
        return id +"                                     " + name + "                                  " + organizer + "                                " + date + "                       " + fees;
    }

    
    
}
