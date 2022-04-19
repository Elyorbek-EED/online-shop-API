package com.example.onlineMagazin.controller.fileServer;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.file.FileDto;
import com.example.onlineMagazin.dto.file.FileUploadDto;
import com.example.onlineMagazin.service.fileUpload.FileUploadService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@RestController
public class FileUploadServerController extends AbstractController<FileUploadService> {

    public FileUploadServerController(FileUploadService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/file/upload", method = RequestMethod.POST)
    public ResponseEntity<FileDto> fileUpload(@RequestBody FileUploadDto dto) {
        return service.save(dto.getFile());
    }
}
