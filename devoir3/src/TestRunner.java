import java.io.*;

public class TestRunner {
    public static void main(String[] args) {
        // 指定学生文件夹所在的目录
        String folderPath = "/Users/miliya.ai/Downloads/IFT1025-A-A23-Devoir";

        // 获取学生文件夹列表
        File folder = new File(folderPath);
        File[] studentFolders = folder.listFiles(File::isDirectory);

        // 遍历每个学生文件夹
        if (studentFolders != null) {
            for (File studentFolder : studentFolders) {
                // 获取学生名字和编号
                String[] nameAndId = studentFolder.getName().split("_");
                String studentName = nameAndId[0];
                String studentId = nameAndId[1];

                // 构建学生提交文件路径
                String submissionPath = studentFolder.getAbsolutePath() + File.separator +
                        studentName + "_" + studentId + "_assignsubmission_file";

                // 构建 Autograder.java 的路径
                String autograderPath = "/Users/miliya.ai/Downloads/IFT1025-A-A23-Devoir/AutograderSansJUnit.java";

                // 执行测试
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("java", autograderPath, submissionPath);
                    processBuilder.redirectErrorStream(true); // 合并错误流到标准输出流
                    Process process = processBuilder.start();

                    // 获取测试结果输出
                    InputStream inputStream = process.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    int exitCode = process.waitFor();
                    System.out.println("Student: " + studentName + ", ID: " + studentId +
                            ", Test Result: " + exitCode + "\n");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } else {
            System.out.println("No student folders found.");
        }
    }
}
