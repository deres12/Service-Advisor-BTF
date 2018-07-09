import { Injectable } from '@angular/core';
import { UserType } from '../models/user';
import { MockUser, MockUserRequest, MockRequestOffer, MockJob } from '../mock-data/models';
import { DEFAULT_JOBS } from './default-data';

@Injectable({
  providedIn: 'root'
})
export class TestDataService {
  private jobs: MockJob[];
  private users: MockUser[];
  private requests: MockUserRequest[];
  private offers: MockRequestOffer[];

  constructor() {
    this.jobs     = DEFAULT_JOBS;
    this.users    = [];
    this.requests = [];
    this.offers   = [];
  }

  showAllUsers() {
    console.log(this.users);
  }
  
  /* Jobs */
  /*==================================================*/
  getAllJobs(): MockJob[] {
    return this.jobs;
  }

  /* Users */
  /*==================================================*/
  getAllUsers(): MockUser[] {
    return this.users;
  }

  addUser(user: MockUser) {
    user.id = this.users.length+1;
    this.users.push(user);
  }

  getUserByEmail(email: string): MockUser {
    for(let u of this.users) {
      if(u.email == email) {
        return u;
      }
    }
    return null;
  }

  getUsersByType(type: UserType): MockUser[] {
    let result: MockUser[] = [];
    for(let u of this.users) {
      if(u.type == type) {
        result.push(u);
      }
    }
    return result;
  }
  
  getUsersByJob(job: number): MockUser[] {
    let result: MockUser[] = [];
    for(let u of this.users) {
      if(u.job_id == job) {
        result.push(u);
      }
    }
    return result;
  }
  
  /* User Requests */
  /*==================================================*/
  getAllRequests(): MockUserRequest[] {
    return this.requests;
  }

  addUserRequest(req: MockUserRequest) {
    req.id = this.requests.length+1;
    this.requests.push(req);
  }

  getRequestsByUser(id: number): MockUserRequest[] {
    let result: MockUserRequest[] = [];
    for(let req of this.requests) {
      if(req.user_id == id) {
        result.push(req);
      }
    }
    return result;
  }
  
  getRequestsByJob(jobId: string): MockUserRequest[] {
    let result: MockUserRequest[] = [];
    for(let req of this.requests) {
      if(req.job_id == jobId) {
        result.push(req);
      }
    }
    return result;
  }

  /* Requests Offers */
  /*==================================================*/
  getAllOffers(): MockRequestOffer[] {
    return this.offers;
  }

  addOffer(offer: MockRequestOffer) {
    offer.id = this.offers.length+1;
    this.offers.push(offer);
  }

  getOffersByRequest(requestId: number): MockRequestOffer[] {
    let result: MockRequestOffer[] = [];
    for(let off of this.offers) {
      if(off.request_id == requestId) {
        result.push(off);
      }
    }
    return result;
  }

  getRequestPriceRange(requestId: number) {
    let offers = this.getOffersByRequest(requestId);
    let range = {min: 0, max: 0};
    if(offers.length > 0) {
      range.min = range.max = offers[0].price;
    }
    for(let off of offers) {
      if(range.min > off.price) {
        range.min = off.price;
      }
      if(range.max < off.price) {
        range.max = off.price;
      }
    }
    return range;
  }
  
  getOffersByProfessional(professionalId: number): MockRequestOffer[] {
    let result: MockRequestOffer[] = [];
    for(let off of this.offers) {
      if(off.professional_id == professionalId) {
        result.push(off);
      }
    }
    return result;
  }
}
