package com.hexaware.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.app.Entity.Student;
import com.hexaware.app.Service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studSer;
	
	
//	@PostMapping("/saveStudent")
//	Student saveStudent(@Valid @RequestBody Student s)
//	{
//		Student s2=studSer.saveSt(s);
//		return s2;
//		
//	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student s) {
		Student s2=studSer.saveSt(s);
		if(s2== null) {
			return new ResponseEntity<>(s2,HttpStatus.NOT_FOUND);	
			}
		else {
			return new ResponseEntity<>(s2,HttpStatus.CREATED);
		}
		
		
	}
 
	
//	@GetMapping("/getStudent")
//	public List <Student> getStudents()
//	{
//		List <Student>users = studSer.getStuds();
//		return users;
//	}
	

	
	// LENGHT ==0 -- NO CONTENT -- DIDNT PERFORM THIS 
	
	@GetMapping("/getStudent/{rn}")
    public ResponseEntity<Student> getStudentById(@PathVariable int rn) {
        try {
            Student s2 = studSer.findByRollNo(rn);
 
            return new ResponseEntity<>(s2, HttpStatus.OK);
 
        } catch (RuntimeException e) {
 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}}
	
	/*@DeleteMapping("removeStud/{rno}")
	public Student removeStud (@PathVariable int rno) throws Exception 
	{
		Student s= studSer.removeSd(rno);
		return s;
	}*/
	
	
	@DeleteMapping("/removeStudent/{rno}")
	public ResponseEntity<Student> removeStud(@PathVariable int rno) {
	    try {
	        Student s = studSer.removeSd(rno);
	        return new ResponseEntity<>(s, HttpStatus.OK);
	    } catch (Exception e) {
	        // Return a 404 status code with the exception message
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	/*@PutMapping("updateName/{rn}/{nm}")
	public String updateName ( @PathVariable String nm, @PathVariable int rn) 
	{
		String r = studSer.updateNM(nm,rn);
		return r;
	}*/
	@PutMapping("/updateStudent/{rn}/{nm}")
	public ResponseEntity<String> updateName(@PathVariable int rn, @PathVariable String nm) {
	    try {
	        // Call the service to update the student's name
	        String result = studSer.updateNM(nm, rn);

	        // Check if the result indicates success or failure
	        if ("Success".equals(result)) {
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        }
	    } catch (RuntimeException e) {
	        // Handle any exceptions that occur during the process
	        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/find/{name}")
    public List<Student> findByNameContaining(@PathVariable String name) {
        return studSer.findByNameContaining(name);
    }

	
//	@GetMapping("/findByRollNo/{rn}")
//	public Object findByRollNo(@PathVariable int rn) {
//	    Student student = studSer.findByRollNo(rn);
//	    if (student != null) {
//	        return student;
//	    } else {
//	        return "Student not found"; 
//	    }
	

	}