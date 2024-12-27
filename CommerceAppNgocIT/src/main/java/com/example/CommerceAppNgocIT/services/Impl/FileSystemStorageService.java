package com.example.CommerceAppNgocIT.services.Impl;

import com.example.CommerceAppNgocIT.services.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileSystemStorageService implements StorageService {
private final Path rootLocation;
public FileSystemStorageService() {
    this.rootLocation = Paths.get("src/main/resources/static/uploads");
}
    @Override
    public void store(MultipartFile file) {
            try {
                Path destinationFile = rootLocation.resolve(Paths.get(Objects.requireNonNull(file.getOriginalFilename())))
                        .normalize().toAbsolutePath();
                try(InputStream inputStream = file.getInputStream()){
                    Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);

                }
            }catch (IOException e){
                e.printStackTrace();
            }
    }
    @Override
    public void init() {
        try{
            Files.createDirectories(rootLocation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
