package ru.progwards.java2.lessons.Training.My;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQL {

        public static void main (String[] args)
        {
            System.out.println("nn***** MySQL JDBC Connection Testing *****");
            Connection conn = null;
            try
            {
                Class.forName ("com.MySQL.jdbc.Driver").newInstance ();
                String userName = "root";
                String password = "12345678";
                String url = "jdbc:MySQL://localhost/AmtDB";
                conn = DriverManager.getConnection (url, userName, password);
                System.out.println ("Database Connection Established...");
            }
            catch (Exception ex)
            {
                System.err.println ("Cannot connect to database server");
                ex.printStackTrace();
            }
            finally
            {
                if (conn != null)
                {
                    try
                    {
                        System.out.println("n***** Let terminate the Connection *****");
                        conn.close ();
                        System.out.println ("Database connection terminated... ");
                    }
                    catch (Exception ex)
                    {
                        System.out.println ("Error in connection termination!");
                    }
                }
            }
        }
    }

