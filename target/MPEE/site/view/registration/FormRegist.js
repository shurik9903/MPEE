import { Registration_module } from './module/Registration.js';
import { FormStart_module } from '../start/start_page_form.js'

export const FormRegist_module = (() => {

    class FormRegist_class {


        FormRegistration = '<div class="sign-up-form">'+
        '<div class="input-email">'+
            '<p>Почта</p>'+
            '<input type="text" size="25" class="email-sign-up"></p>'+
        '</div>'+
        '<div class="input-login">'+
            '<p>Логин</p>'+
            '<input type="text" size="25" class="login-sign-up"></p>'+
        '</div>'+
        '<div class="input-pass1">'+
            '<p>Пароль</p>'+
            '<input type="text" size="25" class="pass1-sign-up"></p>'+
        '</div>'+
        '<div class="input-pass2">'+
            '<p>Повторите пароль</p>'+
            '<input type="text" size="25" class="pass2-sign-up"></p>'+
        '</div>'+
    '</div>';


        ShowRegistration() {
            document.querySelector('.E_main').innerHTML = this.FormRegistration;
            document.querySelector('.E_button').innerHTML = '<div class="back-button my-button">Назад</div>'+
            '<div class="sign-up-button my-button">Зарегистрироваться</div>';

            
            document.querySelector('.back-button').onclick = () => FormStart_module.BackStart();

            document.querySelector('.sign-up-button').onclick = function () {

                let RegData = {
                    email: document.querySelector('.email-sign-up').value,
                    username: document.querySelector('.login-sign-up').value,
                    password: document.querySelector('.pass1-sign-up').value,
                    password2: document.querySelector('.pass2-sign-up').value
                };

                let promise = Registration_module.Registration_async(RegData);

                let text = document.querySelector('.E_info .text-info');

                promise.then(
                    result => text.innerText = result,
                    error => text.innerText = error
                );
            };
        };

    }


    let ShowRegistration = function () {
        new FormRegist_class().ShowRegistration();
    };

    return {
        ShowRegistration: ShowRegistration
    };

})()