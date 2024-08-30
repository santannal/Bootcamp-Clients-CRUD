import { Component, OnInit } from '@angular/core';
import { Client } from '../../interfaces/client';
import { ClientService } from '../../services/client.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent {

  // compaireGender: boolean = false;

  client: Client = {} as Client;
  deleteClient: Client = {} as Client;
  clients: Client[] = [];

  showForm: boolean = false;
  isEditing: boolean = false;

  constructor(private clientService: ClientService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.loadClients();
  }

  remove(modal: any, client: Client) {
    this.deleteClient = client;
    this.modalService.open(modal).result.then(
      (confirm) => {
        this.clientService.delete(client).subscribe({
          next: () => {
            this.clients = this.clients.filter(c => c.id !== client.id);
          }
        })
      }
    )
  }

  edit(client: Client) {
    this.client = client;
    this.showForm = true;
    this.isEditing = true;
  }

  create() {
    this.showForm = true;
  }

  saveClient(save: boolean) {
    if (save) {
      if (this.isEditing) {
        this.clientService.update(this.client).subscribe();
      } else {
        this.clientService.save(this.client).subscribe({
          next: data => {
            this.clients.push(data);
          }
        });
      }
    }
    this.client = {} as Client;
    this.showForm = false;
    this.isEditing = false;
  }

  loadClients() {
    this.clientService.getClients().subscribe({
      next: data => { this.clients = data }
    })
  }
}
