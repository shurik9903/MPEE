import * as TableWork from './module/TableWork.js';
import { RefreshStyle_module } from './module/RefreshStyle.js';
import { TableCSS } from '../../css/tablecss.js';
import {FormStart_module} from '../start/StartForm.js';

export const FormTable_module = (function () {

    class FormTable_class {

        FormBodyTable = '<p align="right" id="UserID"></p>' +
            '<p align="right" id="UserName"></p>' +
            '<p align="right" id="UserToken"></p>' +
            '<h1 align="center">My Table</h1>' +
            '<table id="MyTable" class="table" align="center">' +
            '<thead>' +
            '<tr>' +
            '<th>&#8470</th>' +
            '<th>name</th>' +
            '<th>address</th>' +
            '<th>number</th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>' +
            '</tbody>' +
            '</table>' +
            '<p align="center">' +
            '<input type="button" id="AddRowButton" value="add row"/>' +
            '<input type="button" id="SaveButton" value="Save"/></p>' +
            '<p align="center" id="Result"></p>';


        BuildTable(result) {
            let JsonTableData = jQuery.parseJSON(result)

            let table = document.getElementById("MyTable").getElementsByTagName('tbody')[0];

            JsonTableData.forEach(element => {

                let row = table.insertRow();

                let line_number = document.createElement('td');
                line_number = row.insertCell();
                line_number.appendChild(document.createTextNode(element.table_line_number));

                let name = document.createElement('td');
                name = row.insertCell();
                name.appendChild(document.createTextNode(element.table_name));

                let address = document.createElement('td');
                address = row.insertCell();
                address.appendChild(document.createTextNode(element.table_address));

                let number = document.createElement('td');
                number = row.insertCell();
                number.appendChild(document.createTextNode(element.table_number));
            });

            RefreshStyle_module.AllRefresh();

            document.getElementById("SaveButton").onclick = function () {

                let TableData = [];

                $(".table tbody tr").each(function () {
                    let row = new Array();
                    $(this).children("td").each(function () {
                        row.push($(this).text());
                    })
                    TableData.push(row);
                });

                TableData = { Table: TableData, UserID: ThisUser.UserID };

                let promise = TableWork.SaveTableData_module.PostSaveData_async(TableData);

                let text = document.getElementById("Result");

                promise.then(result => text.innerText = result.Msg)
                    .catch(error => {
                        if (error.status != 403){
                            console.log(error);
                            text.innerText = error.Msg;
                        }else{
                            console.log(error);
                            FormStart_module.ShowStart();
                        }
                    });
            };


            document.getElementById("AddRowButton").onclick = function () {

                let table = document.getElementById("MyTable").getElementsByTagName('tbody')[0];
                let size_element = document.getElementById("MyTable").getElementsByTagName('th').length;
                let row = document.createElement('tr');

                row = table.insertRow();

                for (let i = 0; i < size_element; i++) {
                    let cells = document.createElement('td');
                    cells = row.insertCell();
                }

                RefreshStyle_module.AllRefresh();
            };
        };

        ShowTable() {
            document.body.innerHTML = this.FormBodyTable;
            document.head.innerHTML = TableCSS;

            let UserID = document.getElementById("UserID");
            let UserName = document.getElementById("UserName");
            let UserToken = document.getElementById("UserToken");

            UserID.innerText = ThisUser.UserID;
            UserName.innerText = ThisUser.UserName;
            UserToken.innerText = ThisUser.UserToken;

            let promise = TableWork.TableData_module.GetTableData_async();

            let text = document.getElementById("Result");

            promise.then(result => this.BuildTable(result.Table))
                .catch(error => {
                    if (error.status != 403)
                        text.innerText = error.Msg
                    else{
                        console.log(error.Msg);
                        FormStart_module.ShowStart();
                    }
                });
        };
    };




    let ShowTable = function () {
        new FormTable_class().ShowTable();
    };

    return {
        ShowTable: ShowTable
    };
})();