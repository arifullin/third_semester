package ru.kpfu.repo.repodriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ru.kpfu.execptions.DataBaseEx;


public class DbDriver {

    static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/servlet";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String INSERT = "INSERT INTO user(soap, password, man, subscribe)  VALUES(?,?,?,?)";

    private static void checkDataBase() throws DataBaseEx{
        try {
            if((connection == null)||(connection.isClosed())){
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (SQLException e) {
            throw new DataBaseEx(e);
        } catch (ClassNotFoundException e) {
            throw new DataBaseEx(e);
        }
    }

    public static void addEntity(String[] data) throws DataBaseEx{
        checkDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,data[0]);
            preparedStatement.setString(2,data[1]);
            preparedStatement.setBoolean(3,new Boolean(data[2]));
            preparedStatement.setBoolean(4,new Boolean(data[3]));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DataBaseEx(e);
        }

    }
    public static List<String[]> getAllEntities() throws DataBaseEx{
        checkDataBase();
        List<String[]> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()){
                String[] temp = new String[4];
                temp[0] = resultSet.getString(2);
                temp[1] = resultSet.getString(3);
                temp[2] = new Boolean(resultSet.getBoolean(4)).toString();
                temp[3] = new Boolean(resultSet.getBoolean(5)).toString();
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new DataBaseEx(e);
        }
    return result;
    }

}
