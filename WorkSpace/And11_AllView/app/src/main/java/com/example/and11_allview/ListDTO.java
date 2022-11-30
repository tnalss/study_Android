package com.example.and11_allview;

public class ListDTO {

    private String title, cnt;

    public ListDTO(String title, String cnt) {
        this.title = title;
        this.cnt = cnt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
}
