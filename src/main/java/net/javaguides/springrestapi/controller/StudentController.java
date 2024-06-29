package net.javaguides.springrestapi.controller;


import net.javaguides.springrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    //http://localhost:8080/student
//    @GetMapping("student")
//    public Student getStudent() {
//        Student student = new Student(
//                1,
//                "Sumit",
//                "Dhandar"
//        );
//        return student;
//    }
    //usingResponseEntity class
//    @GetMapping("student")
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Sumit",
                "Dhandar"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);  //same as below
        return ResponseEntity.ok().header("custom-header","Sumit").body(student);
    }
    //http://localhost:8080/students
//    @GetMapping("students")
//    public List<Student> getStudents() {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1, "Sumit", "Dhandar"));
//        students.add(new Student(2, "Aman", "Dhandar"));
//        students.add(new Student(3, "Ashok", "Dhandar"));
//        students.add(new Student(4, "Siddharth", "Dhandar"));
//        students.add(new Student(5, "Mala", "Dhandar"));
//        return students;
//    }

    //@GetMapping("students")
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sumit", "Dhandar"));
        students.add(new Student(2, "Aman", "Dhandar"));
        students.add(new Student(3, "Ashok", "Dhandar"));
        students.add(new Student(4, "Siddharth", "Dhandar"));
        students.add(new Student(5, "Mala", "Dhandar"));
        return ResponseEntity.ok(students);
    }

    //Spring Boot REST API with path variable
    //{id} - URI template variable
    //http://localhost:8080/students/1
//    @GetMapping("students/{id}")
//    public Student studentPathVariable(@PathVariable int id) {
//        return new Student(
//                id,
//                "Sumit",
//                "Dhandar"
//        );
//    }

//    @GetMapping("students/{id}")
@GetMapping("/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id) {
        Student student = new Student(
                id,
                "Sumit",
                "Dhandar"
        );
        return ResponseEntity.ok(student);
    }

    //http://localhost:8080/students/5/sammy/dhandar
//    @GetMapping("students/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable int id,
//                                       @PathVariable("first-name") String firstName,
//                                       @PathVariable("last-name") String lastName) {
//        return new Student(
//                id, firstName, lastName
//        );
//    }

//    @GetMapping("students/{id}/{first-name}/{last-name}")
@GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student= new Student(
                id, firstName, lastName
        );
        return ResponseEntity.ok(student);
    }


    //Spring Boot REST API with Query Param
    //http://localhost:8080/students/query?id=1
//    @GetMapping("students/query")
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id
    ) {
        Student student = new Student(
                id, "sumit", "Dhandar"
        );
        return ResponseEntity.ok(student);
    }

    //with multiple queries//http://localhost:8080/students/queries?id=1&firstname=sam&lastName=Dhandar
//    @GetMapping("students/queries")
//    public Student studentRequestParameters(@RequestParam int id,
//                                            @RequestParam String firstName,
//                                            @RequestParam String lastName) {
//        return new Student(
//                id, firstName, lastName
//        );
//    }

    //@GetMapping("students/queries")
    @GetMapping("/queries")
    public ResponseEntity<Student> studentRequestParameters(@RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
        Student student = new Student(
                id, firstName, lastName
        );
        return ResponseEntity.ok(student);
    }


    //HTTP post method
    //@PostMapping and @RequestBody
//    @PostMapping("/students/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student) {
//        System.out.println(student.getId());
//        System.out.println(student.getLastName());
//        System.out.println(student.getFirstName());
//
//        return student;
//    }

    //@PostMapping("/students/create")
    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getLastName());
        System.out.println(student.getFirstName());

        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //@PUT Mapping
//    @PutMapping("/students/{id}/update")
//    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
//        System.out.println(student.getLastName());
//        System.out.println(student.getFirstName());
//        return student;
//    }

//    @PutMapping("/students/{id}/update")
@PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getLastName());
        System.out.println(student.getFirstName());
        return ResponseEntity.ok(student);
    }

    //@Delete Mapping
//    @DeleteMapping("/students/{id}/delete")
//    public String deleteStudent(@PathVariable("id") int studentId){
//        return "Student deleted successfully!!";
//    }

//    @DeleteMapping("/students/{id}/delete")
@DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        return ResponseEntity.ok("Student deleted successfully!!");
    }
}





