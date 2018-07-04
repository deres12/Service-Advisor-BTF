import { UserType } from "./user";

export interface SignupData {
    type: UserType,
    email: string,
    password: string,
    professione: {id:number},
    nome: string,
    indirizzo: string
}

export interface LoginData {
    email: string,
    pass: string
}
