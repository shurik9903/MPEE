"use strict";

export const Login_module = (function(){

    class Login_class {
        async Login_async(LoginData) {

            let login = LoginData.login;
            let password = LoginData.password;

            let login_response = await fetch('/MPEE/api/login/' + login + '/' + password, { method: 'GET', headers: { 'Token': 'null' }});
            if (login_response.ok) {
                const data = await login_response.json();

                if (data.Msg)
                    throw Error(data.Msg);

                console.log(data);
                ThisUser.UserID = data.UserID;
                ThisUser.UserName = data.UserName;
                ThisUser.UserToken = data.Token;

                return 'ok';
            } else throw Error("response.serverError " + response.errors);


        };

    }

    let Login_token = LoginData => {
        return new Login_class().Token_async(LoginData);
    }

    let Login = LoginData => {
        return new Login_class().Login_async(LoginData);
    }

    return{
        Login_token_async: Login_token,
        Login_async: Login
    };
})();

