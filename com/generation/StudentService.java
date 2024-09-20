package com.generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.generation.exeptions.CourseNotFoundException;
import com.generation.exeptions.StudentNotFoundException;

public class StudentService {
	HashMap<String, Course> courseList = new HashMap<>();

	HashMap<String, Student> students = new HashMap<>();

	HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();

	public StudentService() {
		courseList.put("Math", new Course("Math", 10, "Aurelio Baldor"));
		courseList.put("Physics", new Course("Physics", 10, "Albert Einstein"));
		courseList.put("Art", new Course("Art", 10, "Pablo Picasso"));
		courseList.put("History", new Course("History", 10, "Sima Qian"));
		courseList.put("Biology", new Course("Biology", 10, "Charles Darwin"));
	}

	

	public void enrollStudents(String courseName, String studentID) throws CourseNotFoundException, StudentNotFoundException {
		Course course = courseList.get(courseName);

		if (courseList.containsKey(courseName) == true && students.containsKey(studentID)) {
			if (!coursesEnrolledByStudents.containsKey(studentID)) {
				coursesEnrolledByStudents.put(studentID, new ArrayList<>());
			}
			coursesEnrolledByStudents.get(studentID).add(course);
		} else {
			if (courseList.containsKey(courseName) == false) {

				throw new CourseNotFoundException(courseName);
			} else {
				if (students.containsKey(courseName) == false) {
					throw new StudentNotFoundException(studentID);
				}
			}
		}
	}

	public void unEnrollStudents(String courseName, String studentID) {
		Course course = courseList.get(courseName);

		if (coursesEnrolledByStudents.containsKey(studentID)) {
			coursesEnrolledByStudents.get(studentID).remove(course);
		}
	}

	public void showEnrolledStudents(String courseId) {
		// TODO implement using collections loops
		System.out.println(coursesEnrolledByStudents);
	}

	public void showAllCourses() {
		// TODO implement using collections loops
		for(Course courses:courseList.values()) {
			System.out.println(courses);
		}
	}
	
	public void addStudents(Student student) {
		students.put(student.getId(), student);
		
	}

	public HashMap<String, Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(HashMap<String, Course> courseList) {
		this.courseList = courseList;
	}

	public HashMap<String, Student> getStudents() {
		return students;
	}

	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}

	public HashMap<String, List<Course>> getCoursesEnrolledByStudents() {
		return coursesEnrolledByStudents;
	}

	public void setCoursesEnrolledByStudents(HashMap<String, List<Course>> coursesEnrolledByStudents) {
		this.coursesEnrolledByStudents = coursesEnrolledByStudents;
	}



	
}