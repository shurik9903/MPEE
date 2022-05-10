package org.example.Model.Work;

import jakarta.ws.rs.core.Response;

public interface IWork {
    Response SetData(String JData);
    Response GetDBData(String UserID);
}
