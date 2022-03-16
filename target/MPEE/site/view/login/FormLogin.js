"use strict";
import { Login_module } from './module/Login.js';
import { FormStart_module } from '../start/start_page_form.js'
import { FormWork_module } from '../work/work_form.js'

export const FormLogin_module = (() => {

    class FormLogin_class {

        FormLogin = '<div class="log-in-form">'+
        '<div class="input-log-in">'+
            '<p>Логин</p>'+
            '<input type="text" size="25" class="name-log-in"></p>'+
        '</div>'+
        '<div class="input-pass">'+
            '<p>Пароль</p>'+
            '<input type="text" size="25" class="pass-log-in"></p>'+
        '</div>'+
    '</div>';

        ShowLogin() {
            document.querySelector('.E_main').innerHTML = this.FormLogin;
            document.querySelector('.E_button').innerHTML = '<div class="back-button my-button">Назад</div>'+
            '<div class="log-in-button my-button">Войти</div>';

            document.querySelector('.back-button').onclick = () => FormStart_module.BackStart();
            

            document.querySelector('.log-in-button').onclick = () => {

                let LoginData = {
                    login: document.querySelector('.name-log-in').value,
                    password: document.querySelector('.pass-log-in').value
                };

                let promise = Login_module.Login_async(LoginData);

                let text =  document.querySelector('.E_info .text-info');

                promise.then(result => FormWork_module.ShowWork())
                    .catch(error => text.innerText = error);
            };
        }
    }

    let ShowLogin = () => {
        new FormLogin_class().ShowLogin();
    };

    

    return {
        ShowLogin: ShowLogin
    };


})()