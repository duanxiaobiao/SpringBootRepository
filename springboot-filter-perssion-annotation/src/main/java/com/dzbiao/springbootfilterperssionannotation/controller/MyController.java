package com.dzbiao.springbootfilterperssionannotation.controller;

import com.dzbiao.springbootfilterperssionannotation.common.annotation.CustomPermission;
import com.dzbiao.springbootfilterperssionannotation.common.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 23:26
 * @Description:
 */
@RestController
@RequestMapping
public class MyController {


    @CustomPermission
    @GetMapping("/api/secure")
    public Result secure() {
        return Result.SUCCESS("Secure API");
    }


    @GetMapping("/web/unsecure")
    public String unsecure() {
        return "Unsecure API";
    }



    @CustomPermission
    @PostMapping("/ssss")
    public String test(MultipartFile file) throws IOException {
        Charset charset = detectCharset(file);
        System.out.println("文件编码格式: " + charset);
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), charset));
        String line;
        while ((line = br.readLine()) != null) {
            // 在这里处理每行的内容，例如将其拆分为字段等操作
            System.out.println(line);
        }
        // 关闭读取流
        br.close();
        return "OK";
    }

    public static Charset detectCharset(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 3);
        byte[] bom = new byte[3];
        int bytesRead = pushbackInputStream.read(bom);
        Charset charset;
        if (bytesRead >= 3 && bom[0] == (byte) 0xEF && bom[1] == (byte) 0xBB && bom[2] == (byte) 0xBF) {
            charset = StandardCharsets.UTF_8;
        } else if (bytesRead >= 4 && bom[0] == (byte) 0x00 && bom[1] == (byte) 0x00 && bom[2] == (byte) 0xFE && bom[3] == (byte) 0xFF) {
            charset = Charset.forName("UTF-32BE");
        } else if (bytesRead >= 4 && bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE && bom[2] == (byte) 0x00 && bom[3] == (byte) 0x00) {
            charset = Charset.forName("UTF-32LE");
        } else if (bytesRead >= 2 && bom[0] == (byte) 0xFE && bom[1] == (byte) 0xFF) {
            charset = StandardCharsets.UTF_16BE;
        } else if (bytesRead >= 2 && bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE) {
            charset = StandardCharsets.UTF_16LE;
        } else if (bytesRead >= 2 && bom[0] == (byte) 0x1A && bom[1] == (byte) 0x45) {
            charset = Charset.forName("GBK");
        } else {
            // Default to UTF-8 if BOM is not detected
            charset = StandardCharsets.UTF_8;
            pushbackInputStream.unread(bom, 0, bytesRead); // Push back the read bytes
        }
        return charset;
    }


}

