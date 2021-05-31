package com.project.blog;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Entity
@Table(name = "rb_comment")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    @Enumerated(EnumType.STRING)
    private CommentType type;
    @CreatedDate
    private Timestamp createdDate;
    @CreatedBy
    private String createdBy;
}
