package com.pluralsight;

import java.util.Scanner;

public class MenuLogic
{
    //hardcoded number of books
    static final int AMOUNT = 20;

    static Scanner input = new Scanner(System.in);

    static Book[] fullLibrary;


    public static void main(String[] args)
    {
        //setting up the array
        fullLibrary = createHardcodedBookArray();
        assignIDBookArray(AMOUNT, fullLibrary);

        //test:
        for (int i = 0; i < fullLibrary.length; ++i)
        {
            System.out.println("\nID: " + fullLibrary[i].getID());
            System.out.println("Title: " + fullLibrary[i].getTitle() + "\n");
        }


    }

    public static void startMenu()
    {

    }

    public static void assignIDBookArray(int amount, Book[] libraryBooks)
    //I have been informed it would have been quicker to use java.util.Collections, keeping here for fun
    {
        for(int i = 0; i < amount; i++)
        {
            //top line saves me from an exception if i forgot a book in hardcoded array, such as [3] last time
            if (libraryBooks[i] == null) {continue;}
            libraryBooks[i].setID(i + 1);
        }
    }

    public static Book[] createHardcodedBookArray()
    //Maybe in the future I could pull ISBN/Title from an API search and add an addBookFromAPI function
    //then also return a new amt of books for the createBookArray() OR alternative read ISBN/title from a .txt
    {
        Book[] libraryBooks = new Book[AMOUNT];

        libraryBooks[0] = new Book("111111111", "Cool and Real Book");
        libraryBooks[1] = new Book("222222222", "Totally Real Book");
        libraryBooks[2] = new Book("333333333", "Pink Gump");
        libraryBooks[3] = new Book("000000001", "THE FORGOTTEN");
        libraryBooks[4] = new Book("444444444", "The Dangers of Java");
        libraryBooks[5] = new Book("555555555", "The Safeties of Java");
        libraryBooks[6] = new Book("666666666", "Help! I spilled java on my Java");
        libraryBooks[7] = new Book("777777777", "Help! I spilled Java on my java");
        libraryBooks[8] = new Book("888888888", "Java with Joy");
        libraryBooks[9] = new Book("999999999", "Top 10 Java IDEs: for the coffee fan");
        libraryBooks[10] = new Book("121212121", "Top 10 java Beans: for the Java fan");
        libraryBooks[11] = new Book("232323232", "Don't Repeat Yourself!");
        libraryBooks[12] = new Book("343434343", "Don't Repeat Yourself!(2)");
        libraryBooks[13] = new Book("454545454", "libraryBooks[x] = new Book(ISBN, TITLE): A Task for a Time Waster");
        libraryBooks[14] = new Book("565656565", "The Progressive Programmer: The Case for Enums");
        libraryBooks[15] = new Book("676767676", "I Know for Sure: 67 Is Still Funny!");
        libraryBooks[16] = new Book("787878787", "The Conservative Programmer: The Case Against Enums");
        libraryBooks[17] = new Book("989898989", "Well Seymour, I made it despite your directions.");
        libraryBooks[18] = new Book("767676767", "Ahhhh superintendent Chalmers, welcome. I hope you're prepared for an unforgettable luncheon!");
        libraryBooks[19] = new Book("545454545", "The Last Book EVER!!");

        return libraryBooks;
    }

}