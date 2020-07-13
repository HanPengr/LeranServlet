package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showSale")
public class ShowSaleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ShowSaleServlet");
        List<Door> list = new DoorDao().showSale();
     /*   System.out.println(list);*/
        // 利用gson 将 list对象转变为json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        resp.getWriter().write(json);
    }
}
