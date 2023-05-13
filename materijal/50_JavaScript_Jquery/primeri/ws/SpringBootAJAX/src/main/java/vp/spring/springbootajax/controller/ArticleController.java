package vp.spring.springbootajax.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.springbootajax.model.Article;
import vp.spring.springbootajax.service.ArticleService;

@RestController
public class ArticleController {
	
	@Autowired
	ArticleService articleService; 

	// metoda ce biti pozvana kada se uputi GET zahtev na articles
	@RequestMapping(value="articles", method = RequestMethod.GET) 
	public ResponseEntity<String> getAllArticlesHTML() {
		List<Article> articles = articleService.findAll();
		StringBuilder sb = new StringBuilder();
		for (Iterator<Article> iterator = articles.iterator(); iterator.hasNext();) {
			Article article = (Article) iterator.next();
			sb.append("<div>");
			sb.append("<h2>"+article.getTitle()+"</h2>");
			sb.append("<h3>"+article.getDescription()+"</h3>");
			sb.append("<p>"+article.getText()+"</p>");
			sb.append("</div>");
		}
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}

	
	// metoda ce biti pozvana kada se uputi GET zahtev na api/articles
	@RequestMapping(value="api/articles", method = RequestMethod.GET) 
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> articles = articleService.findAll();
					
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}
	
	// metoda ce biti pozvana kada se uputi GET zahtev na api/articles/<title>
	@RequestMapping(value="api/articles/{title}", method = RequestMethod.GET) 
	public ResponseEntity<Article> getAllArticle(@PathVariable String title) {
		Article article = articleService.findByTitleContaining(title);
					
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/articles/{title}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable String title) {
		boolean deleted = articleService.delete(title);
		if(deleted){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/articles", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity add(@RequestBody Article article) {
		System.out.println(article);
		articleService.save(article);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
	
}
