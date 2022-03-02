package org.example.Model.Table;

import jakarta.ws.rs.core.Response;

public interface ITable {
    Response SetData(String JData);
    Response GetDBData(String UserID);
}
