/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasresponsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HashU
 */
public class koneksi {
    public Connection conn;
    public Statement st;
    public ResultSet rs;

    public void koneksi() //fungsi koneksi
    {
        konek("localhost", "res2", "root", ""); //memanggil fungsi konek() untuk melakukan koneksi
    }

    public void konek(String server, String db, String user, String passwd) //program untuk melakukan koneksi
    {
        System.out.println("Keterangan");

        try//memanggil driver
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(
                    "Ada kesalahan Driver JDBC tidak berhasil Load");
            return;
        }

        System.out.println("Mysql JDBC Driver berhasil di Load");
        conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/res2", "root", "");
        } catch (SQLException e) {
            System.out.println("tidak bisa koneksi ke database");
            return;
        }

        if (conn != null) {
            System.out.println("berhasil koneksi!");
        } else {
            System.out.println("koneksi gagal");
        }
    }
}
