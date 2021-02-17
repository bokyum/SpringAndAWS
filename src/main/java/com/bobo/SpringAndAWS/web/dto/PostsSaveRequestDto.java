package com.bobo.SpringAndAWS.web.dto;

import com.bobo.SpringAndAWS.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*
* Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성함
* 하지만, 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨
* Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이기 때문
* Entity 클래스가 변경되면 여러 클래스에 영향을 끼치지만
* Request와 Response용 Dto는 View를 위한 클래스라 정말 자주 변경이 필요
* 그렇기 때문에 View Layer와 DB Layer의 역할 분리를 철저하게 하는 게 좋음*/
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
