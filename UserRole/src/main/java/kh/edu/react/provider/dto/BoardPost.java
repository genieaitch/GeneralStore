package kh.edu.react.provider.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardPost {
    private int postId;
    private int userId;
    private String postTitle;
    private String postContent;
    private String thumbnail;
    private String postCategory;
    private int viewCount;
    private int likeCount;
    private String postStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
