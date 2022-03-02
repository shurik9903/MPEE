import { FormLogin_module } from '../login/FormLogin.js';
import { FormRegist_module } from '../registration/FormRegist.js';
import { Login_module } from '../login/module/Login.js';
import { FormTable_module } from '../table/FormTable.js';

export const FormStart_module = (function () {

    class FormStart_class {

        FormFirstButtons = '<p><input type="button" id="LoginFormButton" value="Login"/>' +
            '<input type="button" id="RegistrationFormButton" value="Registration"/></p>';

        ShowStart() {
            document.body.innerHTML = this.FormFirstButtons;
            document.getElementById("LoginFormButton").onclick = FormLogin_module.ShowLogin;
            document.getElementById("RegistrationFormButton").onclick = FormRegist_module.ShowRegistration;
        };
    }

    let ShowStart = function () {
        new FormStart_class().ShowStart();
    };

    return {
        ShowStart: ShowStart
    };

})()