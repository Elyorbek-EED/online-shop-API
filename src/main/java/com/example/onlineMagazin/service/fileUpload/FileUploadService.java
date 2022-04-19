package com.example.onlineMagazin.service.fileUpload;

import com.example.onlineMagazin.dto.file.FileDto;
import com.example.onlineMagazin.dto.file.FileUploadDto;
import com.example.onlineMagazin.dto.filter.FilterDto;
import com.example.onlineMagazin.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService implements BaseService {
    private final String FILE_UPLOAD_PATH = "D:\\Unicorn\\Spring-boot\\onlineShop\\v1_site\\src\\main\\resources\\static\\images\\upload";
    private Path rootLocation;

    public FileUploadService() {
        rootLocation = Paths.get(FILE_UPLOAD_PATH);
    }

    public ResponseEntity<FileDto> save(MultipartFile file) {
        try {
            String org_name = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(org_name);
            String generatedName = System.currentTimeMillis() + "." + extension;
            Files.copy(file.getInputStream(), Paths.get(FILE_UPLOAD_PATH, generatedName), StandardCopyOption.REPLACE_EXISTING);
            return new ResponseEntity<>(new FileDto(generatedName, "upload/" + generatedName), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
