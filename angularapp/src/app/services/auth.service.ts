import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<string | null>;
  public currentUser: Observable<string | null>;
  private baseUrl = "https://ide-bcefcbccbedfab314820188eabbabbffour.premiumproject.examly.io/proxy/8080/"; 
  private userRoleSubject = new BehaviorSubject<string>('');
  userRole$: Observable<string> = this.userRoleSubject.asObservable();
  private isAuthenticatedSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(this.isAuthenticated());
  isAuthenticated$ = this.isAuthenticatedSubject.asObservable();


  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<string | null>(
      localStorage.getItem('currentUser')
    );
    this.currentUser = this.currentUserSubject.asObservable();
  }


  register(username: string, password: string, role: string): Observable<any> {
    const body = { username, password, role };
    console.log(body);
    return this.http.post<any>(`${this.baseUrl}/user/register`, body);
  }


  login(username: string, password: string, role : string): Observable<any> {
    const loginData = { username, password };
    return this.http.post<any>(`${this.baseUrl}/user/login`, loginData).pipe(
        tap(response => {
          const role = response.role;
          this.userRoleSubject.next(role); 
          localStorage.setItem('role', role); 
        }),
        catchError(this.handleError<any>('login'))
      );
      
    }
  isLoggedIn(): boolean {
    console.log(localStorage.getItem('role'));
  return !!localStorage.getItem('role');
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('currentUser');
    localStorage.removeItem('role');
    this.currentUserSubject.next(null);
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem('role');
    console.log(token);

    return !!token; 
  }

  isAdmin(): boolean {
    const token = localStorage.getItem('role');
    console.log(token);
    
    if(token === 'ADMIN'){
      return true;
    
    }
    return false; 
  }

  isOrganizer(): boolean {
    const token = localStorage.getItem('role');
    if (token === 'ORGANIZER') {
      console.log("token:"+token);
      return true;
    }
    return false; 
  }

}