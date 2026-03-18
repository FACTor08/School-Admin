package com.factor.school.Service;

import com.factor.school.Component.StudentsDataTransfer;
import com.factor.school.Model.DetailsDTO;
import com.factor.school.Model.Student_details;
import com.factor.school.Repository.StudentsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Details_Logic {
    @Autowired
    StudentsRepo repo;

    @Autowired
    private StudentsDataTransfer dt;

    public String enrollStudents(DetailsDTO details, MultipartFile photo) throws IOException {
        byte[] image = photo.getBytes();
        String imageType = photo.getContentType();
        Student_details student = dt.transfer(details, image, imageType);
        repo.save(student);
    return "Student" + details.getLastname() + details.getFirstname() + "has successfully been enrolled";
    }


    public List<Student_details> getAllStudents(){
      return repo.findAll();
    }

    public Optional<Student_details> findByMatricNo(String matric){
      return repo.findByMatricNoIgnoreCase(matric);
    }


    public boolean eraseStudentData(String matric){
        if(repo.existsByMatricNoIgnoreCase(matric)){
            repo.deleteByMatricNoIgnoreCase(matric);
            return  true;
        }
        else{
            return false;
        }
    }
}
