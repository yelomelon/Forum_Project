package example.Forum_Project.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardForm {
    private String title;
    private String content;
    private String writer;
}
