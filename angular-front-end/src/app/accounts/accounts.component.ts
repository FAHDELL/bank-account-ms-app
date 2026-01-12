import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css',
})
export class AccountsComponent implements OnInit {
  account: any;
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://localhost:8888/ACCOUNT-SERVICE/accounts').subscribe({
      next: (data) => {
        this.account = data;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
