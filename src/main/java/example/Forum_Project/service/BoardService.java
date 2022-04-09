package example.Forum_Project.service;

import example.Forum_Project.domain.Board;
import example.Forum_Project.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시글 등록
     */
    public Long save(Board board) {
        boardRepository.save(board);
        return board.getIdx();
    }

    /**
     * 게시글 조회
     */
    public List<Board> findPosts() { return boardRepository.findAll(); }

    public Optional<Board> findOne(Long postIdx) {
        return boardRepository.findById(postIdx);
    }

    public List<Board> findTitleContains(String title) { return boardRepository.findByTitleContainsIgnoreCase(title); }
    public List<Board> findTitleContainsOrContentContains(String title, String content) { return boardRepository.findByTitleContainsOrContentContainsAllIgnoreCase(title, content); }
    public List<Board> findContentContains(String content) { return boardRepository.findByContentContainsIgnoreCase(content); }
    public List<Board> findWriter(String writer) { return boardRepository.findByWriterIgnoreCase(writer); }

    /**
     * 게시글 삭제
     */
    public Optional<Board> deletePost(Board board) {

        return null;
    }
}
