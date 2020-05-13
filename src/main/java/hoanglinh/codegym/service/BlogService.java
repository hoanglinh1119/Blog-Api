package hoanglinh.codegym.service;
import hoanglinh.codegym.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService{
    List<Blog> findAll();
    List<Blog> findByTitle(String title);
    void save(Blog blog);
    Blog findById(Long id);
    List<Blog> findByTime(String time);
    List<Blog> findByAuthor(String author);
    void delete(Long id);

}
