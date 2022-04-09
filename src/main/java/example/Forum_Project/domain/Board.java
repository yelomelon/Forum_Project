package example.Forum_Project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;
    private String content;
    private String writer;
    private int viewCnt = 0;

    private char noticeYn = 'N';
    private char secretYn = 'N';
    private char deleteYn = 'N';

    private LocalDateTime insertTime = LocalDateTime.now();
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
}
