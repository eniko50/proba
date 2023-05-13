package vp.spring.springbootajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.springbootajax.data.ArticleRepository;
import vp.spring.springbootajax.model.Article;

@Component
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository; 

	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	public Article findByTitleContaining(String title){
		return articleRepository.findByTitleContaining(title);
	}
	
	public boolean delete(String title){
		return articleRepository.deleteByTitle(title);
	}
	
	public void save(Article article){
		articleRepository.save(article);
	}
}
