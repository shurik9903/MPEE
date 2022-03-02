import { FormStart_module } from '../start/StartForm.js';
import { Registration_module } from './module/Registration.js';

export const FormRegist_module = (function () {

    class FormRegist_class {


        FormRegistration = '<form>' +
            '<h2>Registration' +
            '<p><strong>Please type your email: </strong>' +
            '<input type="text" size="25" id="RegEmail" onkeydown="if (event.keyCode == 13) {return false;}"></p>' +
            '<p><strong>Please type your user name: </strong>' +
            '<input type="text" size="25" id="RegLogin" onkeydown="if (event.keyCode == 13) {return false;}"></p>' +
            '<p><strong>Please type your password: </strong>' +
            '<input type="password" size="15" id="RegPassword" onkeydown="if (event.keyCode == 13) {return false;}"></p>' +
            '<p><strong>Please type your password: </strong>' +
            '<input type="password" size="15" id="RegPassword2" onkeydown="if (event.keyCode == 13) {return false;}"></p>' +
            '<p><input type="button" id="BackButton2" value="Back"/>' +
            '<input type="button" id="RegistrationButton" value="Registration"/></p>' +
            '<p id="Result"></p>' +
            '</h2>' +
            '</form>';


        ShowRegistration() {
            document.body.innerHTML = this.FormRegistration;
            document.getElementById("BackButton2").onclick = FormStart_module.ShowStart;
            document.getElementById("RegistrationButton").onclick = function () {

                let RegData = {
                    email: document.getElementById("RegEmail").value,
                    username: document.getElementById("RegLogin").value,
                    password: document.getElementById("RegPassword").value,
                    password2: document.getElementById("RegPassword2").value
                };

                let promise = Registration_module.Registration_async(RegData);

                let text = document.getElementById("Result");

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