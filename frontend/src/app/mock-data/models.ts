import { UserType } from "../models/user";

export interface MockJob {
    id: number,
    name: string
}

export interface MockUser {
    id: number,
    type: UserType,
    email: string,
    password: string,
    job_id: number
}

export interface MockUserRequest {
    id: number,
    user_id: number,
    job_id: string,
    description: string,
    date: string,
    open: boolean
}

export interface MockRequestOffer {
    id: number,
    professional_id: number,
    request_id: number,
    price: number
}
