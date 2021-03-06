package de.dwagner.test;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private Price price;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }
    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg){
            case Movie.REGULAR: price = new RegularPrice(); break;
            case Movie.CHILDRENS: price = new ChildrensPrice(); break;
            case Movie.NEW_RELEASE: price = new NewPrice(); break;
            default: throw new IllegalArgumentException("Incorrect de.dwagner.test.Price Code");
        }
    }

    public String getTitle (){
        return title;
    }

    public double getCharge(int daysRented){
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented){
        return price.getFrequentRenterPoints(daysRented);
    }
}