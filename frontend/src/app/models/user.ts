export enum UserType {
    Guest  = "",
    Client = "C",
    Vendor = "F"
}

export class User {
    type: UserType;
    email: string;
    password: string;
    nome: string;

    constructor() {
        this.type = UserType.Guest;
    }
}
