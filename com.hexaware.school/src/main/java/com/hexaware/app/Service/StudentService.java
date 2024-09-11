package com.hexaware.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.app.Dao.RepStudent;
import com.hexaware.app.Entity.Student;

@Service
public class StudentService {
	@Autowired
	RepStudent RepSt;
	
public Student  saveSt(Student s)
	
	{
		Student s2=RepSt.save(s);
		return s2;
	}

public List<Student> getStuds() {
	List <Student>l=(List)RepSt.findAll();
	return l;
}

/*public Student removeSd(int rno) {
	Student s = RepSt.findById(rno).orElse(null);
	//Student s= RepSt.findById(10).orElseThrow(()-> new Exception("not found"+ rno));
	if (s==null)
	{
		return null;
	}
	else
	{
		RepSt.delete(s);
	}
	return s;
}*/


public Student removeSd(int roll) throws Exception {
    Student s = RepSt.findById(roll)
                    .orElseThrow(() -> new Exception("Student not found with roll number: " + roll));
    RepSt.delete(s);
    return s;
}

public String updateNM(String nm, int rn) {
	Student s = RepSt.findById(rn).orElse(null);
	if(s==null) 
	{
		return "not found";
	}
	else
	{
		s.setName(nm);
		RepSt.save(s);
		return "Name updated";
	}
}

public Student findByRollNo(int rn) {
	return RepSt.findById(rn).orElse(null);
}

public List<Student> findByNameContaining(String name) {
    return RepSt.findByNameContaining(name);
}

}
