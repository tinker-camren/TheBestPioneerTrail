/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.awt.Point;

/**
 *
 * @author Guest
 */
public enum Actor {
    Father("Kevin", 'M', "Adult", 100, new Point(1,1)),
    Mother("Jannette", 'F', "Adult", 100, new Point(1,1)),
    Child1("Chris", 'M', "Child", 100, new Point(1,1)),
    Child2("Thomas", 'M', "Child", 100, new Point(1,1)),
    Child3("Lili",'F', "Child", 100, new Point(1,1));
    
    private String name;
    private char gender;
    private String type;
    private int health;
    private Point coordinates;
    
    Actor(String name, char gender, String type, int health, Point coordinates){
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.health = health;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", gender=" + gender + ", type=" + type + ", health=" + health + ", coordinates=" + coordinates + '}';
    }

    public void setName(String richie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setHealth(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
