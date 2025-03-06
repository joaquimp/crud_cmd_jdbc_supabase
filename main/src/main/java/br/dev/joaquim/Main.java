package br.dev.joaquim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try {
            String pwd = "buVrib-qitko0-nunfiq"; // mudo depois da aula!!!
            String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.mfmmwdiptsysdiohifpi&password=" + pwd;
            Connection conn = DriverManager.getConnection(url);

            String query = "select * from contas";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.print(rs.getDouble("nro_conta"));
                System.out.print(" - ");
                System.out.println(rs.getDouble("saldo"));
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}