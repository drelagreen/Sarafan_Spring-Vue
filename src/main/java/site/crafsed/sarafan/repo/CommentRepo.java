package site.crafsed.sarafan.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.crafsed.sarafan.domain.Comment;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @EntityGraph(attributePaths = {"comments"})
    List<Comment> findAll();    //todo Что-то не так с репозиторием, я изменил возвращаемое значение непонятно где

}
