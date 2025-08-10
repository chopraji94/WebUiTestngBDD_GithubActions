package Base;

import java.io.File;

public class Constants {

    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String DOWNLOAD_FILE_DIR_LINUX = "/dev/shm/";

    public static final String DOWNLOAD_FILE_DIR = new StringBuilder(USER_DIR).append(File.separator).append("src").append(File.separator)
            .append("java").append(File.separator).append("testdata").append(File.separator).append("downloadFile").append(File.separator).toString();

    public static final String REPORT_DIR = new StringBuilder(USER_DIR).append(File.separator).append("target").append(File.separator)
            .append("extent-report").append(File.separator).toString();

    public static final String ADMIN1_PROPERTIES = new StringBuilder(USER_DIR).append(File.separator).append("src").append(File.separator)
            .append("test").append(File.separator).append("resources").append(File.separator).append("Properties").append(File.separator).append("admin1.properties").toString();
}
