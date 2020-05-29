package app.comment;

import app.project.Project;
import app.project.ProjectData;
import app.project.ProjectTranslator;
import app.user.UserDao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CommentTranslator {
    public static List<Comment> translate(List<CommentData> from) {
        List<Comment> comments = new ArrayList<Comment>();
        from.forEach(c -> comments.add(CommentTranslator.translate(c)));

        return comments;
    }

    public static Comment translate(CommentData from) {
        Comment comment = new Comment();
        comment.setCommentId(from.commentId);
        comment.setContent(from.content);
        comment.setCreatedIn(Instant.ofEpochSecond(from.createdIn));
        comment.setUpdatedIn(Instant.ofEpochSecond(from.updatedIn));
        comment.setCreatedBy(UserDao.find(from.createdBy));

        List<Comment> children = CommentDao.findChildren(from.commentId);
        comment.setChildren(children);

        return comment;
    }
}