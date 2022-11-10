package com.example.like.domain.likeVO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LikeVO {

    private Long musicNumber;
    private String musicTitle;
    private String musicSinger;
    private String musicLyrics;
    private String musicRegisterDate;
    private String musicUpdateDate;


}
