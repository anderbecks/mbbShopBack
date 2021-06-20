import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product } from './product';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'malmoBrewBucketApp';
  public product: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.getProduct();
  }

  public getProduct(): void{
    this.productService.getProducts().subscribe(
      (Response: Product[])=> {
        this.product = Response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public quantity = "0";

  sum(val:string){
    let sum = document.getElementById("counter") as HTMLInputElement;
      let numSum: number;
    if(val==="min"){
      if(sum.value === '0' || sum.value === ''){
      
    } else{numSum = parseInt(sum.value) -1;
      this.quantity = numSum.toString();
      console.log(this.quantity)}
    } else{numSum = parseInt(sum.value) +1;
          this.quantity = numSum.toString();
          console.log(this.quantity)}
  } 
}
