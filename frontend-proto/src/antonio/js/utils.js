/*
Restituisce un elemento HTML dato il suo id.
*/
function $(id) {
    var el = document.getElementById(id)
    if(el) {
        el["on"] = el.addEventListener;
    }
    return el;
}


// generate a random string of <len> characters,
function randomString(len) {
    var s = "";
    for(var i = 0; i < len; i++) {
        s += String.fromCharCode("a".charCodeAt(0) + Math.floor(Math.random()*26));
    }
    return s;
}


function validate_email(email) {
    return true;
}


function validate_username(name) {
    if(name.match(/^[a-z][a-z0-9_]*$/i) === null) {
        return false;
    }

    if(name.length < 4 || name.length > 30) {
        return false;
    }

    return true;
}


function validate_password(pass) {
    if(pass.length < 6 || pass.length > 50) {
        return false;
    }
    return true;
}

