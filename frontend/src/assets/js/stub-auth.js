/*
Questo file contiene un insieme di funzioni
che simulano i servizi di autenticazione.

Da non utilizzare in produzione
*/

//-----------------------------------------------

function stub_signup() {
    var form = $("signup-form");

    var data = {
        email: form.elements["email"].value,
        name: form.elements["username"].value,
        pass: form.elements["password"].value,
        pass2: form.elements["password2"].value
    }

    if(validate_username(data.name) == false) {
        console.log("invalid username");
        return;
    }

    if(validate_password(data.pass) == false) {
        console.log("invalid password");
        return;
    }

    var user = db_findOne("users", "name", data.name);
    if(user != null) {
        console.log("username already exists");
        return
    }

    if(data.pass != data.pass2) {
        console.log("password mismatch");
        return;
    }

    login_info = db_insert("users", {
        email: data.email,
        name: data.name,
        password: data.pass
    });
    console.log("signup successful");
    form.reset();

    // modify ui accordingly
    setup_user_ui();
}


function stub_login() {
    var form = $("login-form");
    var name = form.elements["username"].value;
    var pass = form.elements["password"].value;

    var user = db_findOne("users", "name", name);
    if(user == null) {
        console.log("user doesn't exist");
        return
    }

    if(pass != user["password"]) {
        console.log("wrong password");
        return;
    }

    login_info = user["_id"];
    console.log("logged successfully as " + user["name"] + " " + user["_id"]);
    form.reset();

    // modify ui accordingly
    setup_user_ui();
}


function stub_logout() {
    login_info = null;
    setup_guest_ui();
}


function stub_change_password() {
    var form = $("change-password-form");

    var oldPass = form.elements["oldPass"].value;
    var pass1 = form.elements["newPass1"].value;
    var pass2 = form.elements["newPass2"].value;

    var user = db_findOne("users", "_id", login_info);
    if(user == null) {
        console.log("your id is invalid");
        return
    }

    if(oldPass != user["password"]) {
        console.log("wrong password");
        return;
    }

    if(pass1 !== pass2) {
        console.log("the passwords are different");
        return;
    }

    if(!validate_password(pass1)) {
        console.log("invalid password");
        return;
    }

    // update <collection> where <attr>=<value> set <newAttribute>=<newValue>
    db_update("users", "_id", login_info, "password", pass1);
    console.log("updated password");
    form.reset();

    close_modal();
}


function stub_recover_password() {
    console.info("TODO");
}


