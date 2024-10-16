import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  helloText: string = "";
  title = 'frontend';
  constructor(private oauthService: OAuthService,
              private httpClient: HttpClient
  ) {}
  logout() {
    this.oauthService.logOut()
  }
  getGreeting(){
    this.httpClient.get<{message: string}> ("http://localhost:8080/hello",
      {headers: {
        Authorization: `Bearer ${this.oauthService.getAccessToken()}`
      }
    }).subscribe(response => { 
      this.helloText = response.message;
    }
    )
    }

}
