package com.ll.basic.domian.wiseSaying.service;

import com.ll.basic.domian.wiseSaying.entity.WiseSaying;
import com.ll.basic.domian.wiseSaying.repository.WiseSayingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WiseSayingService {
    @Autowired
    private WiseSayingRepository wiseSayingRepository;

    private int lastId = 0;
    private List<WiseSaying> wiseSayingList;

    /*
    public WiseSayingService() {
        this.wiseSayingList = new ArrayList<>();
        this.lastId = 0;

        WiseSaying w1 = WiseSaying.builder()
                .id(++lastId)
                .content("삶이 있는 한 희망은 있다.2")
                .author("키케로")
                .build();

        WiseSaying w2 = WiseSaying.builder()
                .id(++lastId)
                .content("나의 죽음을 알리지 마라.2")
                .author("이순신")
                .build();

        wiseSayingList.add(w1);
        wiseSayingList.add(w2);
    }
    */
    public Optional<WiseSaying> getItem(int id) {
        return wiseSayingRepository.findById(id);
    }
    public List<WiseSaying> getAllItems(){
        return wiseSayingRepository.findAll();
    }
    public WiseSaying write(String content, String author){
        WiseSaying wiseSaying = WiseSaying.builder()
                                            .content(content)
                                            .author(author)
                                            .build();
        return wiseSayingRepository.save(wiseSaying);
    }

    public boolean deleteById(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public WiseSaying modify(int id, String content, String author) {

        Optional<WiseSaying> opWiseSaying = getItem(id);

        if(opWiseSaying.isEmpty()) {
            throw new IllegalArgumentException("해당 id의 명언이 없습니다.");
        }

        WiseSaying wiseSaying = opWiseSaying.get();
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        return wiseSaying;
    }
}
