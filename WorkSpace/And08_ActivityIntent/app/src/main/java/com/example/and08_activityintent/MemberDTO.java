package com.example.and08_activityintent;

import java.io.Serializable;

//직렬화 Serializable : 통신에서 전송을 편하게 하기 위해 메모리 번지수를 직렬로 바꾸는 것
// Main -- intent ---> OS --intent--> sub
// intent를 통해 dto 객체를 전송할때는 반드시 직렬화를 해야한다!@#!@#!@#!@#

public class MemberDTO implements Serializable {
    private String name,phone,gender;

    public MemberDTO(String name, String phone, String gender) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
