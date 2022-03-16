import { FormLogin_module } from '../login/FormLogin.js';
import { FormRegist_module } from '../registration/FormRegist.js';

export const FormStart_module = (() =>  {

    class FormStart_class {

        FormFirstButtons = '<div class="wrapper">'+
        '<div class="back">'+
            '<div class="head border-gradient">'+
                '<div>СиММиР</div>'+
            '</div>'+
            '<div class="main">'+
                '<div class="entry border-gradient">'+
                    '<div class="E_head">'+
                        '<div>Авторизация</div>'+
                    '</div>'+
                    '<div class="E_main"></div>'+
                    '<div class="E_info">'+
                        '<div class="text-info"></div>'+
                    '</div>'+
                    '<div class="E_button">'+
                        '<div class="log-in-form-button my-button">Log in</div>'+
                        '<div class="sign-up-form-button my-button">Sign up</div>'+
                    '</div>'+
                '</div>'+
            '</div>'+
            '<div class="footer border-gradient">'+
                '<div>Информация</div>'+
            '</div>   '+
        '</div>'+
    '</div>';

        ShowStart() {
            document.body.innerHTML = this.FormFirstButtons;
            document.querySelector('.log-in-form-button').onclick = FormLogin_module.ShowLogin;
            document.querySelector('.sign-up-form-button').onclick = FormRegist_module.ShowRegistration;
        };

        BackStart() {
            document.querySelector('.E_main').innerHTML = '';
            document.querySelector('.E_info .text-info').innerHTML = '';
            document.querySelector('.E_button').innerHTML = '<div class="log-in-form-button my-button">Log in</div>'+
                                                            '<div class="sign-up-form-button my-button">Sign up</div>';
            document.querySelector('.log-in-form-button').onclick = FormLogin_module.ShowLogin;
            document.querySelector('.sign-up-form-button').onclick = FormRegist_module.ShowRegistration;
        }

    }

    let BackStart = () => {
        new FormStart_class().BackStart();
    };

    let ShowStart = () => {
        new FormStart_class().ShowStart();
    };

    return {
        ShowStart: ShowStart,
        BackStart: BackStart
    };

})()