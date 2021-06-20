import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs'
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(`${this.apiServerUrl}/product/all`)
    }

    public addProducts(product: Product): Observable<Product> {
        return this.http.post<Product>(`${this.apiServerUrl}/product/add`, product)
    }

    public updateProducts(product: Product): Observable<Product> {
        return this.http.put<Product>(`${this.apiServerUrl}/product/update`, product)
    }

    public deleteProducts(productId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/product/delete/${productId}`)
    }
}