/*
Questo file contiene funzioni e utilities
per la gestione dell'interfaccia grafica e
la simulazione della navigazione tra diverse pagine,
finestre di dialogo e menu a scomparsa laterale.
*/

// TODO: Refactoring


// variabili di stato dell'interfaccia
var side_menu_visible = false;
var modals_stack = [];


// conterra' l'id dell'utente loggato
var login_info = null;

// User Interface
//-----------------------------------------------

function close_side_menu() {
    var menu = document.getElementById("side-menu-container");
    side_menu_visible = false;
    menu.classList.remove("visible");
}

function open_side_menu() {
    var menu = document.getElementById("side-menu-container");
    side_menu_visible = true;
    menu.classList.add("visible");
}


function show_panel(name) {
    var panels = document.getElementsByClassName("panel");
    for(let i = 0; i < panels.length; i++) {
        if(panels[i].dataset["name"] == name) {
            panels[i].classList.remove("hidden");
        } else {
            panels[i].classList.add("hidden");
        }
    }
}


// visualizza una finestra di dialogo
// il sistema gestisce una pila di finestre,
// visualizzando sempre quella che si trova in cima.
// non e' possibile aprire una finestra se gia' si
// trova in cima alla pila
function open_modal(name) {

    // previene l'aggiunta di un modal uguale a
    // quello attualmente visibile
    if(modals_stack.length > 0 &&
       modals_stack[modals_stack.length-1] == name) {
            return;
    }
    var container = document.getElementById("modals-container");

    var modals = container.getElementsByClassName("modal");

    for(let i = 0; i < modals.length; i++) {
        if(modals[i].dataset["name"] === name) {
            modals[i].classList.add("visible");
            container.classList.add("visible");
            modals_stack.push(name);
        } else {
            modals[i].classList.remove("visible");
        }
    }
}


// chiude una finestra di dialogo rimuovendola
// dalla cima della pila di finestre aperte
function close_modal() {
    
    if(modals_stack.length == 0) {
        return;
    }

    modals_stack.pop();

    var container = document.getElementById("modals-container");

    var modals = container.getElementsByClassName("modal");

    if(modals_stack.length == 0) {
        container.classList.remove("visible");
    }
    var current = "";
    if(modals_stack.length > 0) {
        current = modals_stack[modals_stack.length-1];
    }
    for(let i = 0; i < modals.length; i++) {
        if(modals[i].dataset["name"] === current) {
            modals[i].classList.add("visible");
        } else {
            modals[i].classList.remove("visible");
        }
    }
}


// chiude tutte le finestre di dialogo aperte
function close_all_modals() {
    modals_stack = [];

    var container = document.getElementById("modals-container");

    var modals = container.getElementsByClassName("modal");

    container.classList.remove("visible");
    for(let i = 0; i < modals.length; i++) {
        modals[i].classList.remove("visible");
    }
}

//-----------------------------------------------

// funzioni per modificare l'interfaccia grafica
// in base al tipo di utente che sta utilizzando
// la web app

function setup_guest_ui() {
    $("profile-button").textContent = "Accedi";
    $("my-requests-button").classList.add("hidden");
    $("my-settings-button").classList.add("hidden");
    close_side_menu();
    close_all_modals();
    show_panel("home");
}

function setup_user_ui() {
    $("profile-button").textContent = "Esci";
    $("my-requests-button").classList.remove("hidden");
    $("my-settings-button").classList.remove("hidden");
    close_side_menu();
    close_all_modals();
    show_panel("user");
}

function setup_professionist_ui() {

}


// Initialization
//-----------------------------------------------

window.addEventListener("load", function() {

    // load db from disk or init with test data
    db_init();

    window.addEventListener("beforeunload", function(event) {
        db_save();
    });
    
    // side menu
    var container = $("side-menu-container");
    container.on("click", function(event) {
        if(event.target === container) {
            close_side_menu();
        }
    });

    $("open-side-menu-button").on("click", function() {
        open_side_menu();
    });

    $("close-side-menu-button").on("click", function() {
        close_side_menu();
    });

    // modals
    var modals1 = document.getElementsByClassName("close-modal");
    for(let i = 0; i < modals1.length; i++) {
        modals1[i].addEventListener("click", function() {
            close_modal();
        });
    }

    // other
    $("profile-button").on("click", function() {
        if(login_info === null) {
            open_modal("login");
            close_side_menu();
        } else {
            stub_logout();
        }
    });

    $("my-requests-button").on("click", function() {
        stub_get_all_user_requests(login_info);
    });

    $("my-settings-button").on("click", function() {
        open_modal("user-settings");
    });
    
    setup_guest_ui();


    // init forms
    $("login-form").on("submit", function(event) {
        event.preventDefault();
        stub_login();
    });

    $("signup-form").on("submit", function(event) {
        event.preventDefault();
        stub_signup();
    });

    $("change-password-form").on("submit", function(event) {
        event.preventDefault();
        stub_change_password();
    });

    var form = $("new-request-form");
    var sel1 = form.elements["service"];
    var servizi = db_find("services");
    for(let i = 0; i < servizi.length; i++) {
        let o = document.createElement("option");
        o.textContent = servizi[i]["name"];
        sel1.appendChild(o);
    }
    form.on("submit", function(event) {
        event.preventDefault();
        stub_create_request();
    });


    // debug panel
    window.addEventListener("keydown", function(event) {
        if(event.key === "\\") {
            var bar = document.getElementById("panel-switcher");
            bar.classList.toggle("panel-switcher-hidden");
        }
    });
});

