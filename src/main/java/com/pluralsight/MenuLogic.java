package com.pluralsight;

import java.util.Scanner;

public class MenuLogic
{
    public static void main(String[] args)
    {
        Book [] libraryBooks = createBookArray(20);
        //test:
        //System.out.println(libraryBooks[19].getID());
    }
    public static Book[] createBookArray(int amount)
    {
        Book[] libraryBooks = new Book[amount];

        for(int i = 0; i < amount; i++)
        {
            libraryBooks[i] = new Book();
            libraryBooks[i].setID(i + 1);
        }

        return libraryBooks;
    }
}