(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/add-record/add-record.component.css":
/*!*****************************************************!*\
  !*** ./src/app/add-record/add-record.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FkZC1yZWNvcmQvYWRkLXJlY29yZC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/add-record/add-record.component.html":
/*!******************************************************!*\
  !*** ./src/app/add-record/add-record.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form (ngSubmit)=\"addRecord()\">\r\n\t\r\n\t<label for=\"input-title\">title: </label>\r\n\t\t<input name=\"input-title\" id=\"input-title\" [(ngModel)]=\"newRecord.title\"/><br/>\r\n\t\r\n\t<label for=\"input-author\">author: </label>\r\n\t\t<select name=\"input-author\" id=\"input-author\"  [(ngModel)]=\"newRecord.author\">\r\n\t\t  <option *ngFor=\"let a of authors\" [ngValue]=\"a\">{{a.name}}</option>\r\n\t\t</select>\r\n\t\t<!-- <input name=\"input-author\" id=\"input-author\" [(ngModel)]=\"newRecord.author.id\"/><br/> -->\r\n\t\r\n\t<label for=\"input-image-url\">imageUrl: </label>\r\n\t\t<input name=\"input-image-url\" id=\"input-image-url\" [(ngModel)]=\"newRecord.imageUrl\"/><br/>\r\n\r\n\t<label for=\"input-price\">price: </label>\r\n\t\t<input name=\"input-price\" id=\"input-price\" [(ngModel)]=\"newRecord.price\"/><br/>\r\n\t\r\n\t<input type=\"submit\" value=\"save\"/>\r\n\r\n</form>\r\n"

/***/ }),

/***/ "./src/app/add-record/add-record.component.ts":
/*!****************************************************!*\
  !*** ./src/app/add-record/add-record.component.ts ***!
  \****************************************************/
/*! exports provided: AddRecordComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddRecordComponent", function() { return AddRecordComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _record_model__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../record.model */ "./src/app/record.model.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");




var AddRecordComponent = /** @class */ (function () {
    function AddRecordComponent(http) {
        this.http = http;
        this.newRecordAdded = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.authors = [];
        this.newRecord = new _record_model__WEBPACK_IMPORTED_MODULE_2__["Record"]({
            title: '',
            author: {},
            imageUrl: '',
            styles: [],
            price: 0
        });
        this.JSON = JSON;
    }
    AddRecordComponent.prototype.ngOnInit = function () {
        this.loadData();
    };
    AddRecordComponent.prototype.loadData = function () {
        var _this = this;
        this.http.get('/api/authors').subscribe(function (res) {
            _this.authors = res;
        });
    };
    AddRecordComponent.prototype.addRecord = function () {
        this.newRecordAdded.next(this.newRecord);
        this.newRecord = new _record_model__WEBPACK_IMPORTED_MODULE_2__["Record"]({
            title: '',
            author: {},
            imageUrl: '',
            styles: [],
            price: 0
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"])
    ], AddRecordComponent.prototype, "newRecordAdded", void 0);
    AddRecordComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-add-record',
            template: __webpack_require__(/*! ./add-record.component.html */ "./src/app/add-record/add-record.component.html"),
            styles: [__webpack_require__(/*! ./add-record.component.css */ "./src/app/add-record/add-record.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]])
    ], AddRecordComponent);
    return AddRecordComponent;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>\r\n  RecordStore\r\n</h1>\r\n\r\n<app-add-record (newRecordAdded)=\"save($event)\"></app-add-record>\r\n\r\n<br/>\r\n\r\n<app-filter-records (setPriceLimits)=\"filterRecords($event)\"></app-filter-records>\r\n\r\n<br/>\r\n\r\n<app-sort-records (setRecordOrder)=\"loadData($event)\"></app-sort-records>\r\n\r\n<br/>\r\n<app-record-list [records]=\"records\" (deleteRecordIndex)=\"delete($event)\"></app-record-list>\r\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent, Order */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Order", function() { return Order; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var AppComponent = /** @class */ (function () {
    function AppComponent(http) {
        this.http = http;
        this.orderTypes = Order;
        this.priceFilter = {
            lowest: 0,
            highest: 0
        };
        this.records = [];
        this.loadData();
    }
    AppComponent.prototype.loadData = function (order) {
        var _this = this;
        var params = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"]();
        params.set('lowestPrice', this.priceFilter.lowest.toString());
        params.set('highestPrice', this.priceFilter.highest.toString());
        if (order !== undefined) {
            params.set('ord', order.toString());
        }
        this.http.get('/api/records', { params: params }).subscribe(
        //koristimo arrow funkciju da bismo imali leksicki
        //opseg this objekata
        function (res) {
            _this.records = res;
        });
    };
    AppComponent.prototype.save = function (newRecord) {
        var _this = this;
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({ 'Content-Type': 'application/json' });
        this.http.post('/api/records', JSON.stringify(newRecord), { headers: headers }).subscribe(function (res) {
            _this.loadData();
        });
    };
    AppComponent.prototype.delete = function (id) {
        var _this = this;
        this.http.delete('/api/records/' + id).subscribe(function (res) {
            _this.loadData();
        });
    };
    AppComponent.prototype.filterRecords = function (priceLimits) {
        this.priceFilter = priceLimits;
        this.loadData();
    };
    AppComponent.prototype.resetFilter = function () {
        this.priceFilter = { lowest: 0, highest: 0 };
    };
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html")
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], AppComponent);
    return AppComponent;
}());

var Order;
(function (Order) {
    Order[Order["asc"] = 0] = "asc";
    Order[Order["desc"] = 1] = "desc";
})(Order || (Order = {}));


/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _record_record_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./record/record.component */ "./src/app/record/record.component.ts");
/* harmony import */ var _record_list_record_list_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./record-list/record-list.component */ "./src/app/record-list/record-list.component.ts");
/* harmony import */ var _add_record_add_record_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./add-record/add-record.component */ "./src/app/add-record/add-record.component.ts");
/* harmony import */ var _filter_records_filter_records_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./filter-records/filter-records.component */ "./src/app/filter-records/filter-records.component.ts");
/* harmony import */ var _sort_records_sort_records_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./sort-records/sort-records.component */ "./src/app/sort-records/sort-records.component.ts");











var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"],
                _record_record_component__WEBPACK_IMPORTED_MODULE_6__["RecordComponent"],
                _record_list_record_list_component__WEBPACK_IMPORTED_MODULE_7__["RecordListComponent"],
                _add_record_add_record_component__WEBPACK_IMPORTED_MODULE_8__["AddRecordComponent"],
                _filter_records_filter_records_component__WEBPACK_IMPORTED_MODULE_9__["FilterRecordsComponent"],
                _sort_records_sort_records_component__WEBPACK_IMPORTED_MODULE_10__["SortRecordsComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/filter-records/filter-records.component.css":
/*!*************************************************************!*\
  !*** ./src/app/filter-records/filter-records.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2ZpbHRlci1yZWNvcmRzL2ZpbHRlci1yZWNvcmRzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/filter-records/filter-records.component.html":
/*!**************************************************************!*\
  !*** ./src/app/filter-records/filter-records.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n\t<label for=\"input-price-lowest\">from: </label>\r\n\t\t<input name=\"input-price-lowest\" id=\"input-price-lowest\" [(ngModel)]=\"priceLimits.lowest\"/><br/>\t\r\n\r\n\t<label for=\"input-price-highest\">to: </label>\r\n\t\t<input name=\"input-price-highest\" id=\"input-price-highest\" [(ngModel)]=\"priceLimits.highest\"/><br/>\t\r\n\r\n\t<button (click)=\"filterRecords()\">filter</button>\r\n\t<button (click)=\"resetFilter()\">reset</button>\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/filter-records/filter-records.component.ts":
/*!************************************************************!*\
  !*** ./src/app/filter-records/filter-records.component.ts ***!
  \************************************************************/
/*! exports provided: FilterRecordsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilterRecordsComponent", function() { return FilterRecordsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FilterRecordsComponent = /** @class */ (function () {
    function FilterRecordsComponent() {
        this.setPriceLimits = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.JSON = JSON;
        this.priceLimits = {
            lowest: 0,
            highest: 0
        };
    }
    FilterRecordsComponent.prototype.ngOnInit = function () {
    };
    FilterRecordsComponent.prototype.filterRecords = function () {
        this.setPriceLimits.next(this.priceLimits);
    };
    FilterRecordsComponent.prototype.resetFilter = function () {
        this.setPriceLimits.next({
            lowest: 0,
            highest: 0
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"])
    ], FilterRecordsComponent.prototype, "setPriceLimits", void 0);
    FilterRecordsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-filter-records',
            template: __webpack_require__(/*! ./filter-records.component.html */ "./src/app/filter-records/filter-records.component.html"),
            styles: [__webpack_require__(/*! ./filter-records.component.css */ "./src/app/filter-records/filter-records.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FilterRecordsComponent);
    return FilterRecordsComponent;
}());



/***/ }),

/***/ "./src/app/record-list/record-list.component.css":
/*!*******************************************************!*\
  !*** ./src/app/record-list/record-list.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3JlY29yZC1saXN0L3JlY29yZC1saXN0LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/record-list/record-list.component.html":
/*!********************************************************!*\
  !*** ./src/app/record-list/record-list.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n\t<h1>Records</h1>\r\n\t<ul>\r\n\t\t<li *ngFor=\"let record of records; let i = index\">\r\n\t\t\t<app-record [record]=\"record\" [index]=\"i\" (deleteRecordIndex)=\"delete($event)\"></app-record>\r\n\t\t</li>\r\n\t</ul>\r\n</div>"

/***/ }),

/***/ "./src/app/record-list/record-list.component.ts":
/*!******************************************************!*\
  !*** ./src/app/record-list/record-list.component.ts ***!
  \******************************************************/
/*! exports provided: RecordListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RecordListComponent", function() { return RecordListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var RecordListComponent = /** @class */ (function () {
    function RecordListComponent() {
        this.deleteRecordIndex = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    RecordListComponent.prototype.ngOnInit = function () {
    };
    RecordListComponent.prototype.delete = function (index) {
        this.deleteRecordIndex.next(index);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], RecordListComponent.prototype, "records", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"])
    ], RecordListComponent.prototype, "deleteRecordIndex", void 0);
    RecordListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-record-list',
            template: __webpack_require__(/*! ./record-list.component.html */ "./src/app/record-list/record-list.component.html"),
            styles: [__webpack_require__(/*! ./record-list.component.css */ "./src/app/record-list/record-list.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], RecordListComponent);
    return RecordListComponent;
}());



/***/ }),

/***/ "./src/app/record.model.ts":
/*!*********************************!*\
  !*** ./src/app/record.model.ts ***!
  \*********************************/
/*! exports provided: Record */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Record", function() { return Record; });
var Record = /** @class */ (function () {
    function Record(recordCfg) {
        this.id = recordCfg.id;
        this.title = recordCfg.title;
        this.imageUrl = recordCfg.imageUrl;
        this.styles = recordCfg.styles;
        this.author = recordCfg.author;
        this.price = recordCfg.price;
    }
    return Record;
}());



/***/ }),

/***/ "./src/app/record/record.component.css":
/*!*********************************************!*\
  !*** ./src/app/record/record.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3JlY29yZC9yZWNvcmQuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/record/record.component.html":
/*!**********************************************!*\
  !*** ./src/app/record/record.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h2>{{record.title}}</h2>\r\n<div>{{record.author.name}}</div>\r\n<div><img width=\"100\" height=\"100\" src=\"{{record.imageUrl}}\"></div>\r\n<div>{{record.price}}</div>\r\n<div *ngIf=\"record.styles.length!=0\">\r\nstyles:\r\n\t<ul>\r\n\t\t<li *ngFor=\"let style of record.styles\">\r\n\t\t\t{{style.name}}\r\n\t\t</li>\r\n\t</ul>\r\n</div>\r\n<button (click)=\"deleteRecord(record.id)\">remove</button>"

/***/ }),

/***/ "./src/app/record/record.component.ts":
/*!********************************************!*\
  !*** ./src/app/record/record.component.ts ***!
  \********************************************/
/*! exports provided: RecordComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RecordComponent", function() { return RecordComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _record_model__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../record.model */ "./src/app/record.model.ts");



var RecordComponent = /** @class */ (function () {
    function RecordComponent() {
        this.deleteRecordIndex = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    RecordComponent.prototype.ngOnInit = function () {
    };
    RecordComponent.prototype.deleteRecord = function (id) {
        this.deleteRecordIndex.next(id);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _record_model__WEBPACK_IMPORTED_MODULE_2__["Record"])
    ], RecordComponent.prototype, "record", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], RecordComponent.prototype, "index", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"])
    ], RecordComponent.prototype, "deleteRecordIndex", void 0);
    RecordComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-record',
            template: __webpack_require__(/*! ./record.component.html */ "./src/app/record/record.component.html"),
            styles: [__webpack_require__(/*! ./record.component.css */ "./src/app/record/record.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], RecordComponent);
    return RecordComponent;
}());



/***/ }),

/***/ "./src/app/sort-records/sort-records.component.css":
/*!*********************************************************!*\
  !*** ./src/app/sort-records/sort-records.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NvcnQtcmVjb3Jkcy9zb3J0LXJlY29yZHMuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/sort-records/sort-records.component.html":
/*!**********************************************************!*\
  !*** ./src/app/sort-records/sort-records.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n\t<button (click)=\"sort(orderTypes.asc)\">sort by price asc</button>\r\n\t<button (click)=\"sort(orderTypes.desc)\">sort by price desc</button>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/sort-records/sort-records.component.ts":
/*!********************************************************!*\
  !*** ./src/app/sort-records/sort-records.component.ts ***!
  \********************************************************/
/*! exports provided: SortRecordsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SortRecordsComponent", function() { return SortRecordsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../app.component */ "./src/app/app.component.ts");



var SortRecordsComponent = /** @class */ (function () {
    function SortRecordsComponent() {
        this.setRecordOrder = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.orderTypes = _app_component__WEBPACK_IMPORTED_MODULE_2__["Order"];
    }
    SortRecordsComponent.prototype.ngOnInit = function () {
    };
    SortRecordsComponent.prototype.sort = function (recordOrder) {
        this.setRecordOrder.next(recordOrder);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"])
    ], SortRecordsComponent.prototype, "setRecordOrder", void 0);
    SortRecordsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-sort-records',
            template: __webpack_require__(/*! ./sort-records.component.html */ "./src/app/sort-records/sort-records.component.html"),
            styles: [__webpack_require__(/*! ./sort-records.component.css */ "./src/app/sort-records/sort-records.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], SortRecordsComponent);
    return SortRecordsComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\WP\Goran Stetin\VP04_2018\53_Angular_REST\primeri\record-store\client\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map