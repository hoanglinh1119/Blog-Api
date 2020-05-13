package hoanglinh.codegym.service.impl;




import hoanglinh.codegym.model.Blog;
import hoanglinh.codegym.repositories.BlogRepository;
import hoanglinh.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return blogRepository.findAllByTitleContaining(title);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public List<Blog> findByTime(String time) {
        return blogRepository.findAllByTitleContaining(time);
    }

    @Override
    public List<Blog> findByAuthor(String author) {
        return blogRepository.findAllByAuthorContaining(author);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
