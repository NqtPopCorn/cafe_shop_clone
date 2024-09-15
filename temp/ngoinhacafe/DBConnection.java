
// package ngoinhacafe;

// import java.sql.*;
// import javax.sql.*;
// import java.util.*;

// public class DBConnection {

// private static Connection connection;

// public static Connection getConnection() {
// connection = null;
// try {
// Class.forName("com.mysql.cj.jdbc.Driver");
// connection = DriverManager.getConnection(Enviroment.DB_URL,
// Enviroment.DB_USERNAME, Enviroment.DB_PASSWORD);
// } catch (Exception ex) {
// printErrOnException("Xảy ra lỗi khi kết nối đến DB!", ex);
// }
// return connection;
// }

// public static void closeConnection() {
// try {
// connection.close();
// } catch (Exception ex) {
// printErrOnException("Lỗi khi đóng kết nối DB!", ex);
// }
// }

// public static void printErrOnException(String err_name, Exception ex) {
// System.out.println("================");
// System.err.println(err_name);
// System.err.println("Nội dung lỗi:");
// System.err.println(ex.getMessage());
// System.out.println("");
// ex.printStackTrace();
// System.out.println("================");
// }

// public static ResultSet sendQuery(String query) {
// ResultSet rs = null;
// try {
// // connnect to database
// connection = getConnection();
// // crate statement - prevent SQL Injection
// PreparedStatement stmt = connection.prepareStatement(query);
// // get data from table 'student'
// rs = stmt.executeQuery();
// return rs;
// } catch (Exception ex) {
// printErrOnException("Xảy ra lỗi khi thực thi chuỗi truy vấn!", ex);
// }

// return rs;
// }

// public static int sendUpdateQuery(String query) {
// int affected_rows = 0;

// try {
// // connnect to database
// connection = getConnection();
// // crate statement - prevent SQL Injection
// PreparedStatement stmt = connection.prepareStatement(query);
// // get data from table 'student'
// affected_rows = stmt.executeUpdate();
// return affected_rows;
// } catch (Exception ex) {
// printErrOnException("Xảy ra lỗi khi thực thi chuỗi truy vấn cập nhật!", ex);
// affected_rows = 0;
// }
// return affected_rows;
// }

// public static ArrayList<String> getColumnNames(String table) {
// ArrayList<String> str = new ArrayList<>();
// ResultSet Result = sendQuery("SELECT * FROM " + table);
// try {
// ResultSetMetaData rsMetaData = Result.getMetaData();
// for (int i = 1; i < rsMetaData.getColumnCount() + 1; i++) {
// str.add(rsMetaData.getColumnName(i));
// }
// } catch (Exception ex) {
// printErrOnException("Đã xảy ra lỗi khi lấy danh sách tên cột!", ex);
// str = null;
// }
// return str;
// }

// public static ResultSet getAllColumsFrom(String table) {
// ResultSet Result = sendQuery("SELECT * FROM " + table);
// return Result;
// }

// public static ResultSet getColumsFrom(String columns, String table) {
// ResultSet Result = sendQuery("SELECT " + columns + " FROM " + table);
// return Result;
// }

// public static int deleteAllFromTable(String table) {
// int deleted_rows = sendUpdateQuery("DELETE FROM " + table);
// return deleted_rows;
// }

// public static int deleteAllFromTableWhere(String table, String condition) {
// int deleted_rows = sendUpdateQuery("DELETE FROM " + table + " WHERE " +
// condition);
// return deleted_rows;
// }

// public static int updateWhere(String table, String columnToUpdate, String
// valueToUpdate, String condition) {
// String query = "UPDATE " + table + " "
// + "SET " + columnToUpdate + "=" + valueToUpdate + " "
// + "WHERE " + condition;
// int updated_rows = sendUpdateQuery(query);
// return updated_rows;
// }

// public static int insertInto(String table, String columns, String values) {
// String query = "INSERT INTO " + table + " (" + columns + ")"
// + "VALUES " + "(" + values + ")";
// int inserted_rows = sendUpdateQuery(query);
// return inserted_rows;
// }
// }
