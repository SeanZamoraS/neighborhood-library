package com.pluralsight;

public class Book
{
    private int id; //final
    private String isbn; //final
    private String title; //final
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(final int ID, final String ISBN, final String TITLE)
    {
        this.id = ID;
        this.isbn = ISBN;
        this.title = TITLE;
        boolean isCheckedOut = false;
        String checkedOutTo = "This book is not checked out yet.";
    }

    public Book (final String ISBN, final String TITLE)
    {
        this.isbn = ISBN;
        this.title = TITLE;
        boolean isCheckedOut = false;
        String checkedOutTo = "This book is not checked out yet.";
    }

    public Book()
    {
        boolean isCheckedOut = false;
        String checkedOutTo = "This book is not checked out yet.";
    }

    //setters:

    public void setID(int id)
    {
        this.id = id;
    }

    public void setCheckOutStatus(boolean desiredStatus)
    {
        this.isCheckedOut = desiredStatus;
    }

    public void setCheckedOutTo(String name)
    {
        this.checkedOutTo = name;
    }

    //getters:

    public int getID()
    {
        return id;
    }
    public String getISBN()
    {
        return isbn;
    }
    public String getTitle()
    {
        return title;
    }
    public boolean getCheckOutStatus()
    {
        return isCheckedOut;
    }
    public String getWhoCheckedOut()
    {
        return checkedOutTo;
    }
}
