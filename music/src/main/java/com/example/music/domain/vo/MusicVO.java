package com.example.music.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicVO {

   private Long musicNumber;
   private String musicTitle;
   private String musicSinger;
   private String musicLyrics;
   private String musicRegisterDate;
   private String musicUpdateDate;

}
