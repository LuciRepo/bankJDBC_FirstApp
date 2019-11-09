package org.fastrackit.bank.dao;

import org.fastrackit.bank.helper.DBHelper;
import org.fastrackit.bank.pojo.Bank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class BankDAO {
    public void createBank (Bank b) throws SQLException {
        Connection con= DBHelper.getConnection();
        String insertString="INSERT INTO bank (id, name, countryCode) VALUES (?, ?, ?);";
        PreparedStatement stmt=con.prepareStatement(insertString);
        stmt.setInt(1,b.getId());
        stmt.setString(2,b.getName());
        stmt.setString(3,b.getCountryCode());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);

    }
    public ArrayList<Bank> getBanks() throws  SQLException{
        Connection con= DBHelper.getConnection();
    String selectString="select*from bank";
        Statement stmt=con.createStatement();

        ResultSet rs=stmt.executeQuery(selectString);

        ArrayList<Bank> result=new ArrayList<Bank>();
        while (rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String countryCode=rs.getString("countryCode");
            Bank b=new Bank (id,name,countryCode);
            result.add(b);

        }
        DBHelper.closeConnection(con);
        return result;
    }

    public  void updateBank(Bank bank) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE bank SET name=?, countryCode=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(updateString);
        stmt.setString(1, bank.getName());
        stmt.setString(2, bank.getCountryCode());
        stmt.setInt(3, bank.getId());

        stmt.executeUpdate();

        DBHelper.closeConnection(con);
    }

    public  void delete(Bank bank) throws SQLException {
        Connection con = DBHelper.getConnection();
        String deleteString = "DELETE FROM bank WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(deleteString);
        stmt.setInt(1, bank.getId());
        stmt.executeUpdate();

        DBHelper.closeConnection(con);
    }


}
