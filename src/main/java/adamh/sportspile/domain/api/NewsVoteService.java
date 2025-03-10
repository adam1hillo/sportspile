package adamh.sportspile.domain.api;

import adamh.sportspile.domain.dto.NewsVote;
import adamh.sportspile.domain.user.User;
import adamh.sportspile.domain.user.UserDao;
import adamh.sportspile.domain.vote.Vote;
import adamh.sportspile.domain.vote.VoteDao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class NewsVoteService {

    private final UserDao userDao = new UserDao();
    private final VoteDao voteDao = new VoteDao();
    public void addVote(NewsVote newsVote) {
        int userId = userDao.findByUsername(newsVote.getUsername())
                .orElseThrow()
                .getId();
        Vote vote = NewsVoteMapper.map(newsVote, userId);
        voteDao.save(vote);
    }

    private static class NewsVoteMapper {
        static Vote map (NewsVote newsVote, int userId) {
            return new Vote(
                    userId,
                    newsVote.getNewsId(),
                    Vote.Type.valueOf(newsVote.getType()),
                    LocalDateTime.now()
            );
        }
    }
}
