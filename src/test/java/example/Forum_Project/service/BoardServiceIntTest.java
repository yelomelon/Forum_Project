package example.Forum_Project.service;

import example.Forum_Project.domain.Board;
import example.Forum_Project.repository.BoardRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Transactional
public class BoardServiceIntTest {
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    private final Log LOG = LogFactory.getLog(this.getClass());
    @Test
    public void 글쓰기() {
        //given
        Board board = new Board();

        board.setTitle("게시글 제목");
        board.setContent("게시글 내용");
        board.setWriter("JJ");
        board.setViewCnt(0);
        board.setNoticeYn('N');
        board.setSecretYn('N');
        board.setDeleteYn('N');

        //when
        Long saveId = boardService.save(board);

        //then
        Board board1 = boardService.findOne(saveId).get();
        assertThat(board.getTitle()).isEqualTo(board1.getTitle());
        assertThat(board1.getContent()).isEqualTo("게시글 내용");
        assertThat(board1.getWriter()).isEqualTo("JJ");
    }

    @Test
    public void 제목검색() {
        //given
        Board board = new Board();

        board.setTitle("게시글 제목");
        board.setContent("게시글 내용");
        board.setWriter("JJ");
        board.setViewCnt(0);
        board.setNoticeYn('N');
        board.setSecretYn('N');
        board.setDeleteYn('N');

        //when
        Long saveId = boardService.save(board);

        //then
        List<Board> board1 = boardService.findTitleContains("게시글");

    }
}
