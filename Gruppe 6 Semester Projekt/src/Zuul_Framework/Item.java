/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zuul_Framework;

/**
 *
 * @author bruger
 */
//The item class.
//This is where the pickupable item objects is created.
public class Item implements Interactables {
    //Name, description, and use description is defined.
    private String itemName, itemDescription, useDescription;
    private boolean flag;
    private final boolean isPickupable = true;
    private int dmg, HP, air; 
    
    //This is the method that created the item object.
    public Item(String itemName, String itemDescription, int dmg, int HP, int air) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.dmg = dmg;
        this.HP = HP;
        this.air = air;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHP() {
        return HP;
    }

    public int getAir() {
        return air;
    }
    
    
    //The following methods are the methods implemented from our interactables
    //interface. These are also used in the Destructables class.
    @Override
    //returns the name of the object
    public String getName() {
        return itemName;
    }

    @Override
    //returns the description of the object
    public String getDescription() {
        return itemDescription;
    }

    @Override
    //returns the use description of the object
    public String getUseDescription() {
       return useDescription;
    }

    @Override
    //returns a 
    public boolean isPickupable() {
       return this.isPickupable;
    }
    
    @Override
    public void setFlag(Boolean flag){
        this.flag = flag;
    }

    @Override
    public boolean getFlag() {
        return this.flag; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDescription(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}