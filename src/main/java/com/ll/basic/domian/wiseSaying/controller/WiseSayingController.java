package com.ll.basic.domian.wiseSaying.controller;

import com.ll.basic.domian.wiseSaying.entity.WiseSaying;
import com.ll.basic.domian.wiseSaying.service.WiseSayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WiseSayingController {
    private WiseSayingService wiseSayingService;

    @Autowired
    public WiseSayingController(WiseSayingService wiseSayingService) {
        this.wiseSayingService = wiseSayingService;
    }


    @GetMapping("/wiseSayings")
    public List<WiseSaying> getWiseSayings(){
        return wiseSayingService.getAllItems();
    }

    @GetMapping("/wiseSaying/write")
    public WiseSaying writeWiseSaying() {
        return wiseSayingService.write("명언1", "작가1");
    }

    @GetMapping("/wiseSayings/{id}/delete")
    public boolean deleteItem(@PathVariable int id) {
        return wiseSayingService.deleteById(id);
    }

    @GetMapping("/wiseSayings/{id}/modify")
    public WiseSaying modifyItem(@PathVariable int id, String content, String author) {
        return wiseSayingService.modify(id, content, author);
    }


}
