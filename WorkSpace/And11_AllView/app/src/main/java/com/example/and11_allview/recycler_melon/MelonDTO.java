package com.example.and11_allview.recycler_melon;

public class MelonDTO {
    private int no_img,rank;
    private String title,singer;

    public MelonDTO(int no_img, int rank, String title, String singer) {
        this.no_img = no_img;
        this.rank = rank;
        this.title = title;
        this.singer = singer;
    }

    public int getNo_img() {
        return no_img;
    }

    public void setNo_img(int no_img) {
        this.no_img = no_img;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
