package vp.spring.springbootajax.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import vp.spring.springbootajax.model.Article;

@Component("articleRepository")
public class ArticleRepository {

	private List<Article> articles = new ArrayList<Article>();

	public List<Article> getArticles() {
		return articles;
	}
	
	public ArticleRepository(){
    	Article a = new Article();
    	a.setTitle("prvi clanak");
    	a.setDescription("primer clanka");
    	a.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pretium, sem sed sollicitudin hendrerit, velit massa euismod felis, vitae varius neque sem non ipsum. Etiam sit amet neque sollicitudin, ullamcorper velit et, porttitor arcu. Nunc et dapibus sapien. Fusce vel felis odio. Praesent tristique elit arcu, nec posuere est mattis nec.");
    	articles.add(a);

    	a = new Article();
    	a.setTitle("drugi clanak");
    	//a.setDescription("primer clanka");
    	a.setText("Morbi vulputate pulvinar tristique. Nam fringilla quis eros eu accumsan. Donec hendrerit purus a mollis dapibus. In bibendum tortor ac diam consectetur convallis. Fusce feugiat felis sed gravida suscipit. ");
    	articles.add(a);
	}
	
	public List<Article> findAll(){
		return articles;
	}
	
	//preuzimanje svih clanaka koji u naslovu sadrze zadati string
	public Article findByTitleContaining(String title){
		return articles.stream().filter(x -> x.getTitle().contains(title)).findFirst().get();
	}
	
	public boolean deleteByTitle(String title){
		for (Iterator<Article> iterator = articles.iterator(); iterator.hasNext();) {
			Article article = (Article) iterator.next();
			if(article.getTitle().equals(title)){
				articles.remove(article);
				return true;
			}
		}
		return false;
	}
	
	public void save(Article article){
		try{
			Article a = articles.stream().filter(x -> x.getTitle().equals(article.getTitle())).findFirst().get();
			a.setDescription(article.getDescription());
			a.setTitle(article.getTitle());
		}catch(NoSuchElementException e){
			articles.add(article);
		}
	}
}
