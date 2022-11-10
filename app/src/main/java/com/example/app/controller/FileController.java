package com.example.app.controller;

import com.example.app.domain.vo.FileVO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/file/*")
@Slf4j
public class FileController {

    @PostMapping("/upload")
    public List<FileVO> upload(List<MultipartFile> upload) throws IOException {
        String rootPath = "C:/upload";
        String uploadFileName = null;
        List<FileVO> files = new ArrayList<>();

        File uploadPath = new File(rootPath, createDirectoryByNow());
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        for(MultipartFile multipartFile : upload){
            FileVO fileVO = new FileVO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            uploadFileName = uuid.toString() + "_" + fileName;
            fileVO.setFileName(fileName);
            fileVO.setFileUuid(uuid.toString());
            fileVO.setFileUploadPath(createDirectoryByNow());
            fileVO.setFileSize(multipartFile.getSize());

            File saveFile = new File(uploadPath, uploadFileName);
            multipartFile.transferTo(saveFile);

            if(checkImageType(saveFile)){
                FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
                thumbnail.close();
                fileVO.setFileImageCheck(true);
            }
            files.add(fileVO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException{
        File file = new File("C:/upload", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    @PostMapping("/delete")
    public void delete(String uploadPath, String fileName, boolean fileImageCheck){
        File file = new File("C:/upload", uploadPath + "/" + fileName);
        if(file.exists()){
            file.delete();
        }

        if(fileImageCheck) {
            file = new File("C:/upload", uploadPath + "/s_" + fileName);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource =new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders header = new HttpHeaders();
        String name = resource.getFilename();
        name = name.substring(name.indexOf("_") + 1);
        header.add("Content-Disposition", "attachment;filename=" + new String(name.getBytes("UTF-8")));
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }

    public boolean checkImageType(File file) throws IOException{
        return Files.probeContentType(file.toPath()).startsWith("image");
    }

    public String createDirectoryByNow(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date now = new Date();
        return format.format(now);
    }
}


















