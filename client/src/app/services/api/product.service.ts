import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from 'src/app/model/product';
import { BaseUrlService } from '../helpers/base-url.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient,
              private baseUrlServ: BaseUrlService,
              ) { }

    baseUrl: string = this.baseUrlServ.getBaseUrl();

  getProducts() {
    return this.httpClient.get<Product[]>(this.baseUrl + '/product/getAllProducts');
  }

  addProduct(product) {
    this.httpClient.post<Product>(this.baseUrl + '/product/addProduct', product);
  }
}
