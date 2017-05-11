package de.dwagner.test;

import java.util.*;

class Customer {
    private final String name;
    private final Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName (){
        return name;
    }

    public String statement() {

        Enumeration enum_rentals = rentals.elements();
        String result = "de.dwagner.test.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";


        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            // add frequent renter points
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;

    }

    private int getTotalFrequentRenterPoints(){
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;


    }
}
    