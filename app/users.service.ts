import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Users } from './users';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  //userURL: any = environment.userURL;


  constructor(public http: HttpClient) {

  }
  isLoggedIn(): boolean {
    console.log("login method"+localStorage.getItem('token'))
    return !!localStorage.getItem('token');
  }

  isAdminLoggedIn(): boolean {
    return !!localStorage.getItem('admin');
  }
  email(): string | null {
    return localStorage.getItem("email");
  }

  adminname(): string | null {
    return localStorage.getItem("email");
  }

  //Loading user Details from the backend
  loadUserDetails(): Observable<Users[]> {
    return this.http.get<Users[]>("http://localhost:9123/api/v1/user/displayall")
  }

  storeUserDetails(user: Users): Observable<string> {
    return this.http.post("http://localhost:9123/api/v1/user/register", user, { responseType: 'text' })
  }

  loginUserDetails(user: Users): Observable<string> {
    return this.http.post("http://localhost:9123/api/v1/user/login", user, { responseType: 'text' })
  }

  logoutUserDetails(email: string): Observable<string> {
    return this.http.get("http://localhost:9123/api/v1/user/logout/" + email, { responseType: 'text' })
  }

  deleteUserDetails(email: string): Observable<string> {
    return this.http.delete("http://localhost:9123/api/v1/user/deleteUser/" + email, { responseType: 'text' });
  }

  updateUserDetails(user: any): Observable<string> {
    return this.http.patch("http://localhost:9123/api/v1/user/updateUser", user, { responseType: 'text' })
  }

  loginUser(): Observable<any> {
    return this.http.get<any>("http://localhost:9123/api/v1/user/displayall");
  }

  getUser(email: string): Observable<Users> {
    return this.http.get<Users>("http://localhost:9123/api/v1/user/display/" + email);
  }
}
