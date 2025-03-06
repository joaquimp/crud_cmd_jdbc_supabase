package br.dev.joaquim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String pwd = "iwvJtIrdorlgtsXQ"; // mudo depois da aula!!!
            String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.mfmmwdiptsysdiohifpi&password=" + pwd;
            Connection conn = DriverManager.getConnection(url);

            Scanner entrada = new Scanner(System.in);
            System.out.print("Informe o numero da conta: ");
            int nroConta = Integer.parseInt(entrada.nextLine());

            String query = "select * from contas where nro_conta = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nroConta);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.print(rs.getInt("nro_conta"));
                System.out.print(" - ");
                System.out.println(rs.getDouble("saldo"));
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}