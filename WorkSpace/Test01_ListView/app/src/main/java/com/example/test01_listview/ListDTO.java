package com.example.test01_listview;

import android.widget.ImageView;

public class ListDTO {
    private String iv_thumnail;
    private String title, content;

    public ListDTO(String iv_thumnail, String title, String content) {
        this.iv_thumnail = iv_thumnail;
        this.title = title;
        this.content = content;
    }

    public String getIv_thumnail() {
        return iv_thumnail;
    }

    public void setIv_thumnail(String iv_thumnail) {
        this.iv_thumnail = iv_thumnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
