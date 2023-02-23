package com.exe.study.jblog.service;

import com.exe.study.jblog.domain.Post;
import com.exe.study.jblog.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 포스트 등록
    @Transactional
    public void insertPost(Post post){
        post.setCnt(0);
        postRepository.save(post);
    }

    // 포스트 목록조회
    public Page<Post> getPostList(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    // 포스트 수정

    // 포스트 상세조회
    public Post getPost(int id){
        return postRepository.findById(id).get();
    }

}
