package com;

import com.model.ClientStat;
import com.sql.SqlHelper;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SqlDb {
    private SqlHelper sqlHelper;

    public SqlDb(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(dbUrl, dbUser, dbPassword);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }
    }

    public List<ClientStat> getStat(String clientPhone) {
        return sqlHelper.execute("select input_data as \"phone\", concat(clients.service_prefix, clients.number) as \"ticket\",\n" +
                "       stand_time, start_time, finish_time,\n" +
                "       users.name as \"serviceman\", services.name as \"service\"\n" +
                "from qsystem.clients inner join qsystem.users on clients.user_id = users.id\n" +
                "                     inner join qsystem.services on clients.service_id = services.id\n" +
                "where input_data like ?", ps -> {
            List<ClientStat> clientStat = new ArrayList<>();
            ps.setString(1, clientPhone);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String phone = rs.getString("phone");
                String ticket = rs.getString("ticket");
                Timestamp standTime = rs.getTimestamp("stand_time");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp finishTime = rs.getTimestamp("finish_time");
                String serviceMan= rs.getString("serviceman");
                String service = rs.getString("service");
                clientStat.add(new ClientStat(phone, ticket, standTime, startTime, finishTime, serviceMan, service));
            }
            return clientStat;
        });
    }
}
