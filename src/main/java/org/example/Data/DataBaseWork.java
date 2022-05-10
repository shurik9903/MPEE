package org.example.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.Data.Entity.ELogin;
import org.example.Data.Entity.ETable;

import org.example.Data.MyData.DLogin;
import org.example.Data.MyData.DTable;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.transaction.*;
import jakarta.annotation.Resource;

public class DataBaseWork implements IDataBaseWork {

    //@PersistenceUnit(unitName = "MySQLServer_PersistenceUnit")
    private EntityManagerFactory EMF;

    @PostConstruct
    public void PersisInit(){
        EMF = Persistence.createEntityManagerFactory("MySQLServer_PersistenceUnit");
    }

    @Resource
    private UserTransaction Transaction;

    public boolean ping(){
        try {
            EMF.createEntityManager();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Object login(String MailLogin, String Password) {
        EntityManager entityManager = null;
        try {
            try {
                entityManager = EMF.createEntityManager();
            } catch (Exception e) {
                return new DLogin("Error while Entity Manager initializing", -1, null);
            }

            Transaction.begin();
            entityManager.joinTransaction();

            System.out.println("MY_TEST " + MailLogin + " " + Password );

            Query query = entityManager.createNativeQuery("Select * from users where (email = ? or name = ?) and password = ?", ELogin.class);

            System.out.println("Testq" );

            query.setParameter(1, MailLogin)
                    .setParameter(2, MailLogin)
                    .setParameter(3, Password);


            DLogin dlogin = null;

            try {
                dlogin  = new DLogin((ELogin) query.getSingleResult());
            } catch (Exception ignored) {}

            Transaction.commit();
            entityManager.close();

            return Objects.requireNonNullElseGet(dlogin, () -> new DLogin("Invalid username / mail or password", -1, null));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.close();
            return new DLogin("Failed to connect to server", -1, null);
        }
    }

    public String add_user(String Mail, String Login, String Password) {

        EntityManager entityManager = null;
        try {
            try {
                entityManager = EMF.createEntityManager();
            } catch (Exception e) {
                return "Error while Entity Manager initializing";
            }

            Transaction.begin();
            entityManager.joinTransaction();

            Query query;

            query = entityManager.createNativeQuery("Select * from users where email = ?");
            query.setParameter(1, Mail);
            if (query.getResultList().size() != 0) {
                entityManager.close();
                return "The entered mail is already in use, please enter another mail";
            }

            query = entityManager.createNativeQuery("Select * from users where name = ?");
            query.setParameter(1, Login);
            if (query.getResultList().size() != 0) {
                entityManager.close();
                return "The login you entered is already in use, please enter another login";
            }

            query = entityManager.createNativeQuery("Insert into users (email, name, password) values (?,?,?)");
            query.setParameter(1, Mail)
                    .setParameter(2, Login)
                    .setParameter(3, Password)
                    .executeUpdate();

            Transaction.commit();
            entityManager.close();
            return "";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.close();
            return "Failed to connect to server";
        }
    }

    public String InputDataDB(int user_id, ArrayList<ETable> AllData) {

        EntityManager entityManager = null;
        try {
            try {
                entityManager = EMF.createEntityManager();
            } catch (Exception e) {
                return "Error while Entity Manager initializing";
            }
            Transaction.begin();
            entityManager.joinTransaction();

            Query query;

            query = entityManager.createNativeQuery("DELETE FROM table_data WHERE user_id = ?");
            query.setParameter(1,user_id)
                    .executeUpdate();


            for (ETable table : AllData) {
                entityManager.persist(table);
                entityManager.flush();
                entityManager.clear();
            }

            Transaction.commit();
            entityManager.close();
            return "Data saved successfully";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.close();
            return "Error save data to data base" + e.getMessage();
        }
    }

    public ArrayList<DTable> getData(int user_id) {

        EntityManager entityManager = null;
        try {
            try {
                entityManager = EMF.createEntityManager();
            } catch (Exception e) {
                return null;
            }

            Transaction.begin();
            entityManager.joinTransaction();

            List<ETable> AllTable = entityManager.createQuery("SELECT t FROM ETable t", ETable.class).getResultList();

            ArrayList<DTable> AllDT = new ArrayList<>();

            for (ETable table: AllTable)
                AllDT.add(new DTable(table));

            Transaction.commit();
            entityManager.close();
            return AllDT;

        } catch (Exception e) {
            entityManager.close();
            System.out.println(e.getMessage());
            return null;
        }
    }

}
