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

module.exports = "<form (ngSubmit)=\"addRecord()\">\r\n\t\r\n\t<label for=\"input-title\">title: </label>\r\n\t\t<input name=\"input-title\" id=\"input-title\" [(ngModel)]=\"newRecord.title\"/><br/>\r\n\t\r\n\t<label for=\"input-author\">author: </label>\r\n\t\t<select name=\"input-author\" id=\"input-author\"  [(ngModel)]=\"newRecord.author\">\r\n\t\t  <option *ngFor=\"let a of authors\" [ngValue]=\"a\">{{a.name}}</option>\r\n\t\t</select><br/>\r\n\t\t<!-- <input name=\"input-author\" id=\"input-author\" [(ngModel)]=\"newRecord.author.id\"/><br/> -->\r\n\t\r\n\t<label for=\"input-image-url\">imageUrl: </label>\r\n\t\t<input name=\"input-image-url\" id=\"input-image-url\" [(ngModel)]=\"newRecord.imageUrl\"/><br/>\r\n\r\n\t<label for=\"input-price\">price: </label>\r\n\t\t<input name=\"input-price\" id=\"input-price\" [(ngModel)]=\"newRecord.price\"/><br/>\r\n\t\r\n\t<input type=\"submit\" value=\"save\"/>\r\n\r\n</form>\r\n"

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
/* harmony import */ var _common_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../common.models */ "./src/app/common.models.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");




var AddRecordComponent = /** @class */ (function () {
    function AddRecordComponent(http) {
        this.http = http;
        this.newRecordAdded = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.newRecord = new _common_models__WEBPACK_IMPORTED_MODULE_2__["Record"]({
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
        this.newRecord = new _common_models__WEBPACK_IMPORTED_MODULE_2__["Record"]({
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

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _record_details_record_details_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./record-details/record-details.component */ "./src/app/record-details/record-details.component.ts");
/* harmony import */ var _main_main_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./main/main.component */ "./src/app/main/main.component.ts");
/* harmony import */ var _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./page-not-found/page-not-found.component */ "./src/app/page-not-found/page-not-found.component.ts");






var routes = [
    { path: 'record/:id', component: _record_details_record_details_component__WEBPACK_IMPORTED_MODULE_3__["RecordDetailsComponent"] },
    { path: 'main', component: _main_main_component__WEBPACK_IMPORTED_MODULE_4__["MainComponent"] },
    { path: '', redirectTo: 'main', pathMatch: 'full' },
    { path: '**', component: _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_5__["PageNotFoundComponent"] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>\r\n  RecordStore\r\n</h1>\r\n\r\n<router-outlet></router-outlet>\r\n\r\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html")
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AppComponent);
    return AppComponent;
}());



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
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _record_record_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./record/record.component */ "./src/app/record/record.component.ts");
/* harmony import */ var _record_list_record_list_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./record-list/record-list.component */ "./src/app/record-list/record-list.component.ts");
/* harmony import */ var _add_record_add_record_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./add-record/add-record.component */ "./src/app/add-record/add-record.component.ts");
/* harmony import */ var _filter_records_filter_records_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./filter-records/filter-records.component */ "./src/app/filter-records/filter-records.component.ts");
/* harmony import */ var _sort_records_sort_records_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./sort-records/sort-records.component */ "./src/app/sort-records/sort-records.component.ts");
/* harmony import */ var _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./page-not-found/page-not-found.component */ "./src/app/page-not-found/page-not-found.component.ts");
/* harmony import */ var _main_main_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./main/main.component */ "./src/app/main/main.component.ts");
/* harmony import */ var _record_details_record_details_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./record-details/record-details.component */ "./src/app/record-details/record-details.component.ts");















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"],
                _record_record_component__WEBPACK_IMPORTED_MODULE_7__["RecordComponent"],
                _record_list_record_list_component__WEBPACK_IMPORTED_MODULE_8__["RecordListComponent"],
                _add_record_add_record_component__WEBPACK_IMPORTED_MODULE_9__["AddRecordComponent"],
                _filter_records_filter_records_component__WEBPACK_IMPORTED_MODULE_10__["FilterRecordsComponent"],
                _sort_records_sort_records_component__WEBPACK_IMPORTED_MODULE_11__["SortRecordsComponent"],
                _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_12__["PageNotFoundComponent"],
                _main_main_component__WEBPACK_IMPORTED_MODULE_13__["MainComponent"],
                _record_details_record_details_component__WEBPACK_IMPORTED_MODULE_14__["RecordDetailsComponent"]
            ],
            imports: [
                _app_routing_module__WEBPACK_IMPORTED_MODULE_5__["AppRoutingModule"],
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/common.models.ts":
/*!**********************************!*\
  !*** ./src/app/common.models.ts ***!
  \**********************************/
/*! exports provided: Record, Order */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Record", function() { return Record; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Order", function() { return Order; });
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

var Order;
(function (Order) {
    Order[Order["asc"] = 0] = "asc";
    Order[Order["desc"] = 1] = "desc";
})(Order || (Order = {}));


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

/***/ "./src/app/main/main.component.css":
/*!*****************************************!*\
  !*** ./src/app/main/main.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21haW4vbWFpbi5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/main/main.component.html":
/*!******************************************!*\
  !*** ./src/app/main/main.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-add-record (newRecordAdded)=\"save($event)\"></app-add-record>\r\n\r\n<br/>\r\n\r\n<app-filter-records (setPriceLimits)=\"filterRecords($event)\"></app-filter-records>\r\n\r\n<br/>\r\n\r\n<app-sort-records (setRecordOrder)=\"loadData($event)\"></app-sort-records>\r\n\r\n<br/>\r\n<app-record-list [records]=\"records\" (deleteRecordIndex)=\"delete($event)\"></app-record-list>\r\n"

/***/ }),

/***/ "./src/app/main/main.component.ts":
/*!****************************************!*\
  !*** ./src/app/main/main.component.ts ***!
  \****************************************/
/*! exports provided: MainComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MainComponent", function() { return MainComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _common_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../common.models */ "./src/app/common.models.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");




var MainComponent = /** @class */ (function () {
    function MainComponent(http) {
        this.http = http;
        this.orderTypes = _common_models__WEBPACK_IMPORTED_MODULE_2__["Order"];
        this.priceFilter = {
            lowest: 0,
            highest: 0
        };
        this.records = [];
        this.loadData();
    }
    MainComponent.prototype.ngOnInit = function () {
    };
    MainComponent.prototype.loadData = function (order) {
        var _this = this;
        var params = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"]();
        params = params.set('lowestPrice', this.priceFilter.lowest.toString());
        params = params.set('highestPrice', this.priceFilter.highest.toString());
        if (order !== undefined) {
            params = params.set('ord', order.toString());
        }
        this.http.get('/api/records', { params: params }).subscribe(
        //koristimo arrow funkciju da bismo imali leksicki
        //opseg this objekata
        function (res) {
            _this.records = res;
        });
    };
    MainComponent.prototype.save = function (newRecord) {
        var _this = this;
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({ 'Content-Type': 'application/json' });
        this.http.post('/api/records', JSON.stringify(newRecord), { headers: headers }).subscribe(function () {
            _this.loadData();
        });
    };
    MainComponent.prototype.delete = function (id) {
        var _this = this;
        this.http.delete('/api/records/' + id).subscribe(function () {
            _this.loadData();
        });
    };
    MainComponent.prototype.filterRecords = function (priceLimits) {
        this.priceFilter = priceLimits;
        this.loadData();
    };
    MainComponent.prototype.resetFilter = function () {
        this.priceFilter = { lowest: 0, highest: 0 };
    };
    MainComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-main',
            template: __webpack_require__(/*! ./main.component.html */ "./src/app/main/main.component.html"),
            styles: [__webpack_require__(/*! ./main.component.css */ "./src/app/main/main.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]])
    ], MainComponent);
    return MainComponent;
}());



/***/ }),

/***/ "./src/app/page-not-found/page-not-found.component.css":
/*!*************************************************************!*\
  !*** ./src/app/page-not-found/page-not-found.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhZ2Utbm90LWZvdW5kL3BhZ2Utbm90LWZvdW5kLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/page-not-found/page-not-found.component.html":
/*!**************************************************************!*\
  !*** ./src/app/page-not-found/page-not-found.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>\r\n  There is nothing here!\r\n</h1>\r\n"

/***/ }),

/***/ "./src/app/page-not-found/page-not-found.component.ts":
/*!************************************************************!*\
  !*** ./src/app/page-not-found/page-not-found.component.ts ***!
  \************************************************************/
/*! exports provided: PageNotFoundComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PageNotFoundComponent", function() { return PageNotFoundComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var PageNotFoundComponent = /** @class */ (function () {
    function PageNotFoundComponent() {
    }
    PageNotFoundComponent.prototype.ngOnInit = function () {
    };
    PageNotFoundComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-page-not-found',
            template: __webpack_require__(/*! ./page-not-found.component.html */ "./src/app/page-not-found/page-not-found.component.html"),
            styles: [__webpack_require__(/*! ./page-not-found.component.css */ "./src/app/page-not-found/page-not-found.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], PageNotFoundComponent);
    return PageNotFoundComponent;
}());



/***/ }),

/***/ "./src/app/record-details/record-details.component.css":
/*!*************************************************************!*\
  !*** ./src/app/record-details/record-details.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3JlY29yZC1kZXRhaWxzL3JlY29yZC1kZXRhaWxzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/record-details/record-details.component.html":
/*!**************************************************************!*\
  !*** ./src/app/record-details/record-details.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"isDataAvailable\">\r\n\t<h2>{{record.title}}</h2>\r\n\t<div>{{record.author.name}}</div>\r\n\t<div><img width=\"100\" height=\"100\" src=\"{{record.imageUrl}}\"></div>\r\n\t<div>{{record.price}}</div>\r\n\t<div *ngIf=\"record.styles.length!=0\">\r\n\tstyles:\r\n\t\t<ul>\r\n\t\t\t<li *ngFor=\"let style of record.styles\">\r\n\t\t\t\t{{style.name}}\r\n\t\t\t</li>\r\n\t\t</ul>\r\n\t</div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/record-details/record-details.component.ts":
/*!************************************************************!*\
  !*** ./src/app/record-details/record-details.component.ts ***!
  \************************************************************/
/*! exports provided: RecordDetailsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RecordDetailsComponent", function() { return RecordDetailsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");




var RecordDetailsComponent = /** @class */ (function () {
    function RecordDetailsComponent(route, http) {
        this.route = route;
        this.http = http;
    }
    RecordDetailsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.id = +params['id']; // (+) konvertuje string 'id' u broj
            //id postavljamo kao path parametar pomocu interpolacije stringa
            _this.http.get("/api/records/" + _this.id).subscribe(
            //koristimo arrow funkciju da bismo imali leksicki
            //opseg this objekata
            function (res) {
                _this.record = res;
                _this.isDataAvailable = true;
            });
        });
    };
    RecordDetailsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-record-details',
            template: __webpack_require__(/*! ./record-details.component.html */ "./src/app/record-details/record-details.component.html"),
            styles: [__webpack_require__(/*! ./record-details.component.css */ "./src/app/record-details/record-details.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"], _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]])
    ], RecordDetailsComponent);
    return RecordDetailsComponent;
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

module.exports = "<a [routerLink]=\"['/record',record.id]\">{{record.title}}</a>\r\n<div>{{record.author.name}}</div>\r\n<div>{{record.price}}</div>\r\n<button (click)=\"deleteRecord(record.id)\">remove</button>"

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
/* harmony import */ var _common_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../common.models */ "./src/app/common.models.ts");



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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _common_models__WEBPACK_IMPORTED_MODULE_2__["Record"])
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
/* harmony import */ var _common_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../common.models */ "./src/app/common.models.ts");



var SortRecordsComponent = /** @class */ (function () {
    function SortRecordsComponent() {
        this.setRecordOrder = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.orderTypes = _common_models__WEBPACK_IMPORTED_MODULE_2__["Order"];
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

module.exports = __webpack_require__(/*! C:\Users\eniko\Desktop\Downloads\Eniko-fajlok2\myFiles\materijal\54_Angular_rutiranje\primeri\primer1\record-store\client\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map