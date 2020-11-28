package site.crafsed.sarafan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.crafsed.sarafan.domain.Comment;
import site.crafsed.sarafan.domain.Message;
import site.crafsed.sarafan.domain.User;
import site.crafsed.sarafan.domain.Views;
import site.crafsed.sarafan.dto.EventType;
import site.crafsed.sarafan.dto.ObjectType;
import site.crafsed.sarafan.repo.CommentRepo;
import site.crafsed.sarafan.util.WsSender;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user){
        comment.setAuthor(user);

        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return comment;
    }
}
