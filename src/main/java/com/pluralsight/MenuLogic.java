package com.pluralsight;

import java.util.Scanner;

public class MenuLogic
{
    //hardcoded number of books
    static final int AMOUNT = 20;

    static Scanner input = new Scanner(System.in);

    static Book[] fullLibrary;


    public static void main(String[] args) throws InterruptedException {
        //setting up the array
        fullLibrary = createHardcodedBookArray();
        assignIDBookArray(AMOUNT, fullLibrary);

        //test:
        //for (int i = 0; i < fullLibrary.length; ++i)
        //{
            //System.out.println("\nID: " + fullLibrary[i].getID());
            //System.out.println("Title: " + fullLibrary[i].getTitle() + "\n");
        //}

        startMenu(false);


    }

    public static void startMenu(boolean ranOnce) throws InterruptedException {
        if(ranOnce == false)
        {
            System.out.println("Welcome to the neighborhood library!");
        }

        System.out.println("""
                What would you like to do?
                Please enter 1, 2, or 3.
                
                1) Check out a book/see available books
                2) Return a book/see checked out books
                3) Close program \n""");

        String userSelection = input.nextLine();

        switch(userSelection)
        {
            case "1":
                checkOutMenu();
                break;

            case "2":
                checkInMenu();
                break;

            case "3":
                System.out.println("Thank you for using the neighborhood library. Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("\u001B[1mPlease make a valid selection.\u001B");
                startMenu(true);
                break;
        }
    }

    public static void checkOutMenu() throws InterruptedException {
        //you might be able to make comment below a class method createCheckOutArray()?
        //find number of books available and create array to hold
        int numberAvailable = 0;
        for(int i = 0; i < fullLibrary.length; i++)
        {
            if (fullLibrary[i].getCheckOutStatus() == false)
            {
                ++numberAvailable;
            }
        }
        Book[] availableBooks = new Book[numberAvailable];
        System.out.println(availableBooks.length);

        for(int count = 0; count < fullLibrary.length; count++)
        {
            if (fullLibrary[count].getCheckOutStatus() == false)
            {
                availableBooks[count] = fullLibrary[count];
            }
        }
        System.out.println("Getting our list of available books... \n");
        Thread.sleep(2000);
        for (int i = 0; i < availableBooks.length; ++i)
        {
            Thread.sleep(800);
            System.out.println("\nID: " + availableBooks[i].getID());
            System.out.println("ISBN: " + availableBooks[i].getISBN());
            System.out.println("Title: " + availableBooks[i].getTitle() + "\n");
        }
        System.out.println("""
                What would you like to do?
                Please enter 1 or 2.
                
                1) Check out a book from the list
                2) Return to main menu \n""");

        String userSelection = input.nextLine();

        switch(userSelection)
        {
            case "1":
                System.out.println("What is the ID number of the book you would like to checkout?");
                int bookID = receiveValidInteger();

                for(int i = 0; i < availableBooks.length; i++)
                {
                    if (availableBooks[i].getID() == bookID)
                    {
                        System.out.println("Checking out " + availableBooks[i].getTitle() + ".\n");
                        System.out.println("Please enter your name: \n");
                        String name = input.nextLine();
                        availableBooks[i].setCheckedOutTo(name);
                        availableBooks[i].setCheckOutStatus(true);


                        System.out.println("""
                                Please enter either 1 or 2.
                                
                                1) Check out another book
                                2) Return to the main menu""");

                        String userMenu = input.nextLine();
                        switch (userMenu)
                        {
                            case "1":
                                checkOutMenu();
                            case "2":
                                startMenu(true);
                        }

                    }
                }
            case "2":
            {
                startMenu(true);
            }
            default:
            {
                System.out.println("Please make a valid selection.");
                checkOutMenu();
            }
        }

    }

    public static int receiveValidInteger() //re-used/added on from theater reservations
    {
        while (true)
        {
            try
            {
                int bookID = input.nextInt();
                if (bookID >= 1 && bookID <= AMOUNT) {return bookID;}
                else
                {
                    System.out.println("Please check the book ID and try again:\n");
                    input.nextLine();
                }
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid ID (numbers only):\n");
                input.nextLine();
            }
        }
    }

    public static void checkInMenu()
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