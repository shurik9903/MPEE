"use strict";

export const TableData_module = (function(){

    class TableData_class {

        async GetTableData_async(){
            console.log(ThisUser.UserToken);
            let response = await fetch('/MPEE/api/table/' + ThisUser.UserID, { method: 'GET', headers: {'Token': ThisUser.UserToken}})
            if(response.ok) {
                const data = await response.json();

                let Msg = "";

                if (data.Msg)
                    throw Error(Msg);
                return data;
            } else
                throw {
                    status: response.status,
                    Msg: response.message
                };
        };
    };

    let TableData = function(){
        return new TableData_class().GetTableData_async();
    }

    return{
        GetTableData_async:TableData,
    }

})();

export const SaveTableData_module =  (function(){

    class SaveTableData_class{

        async PostSaveData_async(TableData){
            
            let response = await fetch('/MPEE/api/table', { method: 'POST', headers: { 'Content-Type': 'application/json;charset=utf-8', 'Token': ThisUser.UserToken}, body: JSON.stringify(TableData) });
            if (response.ok) {
                const data = await response.json();

                let Msg = "";
                if (data.Msg)
                    Msg = data.Msg;

                return data;
            } else
                throw {
                    status: response.status,
                    Msg: response.message
                };
        };
    };

    let SaveTableData = function(TableData){
        return new SaveTableData_class().PostSaveData_async(TableData);
    }

    return{
        PostSaveData_async: SaveTableData
    }
})();
