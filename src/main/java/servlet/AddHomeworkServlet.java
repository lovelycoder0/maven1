package servlet;

import jdbc.HomeworkJdbc;
import model.Homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

       Homework sh=new Homework();
        /**
         * 赋值
         **/
        sh.setHomeworkid(Integer.parseInt(req.getParameter("homeworkid")));
        sh.setHomeworktitle(req.getParameter("homeworktitle"));
        List<Homework> stu=null;
        HomeworkJdbc.add(sh);
        resp.sendRedirect("list");
        System.out.println(Integer.parseInt(req.getParameter("homeworkid")));
    }
}
