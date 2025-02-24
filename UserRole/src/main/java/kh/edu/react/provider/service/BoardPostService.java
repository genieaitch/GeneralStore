package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.BoardPost;

import java.util.List;

public interface BoardPostService {

    List<BoardPost> getAllPosts();
    BoardPost getPostById(int postId);
    List<BoardPost> searchPosts(String keyword);
    void insertPost(BoardPost boardPost);
    void updatePost(BoardPost boardPost);
    void deletePost(int postId);
}
