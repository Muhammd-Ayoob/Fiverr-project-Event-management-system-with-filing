/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojos.Event;
import java.util.List;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public interface EventDao {
    public void addEvent();
    
    public List<Event> fillArrayList();
    public void displayAllEvents();
    public void delete();
    
    public void getEventByName();
         
    public void getEventByFees();
    public void exit();
    
    public void registerEvent();
    //public void menu();
        
    
}
