/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImpl;

import com.Dao.EventDao;
import com.pojos.Event;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.*;
import java.nio.*;
import java.util.*;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class EventDaoImpl implements EventDao
{  
    
    Integer count=0;//field to count the number of reows already exits in file, accordingly we can assign id to new row to be added
    
    
    List<Event> list=new ArrayList();//Array list to strore data
    
    AllMenuClass allMenuClass=new AllMenuClass();
    
    
    
    
    
    
    //Add Event method
    public void addEvent()
    {
    try{
        
         try{
             //File path
        Scanner file = new Scanner(new File("./event.txt"));
        

//Loop to count existing rows in file.
        while(file.hasNext()){
            
        count++;
        
         file.nextLine();
        }
        
        
    }catch(Exception e){e.printStackTrace();}
        
        
         Event event=new Event();
         
        event.setId(count+1);
        String name;
         boolean b;
         do{   
        name=JOptionPane.showInputDialog("Enter name");
        
       b=false;
        if(count!=0)
        {
            //Loop to check that entered event is not Duplicate.
            List<Event>eventList=new ArrayList();
            eventList=fillArrayList();
            for(Event e:eventList)
            {
                if(e.getName().equals(name))
                {
                    b=true;
                    JOptionPane.showMessageDialog(null,"Sorry this event already exists! Duplicate are not allowed.","Error",JOptionPane.ERROR_MESSAGE);
                    
                    break;
                }
            }
        }
        
         }while(b);
        event.setName(name);
        
        String organizer=JOptionPane.showInputDialog("Enter organizer");
        event.setOrganizer(organizer);
        
        String date=JOptionPane.showInputDialog("Enter date");
        Date date1=Date.valueOf(date);
        double fees = Double.parseDouble(JOptionPane.showInputDialog(null," Enter Salary: "));
        event.setFees(fees);
        
        list.add(event);
      
       File f=new File("./event.txt");
       
        PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
        
        pw.append((count+1)+","+name+","+organizer+","+date1+","+fees);
        pw.append("\n");
        pw.close();
        }
    
        catch(Exception e){e.printStackTrace();}
    
    JOptionPane.showMessageDialog(null,"Event Added succesfully");
    
    allMenuClass.administratorMenu();
    }
    
    
    
    
    
    
    
   //Method to fill Array list with File Data
    public List<Event> fillArrayList()
    {
        List<Event> list1=new ArrayList<>();
        FileReader fr=null;
        
       try{
           
         fr=new FileReader("./event.txt");
         BufferedReader bf=new BufferedReader(fr);
         String s;
         
         while((s=bf.readLine())!=null)
         {
             Event event=new Event();
             String s1[]=new String[7];
             for(int i=0;i<s1.length;i++)
             {
                s1=s.split(",");
                
                event.setId(Integer.parseInt(s1[0]));
                
                 event.setName(s1[1]);
                 
                 event.setOrganizer(s1[2]);
                 
               Date date=Date.valueOf(s1[3]);
               
                event.setDate(date);
                
                event.setFees(Double.parseDouble(s1[4]));
                 
             }   
            list1.add(event);
         }
         
          bf.close();
          
       }catch(Exception e){e.printStackTrace();}
        return list1;

    }
    
    
    
    
    
    
    
    
    
    
    //Method to Display all events Existing in file
    public void displayAllEvents()
    {
        
        List<Event> list;
        
        list=fillArrayList();
        
        List list2=new ArrayList();
        list2.add("Id");
        list2.add("Event name");
        list2.add("Organizer");
        list2.add("date");
        list2.add("fees");
        
        
       String output = "";
       output="Id                              "+"Event Name                          "+"Organizer                                  "+"Date                           "+"          Fees($)"+"\n";
        System.out.println();
    for(int i = 0; i<list.size(); i++){
    
    String everything2 = list.get(i).toString();

    output += everything2+"\n"+"\n";       
    }
    JOptionPane.showMessageDialog(null,output,"AllEvents",JOptionPane.INFORMATION_MESSAGE);
    allMenuClass.mainMenu();
    }
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    
    
    
    
    
    
    
    
    
    
    
    //Method to Delete Event
    @Override
    public void delete() 
    {   
        List list1=new ArrayList(); 
        
        
    try {
        FileReader file=new FileReader("./event.txt");
        
        BufferedReader br=new BufferedReader(file);
        
        String s;
        
        while((s=br.readLine())!=null)
        {
            list1.add(s);
        }
        
    } catch (Exception ex) {}
    
    String name=JOptionPane.showInputDialog("Enter Event name to Delete");
    
        for(int i=0;i<list1.size();i++)
        {
            String s=list1.get(i).toString();
            if(s.contains(name))
            {
                list1.remove(s);
            }
        }
        try{
            
        PrintWriter writer = new PrintWriter("./event.txt");
        
        writer.print("");
        
        writer.close();
        
        }catch(Exception e){e.printStackTrace();}
        
        try{
            
        FileWriter fw=new FileWriter("./event.txt");
        BufferedWriter bwriter=new BufferedWriter(fw);
        
        
        for(int i=0;i<list1.size();i++)
        {
            bwriter.write(list1.get(i).toString()+"\n");
        }
        bwriter.close();
        
        
        }catch(Exception e){e.printStackTrace();}
        
        JOptionPane.showMessageDialog(null,"Event Deleted succesfully");
        
        allMenuClass.administratorMenu();
    }
    
    
    
    
    
    
    
    
    
    
    
    //Method to get Event by name
    public void getEventByName()
    {
           
         boolean b=false;
       
        
       String output = "";
       output="Id                                   "+"Event Name                            "+"Organizer                             "+"Date               "+"            Fees($)"+"\n";       
       
        
        List<Event> list2=new ArrayList();
        do{
        
        List<Event> list1=fillArrayList();
       
        
        String string=JOptionPane.showInputDialog("Enter Event Name to search Event by Name");
       
        for(Event e:list1)
        {
            if(e.getName().equals(string))
            {
                list2.add(e);
                b=true;
                break;
            }
            else
            {
       
                b=false;
            }
        }
        if(!b)
           JOptionPane.showMessageDialog(null,"Event  "+string+"   Does not exist! please try again","Error",JOptionPane.ERROR_MESSAGE);
       }while(!b);
        
        
    for(int i = 0; i<list2.size(); i++){
    
    String everything2 = list2.get(i).toString();

    output += everything2+"\n";       
    }
    JOptionPane.showMessageDialog(null,output,"Event",JOptionPane.INFORMATION_MESSAGE);
    
    allMenuClass.userMenu();
    }
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    //Method to get Event by Fees
    
    public void getEventByFees()
    {
         boolean b=false;
       
         String output = "";
       output="Id                                  "+"Event Name                           "+"Organizer                                 "+"Date             "+"               Fees($)"+"\n";
         
        List<Event> list2=new ArrayList();
        do{
        
        List<Event> list1=fillArrayList();
       
        
        String string=JOptionPane.showInputDialog("Enter Event Fees to search Event by Fees");
        double fees=Double.parseDouble(string);
        for(Event e:list1)
        {
            if(e.getFees()==fees)
            {
                list2.add(e);
                b=true;
                break;
            }
            else
            {
       
                b=false;
            }
        }
        if(!b)
           JOptionPane.showMessageDialog(null,"Event with fees "+string+"    Does not exist! please try again","Error",JOptionPane.ERROR_MESSAGE);
       }while(!b);
        
      
    for(int i = 0; i<list2.size(); i++){
    
    String everything2 = list2.get(i).toString();

    output += everything2+"\n";       
    }
    JOptionPane.showMessageDialog(null,output,"Event",JOptionPane.INFORMATION_MESSAGE);
    
    allMenuClass.userMenu();
   }
    
    
    
    
    //Event Registeration Method
    public void registerEvent()
    {
        
        Integer response=0;
        boolean b;
        double cost=0;
        
        
        List<Event> registeredEvents=new ArrayList<>();
        
        Scanner file=null;
        
        try{
            
            
         file = new Scanner(new File("./event.txt"));
         
         
        }catch(Exception e){}

        
        
//Loop to count existing rows in file.
        while(file.hasNext()){
            
        count++;
        
         file.nextLine();
        }
        
        String name;
        
       do{ 
           
        name=JOptionPane.showInputDialog("Enter Event name to Register");
        
        b=false;
        if(count!=0)//Condition if any Event exist in file then it can be registered
        {
            
            List<Event> eventList=fillArrayList();
            
            for(Event e:eventList)
            {
                if(e.getName().equals(name))
                {
                registeredEvents.add(e);
                b=true;
                cost=cost+e.getFees();
                break;
                }
                else{b=false;}
            }
            
            if(b)
            {
                JOptionPane.showMessageDialog(null,"Event registered sussfully");
                response=JOptionPane.showConfirmDialog(null,"DO YOU WANT TO REGISTER ANY OTHER EVENT?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Event "+name+"Does not exist","Error",JOptionPane.ERROR_MESSAGE);
            }
        
        }
        
        
       
       }while(response==JOptionPane.YES_OPTION||!b);
       
       
       try{
            
        FileWriter fw=new FileWriter("./RegisteredEvents.txt");
        BufferedWriter bwriter=new BufferedWriter(fw);
        
        
        for(int i=0;i<registeredEvents.size();i++)
        {
            bwriter.write(registeredEvents.get(i).toString()+"\n");
        }
        bwriter.close();
        
        
        }catch(Exception e){e.printStackTrace();}
       
       
       
       String output="";
       
       output+="You hava registered for the following event(s);\n";
       
       for(int i = 0; i<registeredEvents.size(); i++){
    
        String everything2 ="* "+registeredEvents.get(i).getName();

    output += everything2+"\n";       
    }
       output+="\n";
       output+="cost is $"+cost;
    JOptionPane.showMessageDialog(null,output,"Event",JOptionPane.INFORMATION_MESSAGE);
       allMenuClass.userMenu();
  }
    
    
    
    
    //Program exit method
    public void exit(){JOptionPane.showMessageDialog(null,"Program terminated succesflly");}
     
}

