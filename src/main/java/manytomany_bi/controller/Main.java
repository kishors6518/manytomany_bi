package manytomany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_bi.dto.Course;
import manytomany_bi.dto.Student;

public class Main {

	public static void main(String[] args) {
		Course c1=new Course();
		c1.setName("SQL");
		c1.setFees(8000);
		c1.setDuration(1.5);
		
		Course c2=new Course();
		c2.setName("Java");
		c2.setFees(15000);
		c2.setDuration(5);
		
		Course c3=new Course();
		c3.setName("Manual");
		c3.setFees(12000);
		c3.setDuration(1.5);
		
		Course c4=new Course();
		c4.setName("J2EE");
		c4.setFees(18000);
		c4.setDuration(2.5);
		
		Student s1=new Student();
		s1.setName("Piyush");
		s1.setPhone(9874566547l);
		s1.setAddress("Rajguru Nagar");
		List<Course>list1=new ArrayList<Course>();
		list1.add(c1);
		list1.add(c2);
		list1.add(c4);
		s1.setCourse(list1);
		
		Student s2=new Student();
		s2.setName("Aditya");
		s2.setPhone(9874456589l);
		s2.setAddress("Satara");
		List<Course>list2=new ArrayList<Course>();
		list2.add(c1);
		list2.add(c2);
		list2.add(c3);
		s2.setCourse(list1);
		
		Student s3=new Student();
		s3.setName("Sujit");
		s3.setPhone(7896544564l);
		s3.setAddress("Latur");
		List<Course>list3=new ArrayList<Course>();
		list3.add(c1);
		list3.add(c2);
		list3.add(c3);
		list3.add(c4);
		s3.setCourse(list1);
		
		List<Student>clist1=new ArrayList<Student>();
		clist1.add(s1);
		clist1.add(s2);
		clist1.add(s3);
		c1.setStudent(clist1);
		
		List<Student>clist2=new ArrayList<Student>();
		clist2.add(s1);
		clist2.add(s2);
		clist2.add(s3);
		c2.setStudent(clist1);
		
		List<Student>clist3=new ArrayList<Student>();
		clist3.add(s2);
		clist3.add(s3);
		c3.setStudent(clist1);
		
		List<Student>clist4=new ArrayList<Student>();
		clist4.add(s1);
		clist4.add(s3);
		c4.setStudent(clist1);
		
		
		EntityManager manager=Persistence.createEntityManagerFactory("kishor").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(c3);
		manager.persist(c4);
		manager.persist(s1);
		manager.persist(s2);
		manager.persist(s3);
		transaction.commit();
	}

}
