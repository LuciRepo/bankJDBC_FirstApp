package org.fastrackit.bank.main;

import org.fastrackit.bank.dao.BankDAO;
import org.fastrackit.bank.helper.DBHelper;
import org.fastrackit.bank.pojo.Bank;
import org.fastrackit.bank.pojo.Bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankMain {
    public static void main(String[] args) throws SQLException {
        Bank b = new Bank();
        b.setId(6);
        b.setName("Raiffessen");
        b.setCountryCode("RO");
        BankDAO bdao = new BankDAO();
        bdao.createBank(b);

       ArrayList<Bank> banksCreated = bdao.getBanks();

       for (Bank bank : banksCreated) {
            System.out.println(bank.getId() + " " + bank.getName() + " " + bank.getCountryCode());
        }
        bdao.updateBank(b);
        ArrayList<Bank> banksUpdated = bdao.getBanks();
        for (Bank bank : banksUpdated) {
            System.out.println(bank.getId() + " " + bank.getName() + " " + bank.getCountryCode());
        }
        //bdao.delete(b);
        ArrayList<Bank> banksDeleted=bdao.getBanks();
        for (Bank bank : banksDeleted) {
            System.out.println(bank.getId() + " " + bank.getName() + " " + bank.getCountryCode());
        }
    }
}
