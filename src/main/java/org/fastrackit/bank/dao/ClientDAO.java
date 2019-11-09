package org.fastrackit.bank.dao;

import com.mysql.cj.xdevapi.SqlDataResult;
import org.fastrackit.bank.helper.DBHelper;
import org.fastrackit.bank.pojo.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ClientDAO {
    public void createClient(Client client) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO client (id, firstName,lastName,phone,email,age) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setInt(1, client.getId());
        stmt.setString(2, client.getFirstName());
        stmt.setString(3, client.getLastName());
        stmt.setString(4, client.getPhone());
        stmt.setString(5, client.getEmail());
        stmt.setInt(6, client.getAge());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public ArrayList<Client> getClients() throws SQLException {
        Connection con = DBHelper.getConnection();
        String selectString = "select * from client";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectString);

        ArrayList<Client> result = new ArrayList<Client>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            Client client = new Client(id, firstName, lastName, phone, email, age);
            result.add(client);
        }
        DBHelper.closeConnection(con);
        return result;
    }

    public void updateClient(Client client) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE client SET firstName=?, lastName=?, phone=?, email=?, age=? WHERE id=?";
        PreparedStatement stmt= con.prepareStatement(updateString);
        stmt.setString(1,client.getFirstName());
        stmt.setString(2,client.getLastName());
        stmt.setString(3,client.getPhone());
        stmt.setString(4,client.getEmail());
        stmt.setInt(5,client.getAge());
        stmt.setInt(6,client.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public void delete (Client client) throws SQLException{
        Connection con= DBHelper.getConnection();
        String deleteString= "DELETE FROM client WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,client.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
}
