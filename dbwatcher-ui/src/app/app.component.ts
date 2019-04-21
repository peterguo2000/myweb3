import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { APIService } from './services/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
//  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dbwatcher-ui';

  constructor(private apiService: APIService) { }

  onFormSubmit(userForm: NgForm) {
    this.apiService.downloadCSV(userForm.value);
  }

  resetUserForm(userForm: NgForm) {
    userForm.resetForm();
  }
}
