package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;

import java.util.ArrayList;
import dbConnect.DBConn;

public class TodoDao {
	PreparedStatement ps = null;
	
	public static void main(String[] args) {
	
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		DBConn test = new DBConn();
		System.out.println(test);
		
		String SQLQuery = "insert into todo(title, name, sequence) values(?,?,?)";

		// 20201111

	}
}