/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImpl;

import com.Dao.EventDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class AllMenuClass {
    
    
    
    
    //Main menu
    public void mainMenu()
    {
        String choice;
        boolean b=false;
        Integer number=0;
     do{   
        
         JFrame frame=new JFrame();
        List list=new ArrayList();
        
        
        list.add("~~Welcome to my mini event management system~~");
        
        list.add("\n");
        list.add("Enter the type of user:");
        list.add("\n");
        list.add("1.  Administrator");
        list.add("2.  User");
        list.add("3.  Exit");
        list.add("\n");
        
        
       String output = "";
       
       
        for(int i = 0; i<list.size(); i++){
    
        String listContent = list.get(i).toString();

        output += listContent+"\n";       
     }
        
        
        try{
        
         choice=JOptionPane.showInputDialog(frame,output,"Event",JOptionPane.QUESTION_MESSAGE);
         
         number=Integer.parseInt(choice);
         
         b=false;
         
         
       if(number==0)
           b=true;
          
        }
        
       catch(Exception e){}
        
        
        
        if(number==1)
        {
            administratorMenu();
        }
        
       else if(number==2)
        {
            userMenu();
        }
       else if(number==3)
        {
            exit();
        }
        else
        {
            
            JOptionPane.showMessageDialog(null,"Invalid input! please enter the range from 1 to 3","Error",JOptionPane.ERROR_MESSAGE);
          
        }
     }
   while(number>3||b);
    } 
 
    
    
    
    
    
    
    
    
    
    //Administrator menu
    
    public void administratorMenu()
    {
       
        Integer number=0;
        do{
        EventDao eventDao=new EventDaoImpl();
        JFrame frame=new JFrame();
        
        List list=new ArrayList();
        
        list.add("Enter your option(Administrator);");
        
        list.add("\n");
        
        list.add("1.  Display all events");
        list.add("2.  Add Event");
        list.add("3.  Delete Event");
        list.add("4.  Exit");
        
        list.add("\n");
        
        String output = "";
        for(int i = 0; i<list.size(); i++){
    
        String listContent = list.get(i).toString();

        output += listContent+"\n";       
     }
        
            
        String choice=JOptionPane.showInputDialog(frame,output,"Event",JOptionPane.QUESTION_MESSAGE);
   
        number=Integer.parseInt(choice);
        
        
       
        if(number==1)
        {
            eventDao.displayAllEvents();
        }
        else if(number==2)
        {   
            eventDao.addEvent();
        }
       else if(number==3)
        {
            eventDao.delete();
        }
       else if(number==4)
        {eventDao.exit();}
       else
       {JOptionPane.showMessageDialog(null,"Invalid input! please enter the range from 1 to 4","Error",JOptionPane.ERROR_MESSAGE);}
       }
     while(number>4);  
    }
    
    
    
    
    
    
    //User menu
    public void userMenu()
    {
        
     Integer number=0;   
        do
        {
            EventDao eventDao=new EventDaoImpl();
        
        JFrame frame=new JFrame();
        
        List list=new ArrayList();
        list.add("Enter your option(User);");
        
        list.add("\n");
        
        list.add("1.  Display all events");
        list.add("2.  Search Event(by Event Name)");
        list.add("3.  Search Event (by Event Fees)");
        list.add("4.  Register Event");
        list.add("5.  Exit");
        
        list.add("\n");
        
        String output = "";
        for(int i = 0; i<list.size(); i++){
    
        String everything2 = list.get(i).toString();

        output += everything2+"\n";       
     }
        String choice=JOptionPane.showInputDialog(frame,output,"Event",JOptionPane.QUESTION_MESSAGE);
        
   
        number=Integer.parseInt(choice);
        if(number==1)
        {
            eventDao.displayAllEvents();
        }
        else if(number==2)
        {   
            
            eventDao.getEventByName();
        }
        else if(number==3)
        {
            eventDao.getEventByFees();
        }
        else if(number==4)
        {
            eventDao.registerEvent();
        }
        else if(number==5)
        {
            eventDao.exit();
        }
        else
        {JOptionPane.showMessageDialog(null,"Invalid input! please enter the range from 1 to 5","Error",JOptionPane.ERROR_MESSAGE);}
        }
        while(number>5);
    }
    
    
    
    
    
    
    
    //Exit Method
    
  public void exit(){JOptionPane.showMessageDialog(null,"Program terminated succesflly");}
}



