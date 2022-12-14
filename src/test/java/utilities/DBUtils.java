package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//com.mysql.jdbc.Driver
//oracle.jdbc.driver.OracleDriver
//org.postgresql.Driver
//com.microsoft.sqlserver.jdbc.SQLServerDrive
//org.sqlite.JDBC

public class DBUtils {

    //1. adım: connection
    //2. adım: statement
    //3. adım: con ve statement kapatmma

    private static Connection connection;
    private static java.sql.Statement statement;

    //1. adım: connection olusturma

    public static Connection connectionOlustur(String hostname,String databaseismi,String username,String password){
        //1.adım driver'a kayıt olduk
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //2.adım connection olustur.
        //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi
        String url="jdbc:postgresql://"+hostname+":5432/"+databaseismi;
        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

        public static java.sql.Statement statementOlustur(){
            try {
                statement=connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return statement;
        }

    public static void connectionStatementKapatma(){

        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
