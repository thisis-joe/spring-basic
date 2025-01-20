package com.ll.basic.domian.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@ResponseBody // 클래스단에 달면 메서드마다 안달아도된다
public class HomeController {
    int age = 0;
    @GetMapping
    @ResponseBody
    public String home(){
        return "hello";
    }
    @GetMapping("/introduce")
    @ResponseBody
    public String introduce(){
        return "헬로우";
    }

    @GetMapping("/ageUp")
    @ResponseBody
    public int ageUp(){
        age++;
        return age;
    }

    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 1;
    }

    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 1;
    }

    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 1;
    }

    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.14;
    }

    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '안';
    }

    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/array")
    @ResponseBody
    public String[] getArray() {
        return new String[] {"a", "b", "c"};
    }

    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("k1", "v1", "k2", "v2");
    }
    @GetMapping("/article")
    @ResponseBody
    public Article getArticle() {
        return Article.builder()
                .body("내용")
                .title("제목")
                .isDeleted(false)
                .build();
    }

    @GetMapping("/mapList")
    public List<Map<String, String>> getMapList() {

        return List.of(
                Map.of("k1", "v1", "k2", "v2"),
                Map.of("k1", "v3", "k2", "v4")
        );
    }

    @GetMapping("/articleList")
    public List<Article> getArticleList() {
        return List.of(
                Article.builder().title("제목1").body("내용1").isDeleted(false).build(),
                Article.builder().title("제목2").body("내용2").isDeleted(false).build()
        );
    }

    @GetMapping("/articleList.html")
    public String getArticleListHtml() {
        Article a1 = Article.builder().title("aaaa").body("내용1").isDeleted(false).build();
        Article a2 = Article.builder().title("bbbb").body("내용2").isDeleted(false).build();

        List<Article> articleList = List.of(a1, a2);

        String lis = articleList.stream()
                .map(a -> "<li>%s</li>".formatted(a.getTitle()))
                .collect(Collectors.joining());

        return "<ul>" + lis + "</ul>"; // 자바에서 하지 않고, html에서 하려고 template(자바로 작동하는 html)
    }

}


@Getter
@Builder
class Article {

    @Builder.Default
    private int id = 1;
    private String title;
    private String body;
    private boolean isDeleted;
}