package com.apiread.service.readWriteFile;

import com.apiread.model.dto.OutputAPI;
import org.springframework.web.multipart.MultipartFile;

public interface ReadWriteService {
    OutputAPI downloadExcelBase64(MultipartFile file, OutputAPI outputAPI) throws Exception;
}
