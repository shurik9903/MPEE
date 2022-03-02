package org.example.Data.MyData;

import org.example.Data.Entity.ETable;

public class DTable {

    private Integer table_ID;
    private Integer table_line_number;
    private String table_name;
    private String table_address;
    private String table_number;

    public DTable(){
        insertAll(-1,null,null,null);
    }

    public DTable(ETable table){
        insertAll(table.getTable_line_number(),table.getTable_name(),table.getTable_address(),table.getTable_number());
    }

    public DTable(int line_number, String name, String address, String number){
        insertAll(line_number,name,address,number);
    }

    public void insertAll(int line_number, String name, String address, String number){
        this.table_line_number = line_number;
        this.table_name = name;
        this.table_address = address;
        this.table_number = number;
    }

    public Integer getTable_ID() {
        return table_ID;
    }

    public void setTable_ID(Integer tableID) {
        this.table_ID = tableID;
    }

    public Integer getTable_line_number() {
        return table_line_number;
    }

    public void setTable_line_number(Integer table_line_number) {
        this.table_line_number = table_line_number;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_address() {
        return table_address;
    }

    public void setTable_address(String table_address) {
        this.table_address = table_address;
    }

    public String getTable_number() {
        return table_number;
    }

    public void setTable_number(String table_number) {
        this.table_number = table_number;
    }
}
