export interface User {
}
export enum UserType {
    Guest  = "",
    Client = "C",
    Vendor = "F"
}
  
export interface User {
    type: UserType,
    email: string,
    password: string
}