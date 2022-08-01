package crawler;

import connection.Connecter;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;

public class Main {
    private Properties properties;
    public static void main(String[] arguments) throws MalformedURLException {
        new Main().start();
    }

    public void start() throws MalformedURLException {
//        Properties.initialize();
//        properties = Properties.getInstance();
//
//        PostgresConnection.initialize();
        Connecter connecter = new Connecter("https://www.naver.com/");
        connecter.start();

    }
}
