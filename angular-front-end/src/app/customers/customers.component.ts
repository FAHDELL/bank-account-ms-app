import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css',
})
export class CustomersComponent implements OnInit {
  customer: any;
  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    this.http
      .get('http://localhost:8888/CUSTOMER-SERVICE/customers')
      .subscribe({
        next: (data) => {
          this.customer = data;
        },
        error: (err) => {
          console.log(err);
        },
      });
  }
}
