package com.mysite.sbb.question;

import com.mysite.sbb.category.Category;
import com.mysite.sbb.comment.Comment;
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @ManyToOne
    private Category category;

    private Long viewCount = 0L;
}