package com.exam.examserver.repo;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory(Category category);
    public List<Quiz> findByActive(Boolean b);
    public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
