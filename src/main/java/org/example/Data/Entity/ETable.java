package org.example.Data.Entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "\"table_data\"")
public class ETable implements Serializable{

    @Id
    @Column(name = "\"id\"")
    private Integer table_ID;

    @Column(name = "\"line_number\"")
    private Integer table_line_number;

    @Column(name = "\"name\"")
    private String table_name;

    @Column(name = "\"address\"")
    private String table_address;

    @Column(name = "\"number\"")
    private String table_number;

    @Column(name = "\"user_id\"")
    private Integer table_user_id;


    public ETable(){
        insertAll(-1,null,null,null, null);
    }

    public ETable(int line_number, String name, String address, String number, Integer user_id){
        insertAll(line_number,name,address,number, user_id);
    }

    public void insertAll(int line_number, String name, String address, String number, Integer user_id){
        this.table_line_number = line_number;
        this.table_name = name;
        this.table_address = address;
        this.table_number = number;
        this.table_user_id = user_id;
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

    public Integer getTable_user_id() {
        return table_user_id;
    }

    public void setTable_user_id(Integer table_user_id) {
        this.table_user_id = table_user_id;
    }
}
