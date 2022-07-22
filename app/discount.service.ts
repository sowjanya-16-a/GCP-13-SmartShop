import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Discount } from './discount';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  constructor(public http: HttpClient) { }

  loadDiscount():Observable<Discount[]>{
    return this.http.get<Discount[]>("http://localhost:9124/discount/discountName")
  }
  
  storeDiscountDetails(discount: Discount): Observable<string>{
    return this.http.post("http://localhost:9124/discount/add", discount,{ responseType: 'text' })
  }
  
}
