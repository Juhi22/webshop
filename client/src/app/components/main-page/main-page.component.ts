import { Component, OnInit, AfterViewInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/api/product.service';
import { NgxMatMenuService } from 'ngx-mat-menu';
import { Router } from '@angular/router';
import { DatasService } from 'src/app/services/helpers/datas.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit, AfterViewInit {

  constructor(private http: HttpClient,
              private productServ: ProductService,
              private ngxMatMenuService: NgxMatMenuService,
              private router: Router,
              private datasService: DatasService) {
              ngxMatMenuService.changeMenu(true);
              ngxMatMenuService.selectMenu(0);
              }

    baseUrl: string = 'http://localhost:8050';

  products: Product[] = [];
  product = {} as Product;
  isSmall: boolean;
  productName: string;
  productPrice: string;

  ngOnInit() {
    this.getProducts();
  }

  ngAfterViewInit(): void {
   // const height = document.getElementById('cont').offsetHeight;
    const width = document.getElementById('cont').offsetWidth;

    // TODO: if small only show badges not all the events
    if (width <= 700) {
      console.log('small');
      this.isSmall = true;
    } else {
      this.isSmall = false;
    }

  }

  getProducts() {
    this.productServ.getAllProducts()
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

  viewProduct(product) {
    this.datasService.setUserId(product.id);
    this.router.navigate(['product']);
  }

}
