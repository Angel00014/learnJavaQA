package org.example.cinema;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CinemaList {

    private String name;
    private String annotation;
    private Double summaryRating;
    private List<Reviews> reviews;

    public CinemaList(String name, String annotation, Double summaryRating) {
        this.name = name;
        this.annotation = annotation;
        this.summaryRating = summaryRating;
        this.reviews = getReviews();
    }

    public CinemaList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Double getSummaryRating() {
        return calculateRating();
    }

    public void setSummaryRating(Double summaryRating) {
        this.summaryRating = summaryRating;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    private Double calculateRating(){

        Double calculateRating = 0.00;
        Integer counter = 0;

        if (reviews.isEmpty()){
            return calculateRating;
        }else{
            for (Reviews review : reviews) {
                counter++;
                calculateRating = (calculateRating + review.getUserRating()) / counter;
            }
        }
        return calculateRating;
    }
}
