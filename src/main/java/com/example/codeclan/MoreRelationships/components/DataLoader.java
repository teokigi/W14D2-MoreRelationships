package com.example.codeclan.MoreRelationships.components;

import com.example.codeclan.MoreRelationships.models.File;
import com.example.codeclan.MoreRelationships.models.Folder;
import com.example.codeclan.MoreRelationships.models.User;
import com.example.codeclan.MoreRelationships.repository.FileRepository;
import com.example.codeclan.MoreRelationships.repository.FolderRepository;
import com.example.codeclan.MoreRelationships.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User user1 = new User("Jimbo Johnson");
        userRepository.save(user1);
        Folder folder1 = new Folder("music Folder",user1);
        folderRepository.save(folder1);
        File file1 = new File("Song1","mp4",4.35,folder1);
    }
}
