export interface User {
}
export enum UserType {
    Guest  = "",
    Client = "C",
    Vendor = "F"
}
  
export interface ProfileInfo {
    name: string,
    type: UserType
    /*...*/
}