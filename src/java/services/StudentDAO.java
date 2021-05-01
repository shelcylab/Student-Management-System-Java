package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shelc
 */
public class StudentDAO {

    String jdbcURL = "jdbc:derby://localhost:1527/sample;create=true;user=app;password=app";

    private static final String INSERT_STUDENTS_SQL = "insert into Student2(fname, lname, email, address) VALUES "
            + " (?, ?, ?,?)";

    private static final String SELECT_STUDENT_BY_ID = "select id,fname,lname,email,address from Student2 where id =?";
    private static final String SELECT_ALL_STUDENTS = "select * from Student2";
    private static final String DELETE_STUDENTS_SQL = "delete from Student2 where id = ?";
    private static final String UPDATE_STUDENTS_SQL = "update Student2 set fname = ?,lname= ?, email =?, address=? where id = ?";
    private static final String SELECT_ALL_MARKS = "select * from marksheet";

    public StudentDAO() {
    }

    public List< Marksheet> selectAllMarks() {

        List< Marksheet> marksheet = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MARKS)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int slno = rs.getInt("slno");
                String subcode = rs.getString("subcode");
                String subject = rs.getString("subject");
                String tutor = rs.getString("tutor");
                int total = rs.getInt("total");
                int scored = rs.getInt("scored");
                String result = rs.getString("result");
                int gpa = rs.getInt("gpa");
                marksheet.add(new Marksheet(slno, subcode, subject, tutor, total, scored, result, gpa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return marksheet;
    }

    public List< Student> selectAllProducts() {

        List< Student> products = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                products.add(new Student(id, fname, lname, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return connection;
    }

    public void insertProduct(Student product) throws SQLException {

        System.out.println(INSERT_STUDENTS_SQL);
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            preparedStatement.setString(1, product.getFname());
            preparedStatement.setString(2, product.getLname());
            preparedStatement.setString(3, product.getEmail());
            preparedStatement.setString(4, product.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Student selectProduct(int id) {
        Student product = null;

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                String address = rs.getString("address");

                product = new Student(id, fname, lname, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProduct(Student product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL)) {
            statement.setString(1, product.getFname());
            statement.setString(2, product.getLname());
            statement.setString(3, product.getEmail());
            statement.setString(4, product.getAddress());
            statement.setInt(5, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
