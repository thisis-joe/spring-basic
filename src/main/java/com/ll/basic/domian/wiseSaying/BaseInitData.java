package com.ll.basic.domian.wiseSaying;

import com.ll.basic.domian.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final WiseSayingService wiseSayingService;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            wiseSayingService.write("명언1", "작가1");
            wiseSayingService.write("명언2", "작가2");
            wiseSayingService.write("명언3", "작가3");
        };
    }
}