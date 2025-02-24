package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.BoardPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardPostMapper {
    List<BoardPost> getAllPosts();
    BoardPost getPostById(int postId);
    List<BoardPost> searchPosts(@Param("keyword") String keyword);
    void insertPost(BoardPost boardPost);
    void updatePost(BoardPost boardPost);
    void deletePost(int postId);
}