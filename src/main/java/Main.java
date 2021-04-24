import service.LogService;
import view.ConsoleView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LogService logService = new LogService();
        ConsoleView consoleView = new ConsoleView();
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите дату за которую хотите получить логи: ");
        try {
            String dateLog = sc.nextLine(); // Do validation
            parser.parseJSON(parser.getHTML(dateLog));
        } catch (Exception e) {
            System.out.println("НЕ верные формат или такой даты не существует");
        }
        consoleView.showLog(parser.getLogs());
        logService.persist(parser.getLogs());

    }
}
