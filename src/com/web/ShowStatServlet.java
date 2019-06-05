package com.web;

import com.Config;
import com.SqlDb;
import com.model.ClientStat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowStatServlet extends HttpServlet {
    private SqlDb sqlDb = Config.get().getSqlDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientStat", new ArrayList<>());
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String phone = req.getParameter("phone");
        List<ClientStat> clientStat;

        if (phone != null && phone.trim().length() != 0) {
            clientStat = sqlDb.getStat(phone);
        } else {
            clientStat = new ArrayList<>();
        }
        req.setAttribute("clientStat", clientStat);
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }
}
