package com.example.exerciseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotEmpty(message = "The id cannot Empty")
    private String id;
    @NotEmpty(message = "The title cannot Empty")
    @Size(max=100,message = "The title Maximum length of 100 characters")
    private String title;
    @NotEmpty(message = "The author name cannot Empty")
    @Size(min=5,max=20,message = "The author name must be more than 4  and Maximum length of 20 characters")
    @Pattern(regexp = ".*[a-zA-Z]")
    private String author;
    @NotEmpty(message = "The content cannot Empty")
    @Size(max = 200,message = "The content Maximum length of 200 characters")
    private String content;
    @NotEmpty(message = "The category cannot Empty")
    @Pattern(regexp = "politics|sport|technology")
    private String category;
@NotEmpty(message = "The image url cannot be null")
    private String imageUrl;
@AssertFalse
private boolean isPublished;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private Date publishDate;




}
