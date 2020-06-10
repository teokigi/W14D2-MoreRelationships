package com.example.codeclan.MoreRelationships.controller;

import com.example.codeclan.MoreRelationships.models.Folder;
import com.example.codeclan.MoreRelationships.repository.FolderRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity(folderRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity postFile(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity(folder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/folders/{id}")
    public ResponseEntity putFile(@PathVariable Long id, @RequestBody Folder folderDetails){
        Optional<Folder> folder = folderRepository.findById(id);
        folder.get().setFiles(folderDetails.getFiles());
        folder.get().setTitle(folderDetails.getTitle());
        folder.get().setUser(folderDetails.getUser());
        final Folder updatedFolder = folderRepository.save(folder.get());
        return new ResponseEntity<>(updatedFolder,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/folders/{id}")
    public ResponseEntity deleteFolder(@PathVariable Long id){
        folderRepository.deleteById(id);
        return new ResponseEntity(folderRepository.findAll(),HttpStatus.ACCEPTED);
    }
}
