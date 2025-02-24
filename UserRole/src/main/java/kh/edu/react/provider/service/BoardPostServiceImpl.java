package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.BoardPost;
import kh.edu.react.provider.mapper.BoardPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardPostServiceImpl implements BoardPostService {
    @Autowired
    private BoardPostMapper boardPostMapper;

    @Override
    public List<BoardPost> getAllPosts() {
        return boardPostMapper.getAllPosts();
    }

    @Override
    public BoardPost getPostById(int postId) {
        return boardPostMapper.getPostById(postId);
    }

    /**
     * -parameters' flag.\r\n\tat org.springframework.web.method.annotation.
     * keyword 라는 변수이름이 sql 문까지 제대로 전달 되지 않을 때 발생
     * -> maven 기준으로 pom.xml 에 String 관련 설정 진행하거나
     * gradle 기준으로 build.gradle 에 string 관련 설정 진행
     * mapper.java 내부에 String keyword 앞에 @Param("keyword") 설정을 진행해주거나
     * keyword 라는 명칭이 제대로 전달되고 있는지 확인
     * @param keyword
     * @return
     */
    @Override
    public List<BoardPost> searchPosts(String keyword) {
        return boardPostMapper.searchPosts(keyword);
    }

    @Override
    public void insertPost(BoardPost boardPost) {
        boardPostMapper.insertPost(boardPost);
    }

    @Override
    public void updatePost(BoardPost boardPost) {
        boardPostMapper.updatePost(boardPost);
    }

    @Override
    public void deletePost(int postId) {
        boardPostMapper.deletePost(postId);
    }
}
