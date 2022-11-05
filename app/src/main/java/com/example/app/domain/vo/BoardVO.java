package com.example.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardVO {
    private Long boardNumber;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;
}
