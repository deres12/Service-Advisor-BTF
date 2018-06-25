/*
Questo file contiene funzioni che simulano il
la maggior parte delle funzioni messe a
disposizione dal sistema
*/

// utente registrato
//-----------------------------------------------

function stub_create_request() {
    var form = $("new-request-form");
    
    var data = {
        service: form.elements["service"].value,
        address: form.elements["address"].value,
        duration: form.elements["duration"].value,
        description: form.elements["descr"].value
    };

    db_insert("requests", {
        "userId": login_info,
        "service": data.service,
        "address": data.address,
        "duration": data.duration,
        "description": data.description
    });

    console.log("request created");

    close_modal();
}

function stub_get_all_user_requests(user_id) {

    var data = db_find("requests", "userId", user_id);

    var list = document.getElementById("requests-list");

    while(list.firstChild) {
        list.removeChild(list.firstChild);
    }

    data.forEach(req => {
        var item = document.createElement("li");
        item.innerHTML += `servizio: ${req.service}<br>`;
        item.innerHTML += `indirizzo: ${req.address}<br>`;
        item.innerHTML += `data: ${req.duration}<br>`;
        item.innerHTML += `descrizione: ${req.description}<br>`;

        list.appendChild(item);
    });

    open_modal("user-requests");
}

function stub_get_single_user_request(id) {
    var data = db_findOne("requests", "_id", id);
    return data;
}

function stub_get_request_details() {}

function stub_close_request() {}

function stub_evaluate_professionist() {}


// professionisti
//-----------------------------------------------

function stub_update_professionist_profile() {}

function stub_get_available_requests() {}

function stub_make_bid() {}

function stub_get_watched_requests() {}

function stub_send_notification_to_professionist() {}

