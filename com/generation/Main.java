package com.generation;

import com.generation.exeptions.CourseNotFoundException;
import com.generation.exeptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) throws CourseNotFoundException, StudentNotFoundException {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
        //studentService.students.put( "1030", new Student( "Carlos", "1030", 31 ) );
        //studentService.students.put( "1040", new Student( "Ian", "1020", 28 ) );
        //studentService.students.put( "1050", new Student( "Elise", "1020", 26 ) );
        //studentService.students.put( "1020", new Student( "Santiago", "1020", 33 ) );
        
        studentService.addStudents(new Student( "Carlos", "1030", 31 ));
        studentService.addStudents(new Student( "Ian", "1020", 28 ));
        studentService.addStudents(new Student( "Elise", "1020", 26 ));
        studentService.addStudents(new Student( "Santiago", "1020", 33 ));
        
     /* courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );*/

       // studentService.enrollStudents( "Math", "1040" ); studentService.enrollStudents( "History", "1040" ); 
        
        
			try {
				studentService.enrollStudents( "Math", "1030" );
			} catch (StudentNotFoundException | CourseNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
       // studentService.enrollStudents( "Math", "1020" );
        
        
        studentService.showEnrolledStudents("Math");
        
        //Probamos el metodo unEnroll
        try {
        	studentService.unEnrollStudents( "Mat2h", "14050" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        studentService.showEnrolledStudents("Math");
        studentService.showAllCourses();
    }
}