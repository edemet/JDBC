package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C01 {


    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


    @Test
    public void test01() throws SQLException {
        String hostname="localhost";
                String dbisim="Datbasetesting";
                String username="postgres";
            String password="783816";

            //1.adım connection==>
        DBUtils.connectionOlustur(hostname,dbisim,username,password);

        //2.adım
        Statement st=DBUtils.statementOlustur();

        //3. adım ===>
        String query = "Select isim From ogrenciler";
        st.executeQuery(query);
        ResultSet rst1= st.executeQuery(query);

        List<String> isimler=new ArrayList<>(); // Bos bir list olusturduk.
        while (rst1.next()){

            isimler.add(rst1.getString(1)); // result setten gelen isimleri listin icine koyduk .
            //System.out.println(rst1.getString(1)); 1. sütunda isimlerin yazdırdık
        }

        Assert.assertTrue(isimler.contains("Merve Gul"));

        DBUtils.connectionStatementKapatma();
    }
}
