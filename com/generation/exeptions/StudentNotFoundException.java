package com.generation.exeptions;

public class StudentNotFoundException extends Exception
{

    public StudentNotFoundException( String message)
    {
        super( "Student not found!" + message);
    }
}