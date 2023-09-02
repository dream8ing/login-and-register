

import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection connection = null;
    public Database(String name,String password) throws SQLException, ClassNotFoundException {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           this.connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe",name,password);
    }
    public void showConnect()
    {
         System.out.println(this.connection);
    }

    public  void insert(String userId,String userName,String userPwd,String userImgPath) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("INSERT  INTO USERDATA2 values (?,?,?,?)");
        prep.setString( 1,userId);
        prep.setString(2,userName);
        prep.setString(3,userPwd);
        prep.setString(4,userImgPath);
        prep.executeQuery();
    }
    public void  delete(String userId) throws SQLException {
          PreparedStatement prep = connection.prepareStatement("delete from USERDATA2 where USER_ID =?");
          prep.setString( 1,userId);
          prep.executeQuery();

    }
    public Userdata getUser(String userId) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("select * from USERDATA2 where USER_ID=?");
        prep.setString(1,userId);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next())
        {
            String name = resultSet.getString( "user_name");
            String id = resultSet.getString( "user_id");
            String pwd = resultSet.getString( "user_pwd");
            String path = resultSet.getString( "user_img_path");
            return  new Userdata(id,name,pwd,path);
        }
        else return null;


    }
    public ArrayList<Userdata> getAllUser() throws SQLException {
        ArrayList<Userdata> userList= new ArrayList<Userdata>();
        PreparedStatement prep =connection.prepareStatement("select * from USERDATA2");
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        while (resultSet.next())
        {
            String name = resultSet.getString( "user_name");
            String id = resultSet.getString( "user_id");
            String pwd = resultSet.getString( "user_pwd");
            String path = resultSet.getString( "user_img_path");
            userList.add(  new Userdata(id,name,pwd,path));
        }
         return userList;

    }
    public void close() throws SQLException
    {
        connection.close();
    }
    public Userdata check(String userId, String userPwd) throws SQLException {
        PreparedStatement prep = connection.prepareStatement( "select  USERDATA2.USER_PWD from USERDATA2 where USER_ID =?");
        prep.setString(1,userId);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if (resultSet.next())
        {
            String pwd = resultSet.getString( "user_pwd");
            if(userPwd.equals(pwd))
            {
                return getUser(userId);//这个用户

            }
            else
                return null;
        }
        else
        return null;
    }
}
