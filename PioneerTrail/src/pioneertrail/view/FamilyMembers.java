/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.model.Actor;

/**
 *
 * @author Kathy
 */
////////////6-23-18 changes
class FamilyMembers extends View {

    public FamilyMembers() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {
        String input = "**********"
                + "\nFamily Members List"
                + "\nFind more about details of each actor"
                + "\n**********";

        int count = 0;
        int strongest = 0;
        String strongestPerson = "";
        for (Actor actor : Actor.values()) {
            count++;
            input += ("\n\t" + count + " - " + actor.getName());
           if (Integer.max(strongest, actor.getStrength()) > strongest) {
                strongest = actor.getStrength();
                strongestPerson = actor.getName();
            
            }
           
        }
        input += "\n\t" + (Actor.values().length + 1) + " - Run Report";
        input += "\n Strongest Family member is: "+ strongestPerson+" ("+ strongest + ")";
        input += ("\nEnter your selection(Press Q to quit): ");

            return input;
        }

        @Override
        public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

            int value = Integer.parseInt(menuItem);
            if ((value < 1) || (value > (Actor.values().length + 1))) {
                ErrorView.display(this.getClass().getName(), "Invalid menu item");

                return false;
            }
//        this.name = name;
//        this.gender = gender;
//        this.type = type;
//        this.health = health;
//        this.coordinates = coordinates;
            if (value == (Actor.values().length + 1)) {
                ActorReport actorReport = new ActorReport();
                actorReport.display();
                return false;
            } else {
            value--;
                this.console.println("Name: " + Actor.values()[value].getName());
                this.console.println("Gender: " + Actor.values()[value].getGender());
                this.console.println("Type: " + Actor.values()[value].getType());
                this.console.println("Health: " + Actor.values()[value].getHealth());

                return false;
                }
        }

    }
