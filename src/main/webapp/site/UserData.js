"use strict";

function ThisUser(){

    let UserID = -1;
    let UserLogin = -1;
    let UserToken = -1;

    return{
	getUserID: function(){ return UserID},
	setUserID: function(UserID){UserID = UserID},
	getUserLogin: function(){ return UserLogin},
	setUserLogin: function(UserLogin){UserLogin = UserLogin},
	getUserToken: function(){ return UserToken},
    setUserToken: function(UserToken){UserToken = UserToken}
    }	

};