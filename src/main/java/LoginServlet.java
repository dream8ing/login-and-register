

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//@WebServlet(name = "LoginServlet", value = "/LoginServlet")//初始值
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             //response.setHeader("content-type", "text/html;charset=uft-8");
            //response.setCharacterEncoding("utf-8");
            // PrintWriter printWriter = response.getWriter();
            response.setContentType("text/html;charset=uft-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String id = request.getParameter("userId");
            String pwd = request.getParameter("userPwd");
        try {
            Database database = new Database( "system","123456");
            Userdata userdata = database.check(id,pwd);
            database.close();
            if (userdata == null )
            {
                out.println("账号不存在或者密码输入错误，请返回重试！");
            }
            else
            {
                out.println("欢迎您："+userdata.getUserId()+" "+userdata.getUserName()+"天天开心哦");


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println( "糟糕，登陆失败，请重试！");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println( "糟糕，暂未注册，请注册！");
        }


    }

//   @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
}
