package org.example.Data;

import org.example.Data.Entity.ETable;
import org.example.Data.MyData.DTable;

import java.util.ArrayList;

public interface IDataBaseWork {
    Object login(String MailLogin, String Password);
    String add_user(String Mail, String Login, String Password);
    String InputDataDB(int user_id, ArrayList<ETable> AllData);
    ArrayList<DTable> getData(int user_id);
    boolean ping();

}
