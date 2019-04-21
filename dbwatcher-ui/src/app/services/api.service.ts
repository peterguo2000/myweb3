import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as FileSaver from 'file-saver';

@Injectable({
  providedIn: 'root'
})
export class APIService {

  constructor(private http: HttpClient) { }
  baseUrl: String = 'http://localhost:8090/query/';

  downloadCSV(params: String) {
    this
      .http
      .post(`${this.baseUrl}`, params, {
        responseType: 'blob'
      })
      .subscribe(res => FileSaver.saveAs(res, 'queryResult.csv'));
  }
}
