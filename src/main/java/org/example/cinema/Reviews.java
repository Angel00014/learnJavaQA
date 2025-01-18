package org.example.cinema;

public class Reviews{

    private String username;
    private String textReview;
    private Double userRating;

    public Reviews(String username, String textReview, Double userRating) {
        this.username = username;
        this.textReview = textReview;
        this.userRating = userRating;
    }

    public Reviews() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String textReview) {
        this.textReview = textReview;
    }

    public Double getUserRating() {
        return userRating;
    }

    public void setUserRating(Double userRating) {
        this.userRating = userRating;
    }
}
