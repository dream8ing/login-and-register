

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//@WebServlet( name = "RegisterServlet", value = "/RegisterServlet")
@WebServlet( "/RegisterServlet") //视频中的方法
public class RegisterServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader( "content-type", "text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String name =request.getParameter( "userName");
        String id =request.getParameter( "userId");
        String pw1 =request.getParameter( "userPwd1");
        String pw2 =request.getParameter( "userPwd2");
        if(pw1.equals(pw2))
        {

            try {
                printWriter.write( "正在连接服务器！");
                Database database = new Database( "system","123456");
                printWriter.write( "连接服务器成功！");
                database.insert( id , name , pw1 , "ABCDE");
                printWriter.write( "正在保存注册信息！");
                database.close();
                printWriter.write( "恭喜注册成功！");

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                printWriter.write( "糟糕，注册失败，请重试！");
            }


        }
        else
        {

            printWriter.write( "两次输入密码不一致，请返回重试");
        }

    }


// @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
}
