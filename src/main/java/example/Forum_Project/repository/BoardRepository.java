package example.Forum_Project.repository;

import example.Forum_Project.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    public int insertPost(PostDTO params);
//    public int updatePost(PostDTO params);
    @Override
    Board save(Board board);

//    public Optional<PostDTO> selectPostDetail(Long idx);
    Optional<Board> findById(Long idx);

//    public int deletePost(Long idx);
//    public List<PostDTO> selectPostList();
//    public int selectPostTotalCount();

    List<Board> findByTitleContainsIgnoreCase(String title);
    List<Board> findByTitleContainsOrContentContainsAllIgnoreCase(String title, String content);
    List<Board> findByContentContainsIgnoreCase(String content);
    List<Board> findByWriterIgnoreCase(String writer);

    List<Board> findAll();
}
