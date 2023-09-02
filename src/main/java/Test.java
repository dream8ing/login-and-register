import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws SQLException,ClassNotFoundException
    {
        Database database = new Database( "system","123456");
        database.showConnect();
        Userdata userdata =database.getUser( "10001");
        System.out.println(userdata.getUserName());
        database.close();
        Userdata userdata2 =database.getUser( "10001");
        System.out.println(userdata.getUserName());
 //三阶段测试
        //       database.showConnect();
//        Userdata userdata = database.check( "10001","323456");
//        if(userdata == null)
//        System.out.println("用户不存在或密码错误");
//        else
//            System.out.println("欢迎您 "+userdata.getUserName());

        //二阶段测试
//        ArrayList<Userdata> userList2 = database.getAllUser();
//        System.out.println("Before insert"+" "+userList2.size());
//        database.insert("10001",  "David",   "123456",  "dfdsadfd");
//        database.insert("10002",  "Tom",   "123456",  "dfdsadfd");
//        database.insert("10003",  "Eric",   "123456",  "dfdsadfd");
//        database.insert("10004",  "Alice",   "123456",  "dfdsadfd");
//        ArrayList<Userdata> userList =database.getAllUser(); //Userdata 用户对象
//        System.out.println("After insert"+" "+userList.size());
//        for(Userdata each: userList)
//        {
//            System.out.println(each.getUserId()+" "+each.getUserName());
//        }
        //一阶段测试
        //        Userdata userdata1 = database.getUser( "10001");
//        database.delete( "10001");
//        Userdata userdata2 =database.getUser("10001");
//        System.out.println(userdata1);
//        System.out.println(userdata2);
        //一阶段测试
    }
}
