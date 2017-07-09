package net.ngoar;

import java.util.Date;

public class SocialEntity {
    private String text;
    private Date dateOfPost;

    public SocialEntity(String text, Date dateOfPost) {
        this.text = text;
        this.dateOfPost = dateOfPost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    @Override
    public String toString() {
        return "SocialEntity{" +
                "text='" + text + '\'' +
                ", dateOfPost=" + dateOfPost +
                '}';
    }
}
