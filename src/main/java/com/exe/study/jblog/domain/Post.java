package com.exe.study.jblog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    // summernote를 적용하면 다량의 <html> 태그들이 포함된다.
    @Lob
    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    private Timestamp createDate;

    private int cnt;

    @ManyToOne(fetch = FetchType.EAGER) //post관점에서 회원과의 관계는 N : 1
    @JoinColumn(name = "userid")
    private User user;


}
