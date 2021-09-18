package com.example.test_job_javafx.model;

public class Notes {

    private String heading;
    private String text;

    public Notes(String heading, String text) {
        this.setHeading(heading);
        this.setText(text);
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
