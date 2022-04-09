package example.Forum_Project.controller;

import example.Forum_Project.domain.Board;
import example.Forum_Project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/newPost")
    public String postForm() { return "board/newPost"; }

    @PostMapping("/newPost")
    public String post(BoardForm form) {
        Board board = new Board();

        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        board.setWriter(form.getWriter());

        boardService.save(board);

        return "redirect:/";
    }

}
