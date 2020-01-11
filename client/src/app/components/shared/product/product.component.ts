import { Component, OnInit } from '@angular/core';
import { DatasService } from 'src/app/services/helpers/datas.service';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/api/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  userId: number;
  product: Product;
  constructor(private datasService: DatasService,
              private productService: ProductService
              ) { }

  ngOnInit() {
    this.userId = this.datasService.getUserId();
    this.productService.getOneProduct(this.userId).subscribe(
      (data: any) => {
        console.log(data);
        this.product = data;
      }
    );
  }

}
