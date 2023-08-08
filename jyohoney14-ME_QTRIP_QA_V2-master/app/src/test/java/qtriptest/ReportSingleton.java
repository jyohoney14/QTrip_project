package qtriptest;

import java.io.File;
import java.sql.Timestamp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ReportSingleton {
    private static ReportSingleton instanceOfSingletonReport = null;
    private ExtentReports report;
    private ExtentTest test;

    // Private constructor to prevent external instantiation
    private ReportSingleton() {
        // Generate timestamp for the report file name
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timestampString = String.valueOf(timestamp.getTime());

        // Set up the ExtentReports instance and load configuration
        report = new ExtentReports(System.getProperty("user.dir") + "/OurExtentReport" + timestampString + ".html");
        report.loadConfig(new File(System.getProperty("user.dir") + "../extent_customization_configs.xml"));

        // Start the ExtentTest with a default name "Qtrip"
        test = report.startTest("Qtrip");
    }

    // Method to get the current timestamp
    public static String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }

    // Method to get the instance of the singleton ReportSingleton class
    public static ReportSingleton getInstanceOfSingleTonReportClass() {
        if (instanceOfSingletonReport == null) {
            instanceOfSingletonReport = new ReportSingleton();
        }
        return instanceOfSingletonReport;
    }

    // Getter methods to access the report and test instances
    public ExtentReports getReport() {
        return report;
    }



    public ExtentTest getTest() {
        return test;
    }

    public static Object instanceOfSingletonReport() {
        return null;
    }

}