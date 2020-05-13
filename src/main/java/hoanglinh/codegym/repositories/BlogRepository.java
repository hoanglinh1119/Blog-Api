package hoanglinh.codegym.repositories;


import hoanglinh.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends CrudRepository<Blog,Long> {
    List<Blog> findAllByTitleContaining(String title);
    List<Blog> findAllByAuthorContaining(String author);
}
