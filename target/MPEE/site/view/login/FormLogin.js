"use strict";
import { FormStart_module } from '../start/StartForm.js';
import { Login_module } from './module/Login.js';
import { FormTable_module } from '../table/FormTable.js';

export const FormLogin_module = (function () {

    class FormLogin_class {

        FormLogin = '<form>' +
            '<h2>Login' +
            '<p><strong>Please type your user name: </strong>' +
            '<input type="text" size="25" id="login" onkeydown="if (event.keyCode == 13) {return false;}"></p>' +
            '<p><strong>Please type your password: </strong>' +
            '<input type="password" size="15" id="password" onkeydown="if (event.keyCode == 13) {return false;}"></p>' +
            '<p><input type="button" id="BackButton" value="Back"/>' +
            '<input type="button" id="LoginButton" value="Login"/></p>' +
            '<p id="Result"></p>' +
            '</h2>' +
            '</form>';

        ShowLogin() {
            document.body.innerHTML = this.FormLogin;
            document.getElementById("BackButton").onclick = FormStart_module.ShowStart;
            document.getElementById("LoginButton").onclick = function () {

                let LoginData = {
                    login: document.getElementById("login").value,
                    password: document.getElementById("password").value
                };

                let promise = Login_module.Login_async(LoginData);

                let text = document.getElementById("Result");

                promise.then(result => FormTable_module.ShowTable())
                    .catch(error => text.innerText = error);
            };
        }
    }

    let ShowLogin = function () {
        new FormLogin_class().ShowLogin();
    };

    return {
        ShowLogin: ShowLogin
    };


})()