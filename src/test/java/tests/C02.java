package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C02 {
    //Yazili not ortalamasının 90dan kucuk oldugunu test edın

    @Test
    public void test02() throws SQLException {
        String hostname = "localhost";
        String dbisim = "Datbasetesting";
        String username = "postgres";
        String password = "783816";

        //1.adım connection==>
        DBUtils.connectionOlustur(hostname, dbisim, username, password);

        //2.adım
        Statement st = DBUtils.statementOlustur();

        //3. adım ===>
        String query = "SELECT AVG(yazili_notu) FROM ogrenciler";
        ResultSet rs1=st.executeQuery(query);

        rs1.next();
        double ort=rs1.getDouble(1);
        System.out.printf("%.2f",ort);

        Assert.assertTrue(ort<90);

    }
}
