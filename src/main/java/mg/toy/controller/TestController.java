package mg.toy.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public void test(Model model) {

        String inputFilePath = "/path/to/your/file.txt";
        String gzipFilePath = inputFilePath + ".gz";
        String finalFilePath = inputFilePath + ".Z";

        try {
            compressFileWithGzip(inputFilePath);
            renameFile(gzipFilePath, finalFilePath);
            System.out.println("File compressed and renamed to: " + finalFilePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void compressFileWithGzip(String inputFilePath) throws IOException, InterruptedException {
        // ProcessBuilder를 사용하여 gzip 명령과 파일 경로를 인수로 받는 프로세스를 생성합니다.
        ProcessBuilder processBuilder = new ProcessBuilder("gzip", inputFilePath);

        // 오류 스트림과 표준 출력 스트림을 하나로 결합하여 표준 출력 스트림에 출력되도록 설정합니다.
        processBuilder.redirectErrorStream(true);

        // ProcessBuilder를 사용하여 gzip 프로세스를 시작합니다.
        Process process = processBuilder.start();

        // 프로세스가 종료될 때까지 기다립니다.
        int exitCode = process.waitFor();

        // 프로세스가 비정상 종료된 경우 예외를 발생시킵니다.
        if (exitCode != 0) {
            throw new IOException("gzip process failed with exit code " + exitCode);
        }
    }

    private static void renameFile(String oldFilePath, String newFilePath) throws IOException {
        Path oldFile = Paths.get(oldFilePath);
        Path newFile = Paths.get(newFilePath);
        Files.move(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
