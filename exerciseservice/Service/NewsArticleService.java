package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle> newsArticles=new ArrayList<>();

    public ArrayList<NewsArticle> getNewsArticles(){
        return newsArticles;
    }

    public boolean addNewsArticles(NewsArticle newsArticle){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId().equalsIgnoreCase(newsArticle.getId())){
                return false;
            }
        }
        newsArticles.add(newsArticle);
        return true;
    }

    public boolean updateNewsArticles(String id,NewsArticle newsArticle){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId().equals(id)){
                newsArticles.set(i,newsArticle);
                return true;
            }
        }
        return false;}


    public boolean deleteNewsArticales(String id){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId().equals(id)){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }

public boolean PublishNews( NewsArticle newsArticle){
        for(int i=0;i<publishNews.size();i++) {
            if (publishNews.get(i).isPublished() && publishNews.get(i).getId().equals(newsArticle.getId())) {
                publishNews.get(i).setPublished(true);
                publishNews.add(newsArticle);
                return true;
            }
        }

    return false; }

      public ArrayList<NewsArticle> getNewsIsPublish() {
        return publishNews;
    }

public ArrayList<NewsArticle> GetByCategory(String category){
        ArrayList<NewsArticle>NewsByCategory=new ArrayList<>();
        for(NewsArticle n:newsArticles){
            if(n.getCategory().equalsIgnoreCase(category)){
NewsByCategory.add(n);
            }
        }
        return NewsByCategory;
}

}
