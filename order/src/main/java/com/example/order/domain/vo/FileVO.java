package com.example.order.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data /*실무에서는 getter setter따로따로 분리해서 쓴다*/
public class FileVO {

    private long fileNumber;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
    private long fileSize;
    private boolean fileImageCheck;
    private long boardNumber;

}