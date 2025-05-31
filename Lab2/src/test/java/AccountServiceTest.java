import org.junit.jupiter.api.Test;
import thang.example.AccountService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @Test
    void testRegisterAccountFromCSVAndWriteResult() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-data.csv");
        assertNotNull(inputStream, "Không tìm thấy file test-data.csv");

        // Đọc dữ liệu từ test-data.csv
        List<String> lines;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            lines = reader.lines().collect(Collectors.toList());
        }

        // Chuẩn bị ghi kết quả vào UnitTest.csv
        File outputFile = new File("src/main/resources/UnitTest.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))) {
            writer.write("username,password,email,expected,actual,result\n");

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");

                String username = parts[0].trim();
                String password = parts[1].trim();
                String email = parts[2].trim();
                boolean expected = Boolean.parseBoolean(parts[3].trim());

                boolean actual = accountService.registerAccount(username, password, email);
                boolean passed = (expected == actual);

                writer.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        username, password, email, expected, actual, passed ? "PASSED" : "FAILED"));
            }
        }
    }
}
