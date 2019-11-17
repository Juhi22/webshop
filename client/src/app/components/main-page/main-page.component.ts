import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/api/product.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor(private http: HttpClient,
              private productServ: ProductService) {}

    baseUrl: string = 'http://192.168.1.4:8050';

  products: Product[] = [];
  product = {} as Product;

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.productServ.getProducts()
    .subscribe(data => this.products = data);
  }

  addProduct() {
    this.http.post<Product>(this.baseUrl + '/product/addProduct', this.product)
    .subscribe(data => this.getProducts()
    );
    this.getProducts();
    this.product.name = '';
    this.product.price = 0;
  }

  isEmpty() {
    if (this.products.length === 0) {
      return true;
    }
    return false;
  }

}
