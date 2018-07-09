export enum UserType {
    Guest  = "",
    Client = "C",
    Vendor = "F"
}

export class User {
    type: UserType;
    email: string;
    pass: string;
    nome: string;

    constructor() {
        this.type = UserType.Guest;
        this.email = "";
        this.pass = "";
        this.nome = "";
    }
}
