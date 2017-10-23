package Zuul_Framework;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
// this class is used for crating room objects for the player to transition between
public class Room 
{
    private String description;             //a string that will carry the description of the room
    private HashMap<String, Room> exits;    // HashMap that carrys each exit from the room and which room it leads to
    //constructor that sets the rooms description
    private Item immovables;
    private ArrayList<Immovable> interactList;
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();    // a new exit HashMap is crated for each instance of room
        interactList = new ArrayList<>();
    }
    //method for setting the exits of a room with a direction (key) and a neighbor room object
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    //method for returning a rooms description
    public String getShortDescription()
    {
        return description;
    }
    // method for getting a rooms description and which exits it has.
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
        //private method that is used in here to descripe the exits based on the rooms exit HashMap 
	private String getExitString()
    {
        String returnString = "There are exits to the ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
        //method for getting the exits from a room
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    public void searchRoom(){
        if(this.interactList.isEmpty()){
            System.out.println("There is nothing in the room");
        } else {
            System.out.println("You notice the following stuff in the room:");
            for(Immovable i : this.interactList){
                System.out.println(i.getName());
            }
        }
        
    }
    public void setImmovables(Immovable immovables){
        this.interactList.add(immovables);
    }
    
    public Immovable getImmovable(String immovable) {
        Immovable object = null;
        for (Immovable i : this.interactList){
            if (findImmovable(immovable)) {
                object = i;   
            }
        }
        return object; //object might not have been initialised, but this method is not used if the object isn't found
    }
    
    

    public String checkItems(String itemName){
        if(this.interactList.isEmpty()){
            return "Placeholder";
        } 
        else {
        String itemDescription = "";
        for(Immovable i : this.interactList){
            if(i.getName().equals(itemName)){
                itemDescription = i.getDescription();
                return itemDescription;
            }else{
                itemDescription = "What item are you carrying?";
            }
        }
        return itemDescription;
        }
    }
    
    public boolean findImmovable(String immovable) {
        boolean bool = false;
        for(Immovable i : this.interactList){
            if(i.getName().equals(immovable)){
                bool = true;
                break;
            }
            else{
                bool = false;
            }
        }
        return bool;
    }
}