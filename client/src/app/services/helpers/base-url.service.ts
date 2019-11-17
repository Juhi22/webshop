import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BaseUrlService {

  constructor() { }

  //baseUrl: string = 'http://192.168.0.50:8050';
  baserUrl: string = 'http://192.168.1.4:8050';

  getBaseUrl() {
    return this.baserUrl;
  }
}
