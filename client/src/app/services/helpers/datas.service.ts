import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DatasService {

  userId: number;

  constructor() { }

  getUserId() {
    return this.userId;
  }

  setUserId(userId) {
    this.userId = userId;
  }
}
