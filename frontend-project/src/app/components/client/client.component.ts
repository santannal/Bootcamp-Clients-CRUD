import { Component, EventEmitter, Input, Output, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Client } from '../../interfaces/client';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent {

  @Input()
  client: Client = {} as Client;

  @Output()
  saveEmitter = new EventEmitter();

  formGroupClient: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.formGroupClient = this.formBuilder.group({
      id: { value: null, disabled: true },
      name: ['', [Validators.required, Validators.minLength(5)]],
      salary: ['', [Validators.required, Validators.min(1)]],
      bonus: ['', [Validators.required, Validators.min(0), Validators.max(100)]],
      gender: ['1', Validators.required]
    });
  }

  ngOnChanges(): void {
    if (this.client.id) {
      this.formGroupClient.setValue(this.client);
    }
  }

  ngOnInit(): void {

  }

  save() {
    if (this.formGroupClient.valid) {
      Object.assign(this.client, this.formGroupClient.value);
      this.saveEmitter.emit(true);
    }
  }

  cancel() {
    this.saveEmitter.emit(false);
  }

  //TODO métodos para pegar os pfgAtributs

}
