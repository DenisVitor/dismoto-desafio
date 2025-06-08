import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import {
  decimalOptionalValidator,
  decimalValidator,
} from './components/validators/validator';
import { IProduct } from './components/interfaces/product';
import { Modal } from './components/modal/modal';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.less',
  standalone: true,
  imports: [HttpClientModule, CommonModule, Modal, ReactiveFormsModule],
})
export class App {
  protected title = 'product-list';
  isModalOpen: boolean = false;
  isCreate: boolean = false;
  isEdit: boolean = false;
  isDelete: boolean = false;
  list: IProduct[] = [];
  form: FormGroup;
  formUpdate: FormGroup;
  productId: any;

  constructor(private http: HttpClient, private fb: FormBuilder) {
    this.getData();
    this.form = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', [decimalValidator]],
    });

    this.formUpdate = this.fb.group({
      name: [''],
      description: [''],
      price: ['', [decimalOptionalValidator]],
    });
  }

  getData() {
    this.http.get('http://localhost:8080/products').subscribe((data: any) => {
      this.list = data;
    });
  }

  submitData() {
    if (this.form.valid) {
      const valueToParse: number = this.form.value.price;
      this.form.value.price = parseFloat(valueToParse.toFixed(2));
      this.http
        .post('http://localhost:8080/products', this.form.value)
        .subscribe(() => {
          this.getData();
          this.form.reset();
          this.closeModal();
        });
    }
  }

  onUpdate() {
    const payload = Object.fromEntries(
      Object.entries(this.formUpdate.value).filter(
        ([_, v]) => v !== '' && v !== null
      )
    );
    this.http
      .patch(`http://localhost:8080/products/${this.productId}`, payload)
      .subscribe(() => {
        this.getData();
        this.formUpdate.reset();
        this.closeModal();
      });
  }

  onDelete() {
    this.http
      .delete(`http://localhost:8080/products/${this.productId}`)
      .subscribe(() => {
        this.getData();
        this.formUpdate.reset();
        this.closeModal();
      });
  }

  openCreateModal() {
    this.isModalOpen = true;
    this.isCreate = true;
  }

  openEditModal(id: number) {
    this.productId = id;
    this.isModalOpen = true;
    this.isEdit = true;
  }

  openDeleteModal(id: number) {
    this.productId = id;
    this.isModalOpen = true;
    this.isDelete = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.isCreate = false;
    this.isEdit = false;
    this.isDelete = false;
    this.form.reset();
  }
}
