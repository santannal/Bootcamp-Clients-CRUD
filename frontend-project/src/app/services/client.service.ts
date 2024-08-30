import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../interfaces/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>("http://localhost:8080/clients");
  }

  save(client: Client) {
    return this.http.post<Client>("http://localhost:8080/clients", client);
  }

  update(client: Client) {
    return this.http.put<Client>(`http://localhost:8080/clients/${client.id}`, client);
  }

  delete(client: Client) {
    return this.http.delete<void>(`http://localhost:8080/clients/${client.id}`);
  }
}
