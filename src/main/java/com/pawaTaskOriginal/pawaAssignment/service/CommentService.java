package com.pawaTaskOriginal.pawaAssignment.service;


import com.pawaTaskOriginal.pawaAssignment.models.Comment;
import com.pawaTaskOriginal.pawaAssignment.models.Tasks;

public interface CommentService {
    Comment update(Comment comment);

    Tasks save(Long taskId, Comment comment);

    void deleteById(Long id);
}