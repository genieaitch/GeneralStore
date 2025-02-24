package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.BoardPost;
import kh.edu.react.provider.service.BoardPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BoardPostController {
    @Autowired
    private BoardPostServiceImpl boardPostService;

    @GetMapping
    public List<BoardPost> getAllPosts() {
        return boardPostService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public BoardPost getPostById(@PathVariable int postId) {
        return boardPostService.getPostById(postId);
    }

    @GetMapping("/search")
    public List<BoardPost> searchPosts(@RequestParam String keyword) {
        return boardPostService.searchPosts(keyword);
    }

    @PostMapping
    public void insertPost(@RequestBody BoardPost boardPost) {
        boardPostService.insertPost(boardPost);
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable int postId, @RequestBody BoardPost boardPost) {
        boardPost.setPostId(postId);
        boardPostService.updatePost(boardPost);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable int postId) {
        boardPostService.deletePost(postId);
    }
}