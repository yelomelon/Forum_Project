package example.Forum_Project;

import example.Forum_Project.repository.*;
import example.Forum_Project.service.MemberService;
import example.Forum_Project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

/*    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, BoardRepository boardRepository) {
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
