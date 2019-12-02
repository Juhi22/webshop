import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseUrlService } from '../helpers/base-url.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient,
              private baseUrlServ: BaseUrlService) { }

baseUrl:string = this.baseUrlServ.getBaseUrl();

  login(user) {
    return this.httpClient.post(this.baseUrl + '/user/login', user);
  }
}
