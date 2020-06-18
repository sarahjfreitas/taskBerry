package app.comment;

import app.AppTranslator;
import app.issue.IssueDao;
import app.user.UserDao;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CommentTranslator extends AppTranslator {
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
        comment.setCreatedBy(UserDao.find(from.createdBy));
        comment.setIssue(IssueDao.find(from.issueId));

        return comment;
    }
}