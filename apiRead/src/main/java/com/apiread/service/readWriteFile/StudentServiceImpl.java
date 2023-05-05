package com.apiread.service.readWriteFile;

import com.apiread.common.RegexConst;
import com.apiread.model.Student;
import com.apiread.model.dto.DtoStudent;
import com.apiread.model.dto.OutputAPI;
import com.apiread.repository.StudentRepo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements ReadWriteService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RegexConst regexConst;


    public List<DtoStudent> readExcel(MultipartFile file) throws Exception {
        List<DtoStudent> dtoStudents = new ArrayList<>();
//      Xử lý file ở đây
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();

//          Lưu file vào ổ đĩa hoặc xử lý file ở đây
            InputStream inputStream = new ByteArrayInputStream(bytes);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            // Iterate over rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                DtoStudent dtoStudent = new DtoStudent();
                int count = 0;

                dtoStudent.setStt(row.getCell(count).getStringCellValue());
                dtoStudent.setName(row.getCell(++count).getStringCellValue());
                dtoStudent.setBirthday(row.getCell(++count).getStringCellValue());
                dtoStudent.setAddress(row.getCell(++count).getStringCellValue());
                dtoStudent.setClassroom(row.getCell(++count).getStringCellValue());
                dtoStudent.setSchool(row.getCell(++count).getStringCellValue());
                dtoStudent.setPhone(row.getCell(++count).getStringCellValue());
                dtoStudent.setEmail(row.getCell(++count).getStringCellValue());
                dtoStudents.add(dtoStudent);
            }

            workbook.close();
            inputStream.close();

        }
        return dtoStudents;
    }

    public OutputAPI writeExcel(List<DtoStudent> dtoStudents, OutputAPI outputAPI) throws IOException {

//      Tạo workbook mới
        XSSFWorkbook workbook = new XSSFWorkbook();

//      Tạo sheet mới
        Sheet sheet = workbook.createSheet("Sheet1");

//      Tạo header cho sheet
        Row headerRow = sheet.createRow(0);

        int countHeader = 0;
        headerRow.createCell(countHeader).setCellValue(regexConst.message("stt"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("names"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("birthday"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("address"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("classroom"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("school"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("phone"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("email"));
        headerRow.createCell(++countHeader).setCellValue(regexConst.message("result"));

//      Ghi dữ liệu của đối tượng vào sheet
        int rowCount = 1;
        for (DtoStudent dtoStudent : dtoStudents) {

            Row dataRow = sheet.createRow(rowCount++);

            String result = "";

            final String stt = dtoStudent.getStt();
            boolean stt1 = Pattern.matches(regexConst.stt, stt);
            if (!stt1) {
                result += regexConst.message("errorStt");
            }

            final String name = dtoStudent.getName();
            boolean name1 = Pattern.matches(regexConst.names, name);
            if (!name1) {
                result += regexConst.message("errorName");
            }

//              Chuỗi String chứa ngày sinh của người dùng
            final String birthday = dtoStudent.getBirthday();

//              Định dạng chuỗi ngày tháng
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(regexConst.birthday);

//              Chuyển đổi chuỗi thành đối tượng LocalDate
            LocalDate dateOfBirth = LocalDate.now();
            try {
                dateOfBirth = LocalDate.parse(birthday, formatter);
                //              Lấy ngày hiện tại
                LocalDate today = LocalDate.now();

//              Lấy ngày trước 18 năm tính từ ngày hiện tại
                LocalDate date18YearsAgo = today.minusYears(18);

//              So sánh ngày sinh với ngày trước 18 năm
                if (dateOfBirth.isAfter(date18YearsAgo)) {
                    result += regexConst.message("errorBirthday18");
                }
            } catch (Exception e) {
                result += regexConst.message("errorBirthdayFormat");
            }

            final String address = dtoStudent.getAddress();
            boolean address1 = Pattern.matches(regexConst.address, address);
            if (!address1) {
                result += regexConst.message("errorAddress");
            }

            final String classroom = dtoStudent.getClassroom();
            boolean classroom1 = Pattern.matches(regexConst.classroom, classroom);
            if (!classroom1) {
                result += regexConst.message("errorClassroom");
            }

            final String school = dtoStudent.getSchool();
            boolean school1 = Pattern.matches(regexConst.school, school);
            if (!school1) {
                result += regexConst.message("errorSchool");
            }

            final String phone = dtoStudent.getPhone();
            boolean phone1 = Pattern.matches(regexConst.phone, phone);
            if (!phone1) {
                result += regexConst.message("errorPhone");
            }

            final String email = dtoStudent.getEmail();
            boolean email1 = Pattern.matches(regexConst.email, email);
            if (!email1) {
                result += regexConst.message("errorEmail");
            }

            int createRow = 0;
            dataRow.createCell(createRow).setCellValue(stt);
            dataRow.createCell(++createRow).setCellValue(name);
            dataRow.createCell(++createRow).setCellValue(birthday);
            dataRow.createCell(++createRow).setCellValue(address);
            dataRow.createCell(++createRow).setCellValue(classroom);
            dataRow.createCell(++createRow).setCellValue(school);
            dataRow.createCell(++createRow).setCellValue(phone);
            dataRow.createCell(++createRow).setCellValue(email);
            if (result.equals("")) {
                result = regexConst.message("Success");
                Student studentSuccess = new Student();
                studentSuccess.setName(name);
                studentSuccess.setBirthday(dateOfBirth);
                studentSuccess.setAddress(address);
                studentSuccess.setClassroom(classroom);
                studentSuccess.setSchool(school);
                studentSuccess.setPhone(phone);
                studentSuccess.setEmail(email);
                studentRepo.save(studentSuccess);
                outputAPI.setSuccessRecord(1 + outputAPI.getSuccessRecord());
            }
            dataRow.createCell(++createRow).setCellValue(result);
        }
        outputAPI.setTotalRecord(dtoStudents.size());

        // Ghi workbook ra file Excel
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/fileResult/result.xlsx");
        workbook.write(outputStream);
        workbook.close();
        return outputAPI;
    }

    @Override
    public OutputAPI downloadExcelBase64(MultipartFile file, OutputAPI outputAPI) throws Exception {
//      Step 0:  Đọc ghi file
        writeExcel(readExcel(file), outputAPI);

        // Read the Excel file
        FileInputStream inputStream = new FileInputStream("src/main/resources/fileResult/result.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        // Convert the Excel file to a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] excelBytes = outputStream.toByteArray();
        // Convert the byte array to a Base64-encoded string
        // String base64String = Base64.getEncoder().encodeToString(excelBytes);
        outputAPI.setContent(Base64.getEncoder().encodeToString(excelBytes));
        return outputAPI;
    }

}