package com.saberspringcore.test.services.impl;

import com.saberspringcore.test.model.Song;
import com.saberspringcore.test.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

//    @Autowired
//    @Qualifier(value = "list")
    @Value("#{appConfig.list()}")
    private List<Song> songList;
    @Override
    public void printCollections() {
        System.out.println("*****************************************************************");
        songList.forEach(song -> System.out.println(song.getTitle()));
        System.out.println("*****************************************************************b");
    }
}
