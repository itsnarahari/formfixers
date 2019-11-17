package com.form.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DBUtils {
	
	private static DataSource dataSource;
	private static String host="corporate.appup.com";
	private static String username="cronuser";
	private static String password="Cronuser#123";
	private static String schema="crondb";

	
	public static DataSource getDataSource() throws SQLException
	{
        MysqlDataSource mysqlDS = new MysqlDataSource();

        mysqlDS.setServerName(host);
        mysqlDS.setUser(username);
        mysqlDS.setPassword(password);
        mysqlDS.setDatabaseName(schema);
        mysqlDS.setUseInformationSchema(true);
        mysqlDS.setProcessEscapeCodesForPrepStmts(false);
        mysqlDS.setCharacterEncoding("utf-8");
        return mysqlDS;
	}
	
	  public static List<Map<String, Object>> run(DataSource ds, String query) throws SQLException {

		    // Create a QueryRunner that will use connections from the given DataSource
		    QueryRunner run = new QueryRunner(ds);
		  
		    List<Map<String, Object>> returnList = run.query(query, new MapListHandler());

		    // Execute the query and get the results back from the handler
		    return returnList;
		  }
	public static void main(String[] args) throws SQLException {
		
		String query = "SELECT * FROM BULK_TASK;";
		//dataSource = getDataSource();
		
		List m  =run(getDataSource(),query);
		
		
		System.out.println(m);
	}

}
