package com.example.codeclan.MoreRelationships.controller;

import com.example.codeclan.MoreRelationships.models.File;
import com.example.codeclan.MoreRelationships.repository.FileRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

    //put update method
    @PutMapping(value = "/files/{id}")
    public ResponseEntity putFile(@PathVariable Long id, @RequestBody File fileDetails){
       Optional<File> file = fileRepository.findById(id);
       file.get().setExtension(fileDetails.getExtension());
       file.get().setFolder(fileDetails.getFolder());
       file.get().setName(fileDetails.getName());
       file.get().setSize(fileDetails.getSize());
       final File updatedFile = fileRepository.save(file.get());
       return new ResponseEntity<>(updatedFile, HttpStatus.ACCEPTED);

    }

    //delete method
    @DeleteMapping(value = "/files/{id}")
    public ResponseEntity deleteFile(@PathVariable Long id){
        fileRepository.deleteById(id);
        return new ResponseEntity(fileRepository.findAll(), HttpStatus.OK);
    }

}
