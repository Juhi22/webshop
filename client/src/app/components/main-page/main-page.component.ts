import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private http: HttpClient) {}

  //baseUrl: string = 'http://192.168.0.50:8050';
  baseUrl: string = 'http://192.168.1.4:8050';

  productName: string = '';
  productPrice: number = 0;
  products: Product[] = [];
  product: Product;

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    return this.http.get<Product[]>(this.baseUrl + '/product/getAllProducts')
    .subscribe(data => this.products = data);
  }

  addProduct() {
    this.product = {
      name: this.productName,
      price: this.productPrice
    };
    this.productName = '';
    this.productPrice = 0;
    this.http.post<Product>('http://192.168.0.50:8050/product/addProduct', this.product)
    .subscribe(data => this.getProducts());
    this.getProducts();
  }

  isEmpty() {
    if (this.products.length === 0) {
      return true;
    }
    return false;
  }

}
