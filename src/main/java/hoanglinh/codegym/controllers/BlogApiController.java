package hoanglinh.codegym.controllers;

import hoanglinh.codegym.model.Blog;
import hoanglinh.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class BlogApiController {
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/api/blogs",method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogs=blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }
    @RequestMapping(value = "/api/search-by-author",method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getAllByAuthor(@RequestParam String author){
        List<Blog> blogList=blogService.findByAuthor(author);
        if (blogList.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);

    }
    @RequestMapping(value = "/api/search-by-title",method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getAllByTitle(@RequestParam String title){
        List<Blog> blogList=blogService.findByTitle(title);
        if (blogList.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
    }
    @RequestMapping(value = "/api/blogs/{id}",method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id ){
       Blog blog=blogService.findById(id);
       if (blog==null){
           return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }
    @RequestMapping(value = "/api/blogs/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Blog> editBlog(@PathVariable("id") Long id, @RequestBody Blog blog){
        Blog editBlog=blogService.findById(id);
          if (editBlog==null){
               return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
          }
//          editBlog.setTime(blog.getTime());
          editBlog.setAuthor(blog.getAuthor());
          editBlog.setCategory(blog.getCategory());
          editBlog.setContent(blog.getContent());
          editBlog.setId(blog.getId());
          editBlog.setTitle(blog.getTitle());

          blogService.save(editBlog);
          return new ResponseEntity<Blog>(editBlog,HttpStatus.OK);

    }
    @RequestMapping(value = "/api/blogs/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") Long id){
        Blog deleteBlog=blogService.findById(id);
        if (deleteBlog==null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
