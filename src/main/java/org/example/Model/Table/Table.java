package org.example.Model.Table;

import org.example.Data.Entity.ETable;
import org.example.Data.IDataBaseWork;
import org.example.Data.MyData.DTable;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.core.Response;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Table implements ITable {

    @Inject
    private IDataBaseWork DataBaseWork;

    public Response SetData(String JData) {

        Jsonb jsonb = JsonbBuilder.create();

        Map<String, String> Result = new HashMap<>();
        Map<String, Object> MData = new HashMap<>();


        MData = (Map<String, Object>) jsonb.fromJson(JData, MData.getClass());
        ArrayList<ETable> AllData = new ArrayList<>();

        try {
            ArrayList<ArrayList<String>> ParseData = (ArrayList<ArrayList<String>>) MData.getOrDefault("Table", "");

            if (ParseData.isEmpty()) {
                Result.put("Msg", "");
                return Response.ok(jsonb.toJson(Result)).build();
            }

            int user_id = Integer.parseInt(MData.getOrDefault("UserID", "-1").toString());

            ParseData.forEach(Data ->
                    AllData.add(new ETable(Integer.parseInt(Data.get(0)), Data.get(1), Data.get(2), Data.get(3), user_id)));

            if (DataBaseWork.ping() && !AllData.isEmpty())
                Result.put("Msg", DataBaseWork.InputDataDB(user_id, AllData));
            else
                Result.put("Msg", "No connection to server");

            return Response.ok(jsonb.toJson(Result)).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
        }
    }

    public Response GetDBData(String UserID) {
        Jsonb jsonb = JsonbBuilder.create();

        Map<String, String> Result = new HashMap<>();
        Map<String, String> MData = new HashMap<>();

        ArrayList<DTable> DT;

        try {


            if (DataBaseWork.ping()) {
                DT = DataBaseWork.getData(Integer.parseInt(UserID));
            } else {
                DT = new ArrayList<>();

                DTable D1 = new DTable();

                D1.setTable_name("Q");
                D1.setTable_address("YY");
                D1.setTable_number("8800");
                DT.add(D1);

                DTable D2 = new DTable();
                D2.setTable_name("W");
                D2.setTable_address("ZZ");
                D2.setTable_number("555");
                DT.add(D2);

                DTable D3 = new DTable();
                D3.setTable_name("E");
                D3.setTable_address("XX");
                D3.setTable_number("3535");
                DT.add(D3);
            }

            Result.put("Table", jsonb.toJson(DT));
            return Response.ok(jsonb.toJson(Result)).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
        }
    }


}
