package com.bobo.SpringAndAWS.config.auth.dto;

import com.bobo.SpringAndAWS.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    // 인증된 사용자 정보만 필요
    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture =user.getPicture();
    }
}
