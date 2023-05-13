import { Injectable } from '@angular/core';

import { Record, AuthorInterface, Order } from '../common.models';

// import { Response, RequestOptions, 
// 	Headers, URLSearchParams } from '@angular/http';

import { Observable } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';


@Injectable()
export class RecordService {

	private readonly path = '/api/records';

	constructor(private http: HttpClient) { }

	getRecords(order?: Order, lowestPrice?: number, highestPrice?: number): Observable<Record[]> {
		let params: HttpParams = new HttpParams();
		if (+lowestPrice) {
			// HttpParams je imutabilna kolekcija!
			params = params.append('lowestPrice', lowestPrice.toString());
		}
		if (+highestPrice){
			params = params.append('highestPrice', highestPrice.toString());
		}
		if (order !== undefined) {
			params = params.append('ord', order.toString());
		}
		
		return this.http.get<Record[]>(this.path, {params});
	}

	getRecord(id: string): Observable<Record> {
		return this.http.get<Record>(`/api/records/${id}`);
	}

	saveRecord(newRecord: Record): Observable<Record> {
		let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
		// let options = new RequestOptions({ headers: headers });
		return this.http.post<Record>(this.path, JSON.stringify(newRecord), { headers });
	}

	deleteRecord(id: string): Observable<Record> {
		return this.http.delete<Record>(`${this.path}/${id}`);
	}
} 
