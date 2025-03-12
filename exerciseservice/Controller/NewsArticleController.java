package com.example.exerciseservice.Controller;

import com.example.exerciseservice.Api.ApiResponse;
import com.example.exerciseservice.Model.NewsArticle;
import com.example.exerciseservice.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.AbstractPastInstantBasedValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/newsArticle")
@RequiredArgsConstructor
public class NewsArticleController {
    private final NewsArticleService NewArt;

    @GetMapping("/get")
    public ResponseEntity getAllNewsArticle() {
        ArrayList<NewsArticle> ArrayArticles = NewArt.getNewsArticles();
        return ResponseEntity.status(200).body(ArrayArticles);
    }

    @PostMapping("/add")
    public ResponseEntity addAllNewsArticle(@RequestBody @Valid NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isExist = NewArt.addNewsArticles(newsArticle);
        if (isExist) {
            return ResponseEntity.status(200).body(new ApiResponse("success"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User already exists"));
    }

    @PutMapping("/update/{id}")
public ResponseEntity updateAllNewsArticle(@PathVariable String id,@RequestBody @Valid NewsArticle newsArticle,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isExist=NewArt.updateNewsArticles(id,newsArticle);
        if(isExist){
        return ResponseEntity.status(200).body(new ApiResponse("success"));
}
    return ResponseEntity.status(404).body(new ApiResponse("The id not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAllNewsArticle(@PathVariable String id){
        boolean isExist=NewArt.deleteNewsArticales(id);
        if(isExist){
            return ResponseEntity.status(200).body(new ApiResponse("success"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("the newsArticle not Found"));
    }

    @GetMapping("/published")
    public ResponseEntity Published(){
        ArrayList<NewsArticle> PublishArray=NewArt.PublishNews();
        if(PublishArray==null){
            return ResponseEntity.status(400).body(new ApiResponse("The Array is Empty"));

        }
            return ResponseEntity.status(200).body(PublishArray);}

@GetMapping("/getbycategiry")
public ResponseEntity GetByCategory(@RequestParam String category){
    ArrayList<NewsArticle> ArrayByCategory=NewArt.GetByCategory(category);
    if(ArrayByCategory==null){
        return ResponseEntity.status(400).body(new ApiResponse("The Array is Empty"));
    }
    return ResponseEntity.status(200).body(ArrayByCategory);
}


}