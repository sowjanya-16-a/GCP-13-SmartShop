import { Component, OnInit } from '@angular/core';
import { DiscountService } from '../discount.service';
import { NgForm } from '@angular/forms';
import { Discount } from '../discount';

@Component({
  selector: 'app-discount',
  templateUrl: './discount.component.html',
  styleUrls: ['./discount.component.css']
})
export class DiscountComponent implements OnInit {

  coupon : string;
  storeMsg: string="";
  constructor(public disc: DiscountService) { }

  ngOnInit(): void {

  }
  storeDiscount(discountRef: NgForm) {
    console.log(discountRef)
    this.disc.storeDiscountDetails(discountRef.value).
      subscribe(res => this.storeMsg = res);
  }

  
}
