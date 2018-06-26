/*
Questo file contiene un insieme di classi che consentono
di simulare un servizio di database.
I dati vengono memorizzati in maniera persistente
sfruttando il "localStorage"
*/

var db = {};


// Save Database to disk
function db_save() {
    if("localStorage" in window) {
        try {
            localStorage.setItem("db", JSON.stringify(db));
            console.info("database saved to persistent storage");
        } catch(error) {
            console.error(error);
        }
    }
}


// Load Database from disk
function db_load() {
    if("localStorage" in window) {
        try {
            var data = localStorage.getItem("db");
            if(data === null) {
                return false;
            }

            var temp = JSON.parse(data);
            db = temp;
        } catch(error) {
            console.error(error);
            return false;
        }
    }
    return true;
}


// DELETE * FROM *
function db_reset() {
    if("localStorage" in window) {
        try {
            localStorage.removeItem("db");
        } catch(error) {
            console.error(error);
        }
    }

    db = {
        "users": [],
        "requests": [],
        "offers": [],
        "services": []
    };

    console.info("database cleared")
}


// tries to load db from disk, if it fails, it will
// initializa a db with some test data
function db_init() {
    if(db_load()) {
        console.info("database loaded from persistent storage")
    } else {
        console.info("initializing database with test data");
        db = {
            "users": [
                {
                    "_id": randomString(32),
                    "email": "a@example.com",
                    "name": "antonio",
                    "password": "abc123"
                },
                {
                    "_id": randomString(32),
                    "email": "gruppo1@email.com",
                    "name": "gruppo1", 
                    "password": "qazwsx123"
                }
            ],
            "requests": [],
            "offers": [],
            "services": [
                {"_id": 1, "name": "Idraulico"},
                {"_id": 2, "name": "Elettricista"},
                {"_id": 3, "name": "Gommista"}
            ]
        };
    }
}


// SELECT * FROM <collection>
// WHERE [<attribute> = <value>] <-- optional
// LIMIT 1
function db_find(collection, attribute, value) {
    if(!db.hasOwnProperty(collection)) {
        console.warn("undefined collection " + collection);
        return;
    }

    var coll = db[collection];

    var result = [];

    for(var i = 0; i < coll.length; i++) {
        var doc = coll[i];
        if(attribute === undefined) {
            result.push(doc);
        } else if(doc.hasOwnProperty(attribute)) {
            if(doc[attribute] === value) {
                result.push(doc);
            }
        }
    }

    return result;
}


// SELECT * FROM <collection>
// WHERE <attribute> = <value>
// LIMIT 1
function db_findOne(collection, attribute, value) {
    var result = db_find(collection, attribute, value);
    if(result.length == 0) {
        return null;
    }
    return result[0];
}


// INSERT INTO <collection> VALUES <doc>
function db_insert(collection, doc) {
    if(!db.hasOwnProperty(collection)) {
        console.warning("undefined collection" + collection);
        return;
    }

    doc["_id"] = randomString(32);

    db[collection].push(doc);

    return doc["_id"];
}


// UPDATE <collection>
// WHERE <attribute> = <value>
// SET <newAttribute> = <value>
function db_update(collection, attribute, value, newAttribute, newValue) {
    if(!db.hasOwnProperty(collection)) {
        console.warning("undefined collection " + collection);
        return;
    }

    var coll = db[collection];

    for(var i = 0; i < coll.length; i++) {
        var doc = coll[i];
        if(attribute === undefined) {
            doc[newAttribute] = newValue;
        } else if(doc.hasOwnProperty(attribute)) {
            if(doc[attribute] === value) {
                doc[newAttribute] = newValue;
            }
        }
    }
}


// DELETE FROM <collection>
// [WHERE <attribute> = <value>] <-- optional
function db_delete(collection, attribute, value) {
    // TODO
}

