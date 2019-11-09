package org.fastrackit.bank.main;
import org.fastrackit.bank.dao.ClientDAO;
import org.fastrackit.bank.pojo.Client;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientMain {
    public static void main(String[] args) throws SQLException {
        Client client =new Client();
        client.setId(4);
        client.setFirstName("Calvin");
        client.setLastName("Kohln");
        client.setPhone("0346777089");
        client.setEmail("Cal@icloud.com");
        client.setAge(38);
        ClientDAO cdao=new ClientDAO();
        cdao.createClient(client);
        ArrayList<Client> clientsCreated=cdao.getClients();
        for(Client c:clientsCreated){
            System.out.println(c.getId()+" "+c.getFirstName()+" "+c.getLastName()+" "+c.getPhone()+" "+c.getEmail()+" "+c.getAge());
        }
        cdao.updateClient(client);
        ArrayList<Client> clientsUpdated=cdao.getClients();
        for(Client c:clientsUpdated){
            System.out.println(c.getId()+" "+c.getFirstName()+" "+c.getLastName()+" "+c.getPhone()+" "+c.getEmail()+" "+c.getAge());
        }
        cdao.delete(client);
        ArrayList<Client> clientsDeleted=cdao.getClients();
        for(Client c:clientsDeleted){
            System.out.println(c.getId()+" "+c.getFirstName()+" "+c.getLastName()+" "+c.getPhone()+" "+c.getEmail()+" "+c.getAge());
        }
    }
}
