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

module.exports = "<div>\n\t<form  class=\"form-horizontal\" (ngSubmit)=\"addRecord()\">\n\t\t<div class=\"form-group\">\n\t\t\t<label class=\"control-label col-sm-1\" for=\"input-title\">title: </label>\n\t\t\t<div class=\"col-sm-11\">\n\t\t\t\t<input class=\"form-control\" name=\"input-title\" id=\"input-title\" [(ngModel)]=\"newRecord.title\"/>\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"form-group\">\n\t\t\t<label class=\"control-label col-sm-1\" for=\"input-author\">author: </label>\n\t\t\t<div class=\"col-sm-11\">\n\t\t\t\t<select class=\"form-control\" name=\"input-author\" id=\"input-author\"  [(ngModel)]=\"newRecord.author\">\n\t\t\t\t\t<option *ngFor=\"let a of authors\" [ngValue]=\"a\">{{a.name}}</option>\n\t\t\t\t</select>\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div class=\"form-group\">\n\t\t\t<label class=\"control-label col-sm-1\" for=\"input-image-url\">imageUrl: </label>\n\t\t\t<div class=\"col-sm-11\">\n\t\t\t\t<input class=\"form-control\" name=\"input-image-url\" id=\"input-image-url\" [(ngModel)]=\"newRecord.imageUrl\"/>\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div class=\"form-group\">\n\t\t\t<label class=\"control-label col-sm-1\" for=\"input-price\">price: </label>\n\t\t\t<div class=\"col-sm-11\">\n\t\t\t\t<input class=\"form-control\" name=\"input-price\" id=\"input-price\" [(ngModel)]=\"newRecord.price\"/>\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div class=\"form-group\">\n\t\t\t<input class=\"btn btn-primary\" type=\"submit\" value=\"save\"/>\n\t\t</div>\n\t</form>\n</div>"

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
/* harmony import */ var _author_service_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../author-service.service */ "./src/app/author-service.service.ts");




var AddRecordComponent = /** @class */ (function () {
    function AddRecordComponent(authorService) {
        this.authorService = authorService;
        this.newRecordAdded = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.newRecord = new _common_models__WEBPACK_IMPORTED_MODULE_2__["Record"]({
            title: '',
            author: {},
            imageUrl: '',
            styles: [],
            price: 0
        });
    }
    AddRecordComponent.prototype.ngOnInit = function () {
        this.loadData();
    };
    AddRecordComponent.prototype.loadData = function () {
        var _this = this;
        this.authorService.getAuthors()
            .subscribe(function (authors) {
            _this.authors = authors;
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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_author_service_service__WEBPACK_IMPORTED_MODULE_3__["AuthorServiceService"]])
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
/* harmony import */ var _security_can_activate_auth_guard__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./security/can-activate-auth.guard */ "./src/app/security/can-activate-auth.guard.ts");
/* harmony import */ var _main_main_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./main/main.component */ "./src/app/main/main.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./page-not-found/page-not-found.component */ "./src/app/page-not-found/page-not-found.component.ts");








var routes = [
    { path: 'record/:id', component: _record_details_record_details_component__WEBPACK_IMPORTED_MODULE_3__["RecordDetailsComponent"], canActivate: [_security_can_activate_auth_guard__WEBPACK_IMPORTED_MODULE_4__["CanActivateAuthGuard"]] },
    { path: 'main', component: _main_main_component__WEBPACK_IMPORTED_MODULE_5__["MainComponent"], canActivate: [_security_can_activate_auth_guard__WEBPACK_IMPORTED_MODULE_4__["CanActivateAuthGuard"]] },
    { path: 'login', component: _login_login_component__WEBPACK_IMPORTED_MODULE_6__["LoginComponent"] },
    { path: '', redirectTo: 'main', pathMatch: 'full' },
    { path: '**', component: _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_7__["PageNotFoundComponent"] }
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

module.exports = "<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n\t<div class=\"container\">\n\t\t<div class=\"navbar-header\">\n\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n\t\t\t\t<span class=\"sr-only\">Toggle navigation</span>\n\t\t\t\t<span class=\"icon-bar\"></span>\n\t\t\t\t<span class=\"icon-bar\"></span>\n\t\t\t\t<span class=\"icon-bar\"></span>\n\t\t\t</button>\n\t\t\t<a class=\"navbar-brand\" href=\"#\">RecordStore</a>\n\t\t</div>\n\t\t<div id=\"navbar\" class=\"navbar-collapse collapse\">\n\t\t\t<ul class=\"nav navbar-nav\">\n\t\t\t\t<li class=\"active\"><a href=\"#\">Home</a></li>\n\t\t\t\t<li><a href=\"#about\">About</a></li>\n\t\t\t\t<li><a href=\"#contact\">Contact</a></li>\n\t\t\t</ul>\n\t\t\t<ul class=\"nav navbar-nav pull-right\">\n\t\t\t\t<li *ngIf=\"isLoggedIn()\"><a (click)=\"logout()\">Logout</a></li>\n\t\t\t</ul>\n\t\t</div>\n\t</div>\n</nav>\n<div class=\"container\" role=\"main\">\n\t\n\t<div class=\"jumbotron\">\n\t\t<h1>RecordStore</h1>\n\t\t<p>An example of Angular application styled with Bootstrap.</p>\n\t</div>\n\n\t<router-outlet></router-outlet>\n\n</div>"

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
/* harmony import */ var _security_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./security/authentication.service */ "./src/app/security/authentication.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");




var AppComponent = /** @class */ (function () {
    function AppComponent(authenticationService, router) {
        this.authenticationService = authenticationService;
        this.router = router;
    }
    AppComponent.prototype.logout = function () {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    };
    AppComponent.prototype.isLoggedIn = function () {
        return this.authenticationService.isLoggedIn();
    };
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html")
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_security_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
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
/* harmony import */ var _main_record_service__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./main/record.service */ "./src/app/main/record.service.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _security_authentication_service__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./security/authentication.service */ "./src/app/security/authentication.service.ts");
/* harmony import */ var _security_can_activate_auth_guard__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./security/can-activate-auth.guard */ "./src/app/security/can-activate-auth.guard.ts");
/* harmony import */ var _security_token_interceptor_service__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./security/token-interceptor.service */ "./src/app/security/token-interceptor.service.ts");
/* harmony import */ var _security_jwt_utils_service__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./security/jwt-utils.service */ "./src/app/security/jwt-utils.service.ts");
/* harmony import */ var _author_service_service__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./author-service.service */ "./src/app/author-service.service.ts");























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
                _record_details_record_details_component__WEBPACK_IMPORTED_MODULE_14__["RecordDetailsComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_16__["LoginComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_5__["AppRoutingModule"]
            ],
            providers: [
                {
                    provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HTTP_INTERCEPTORS"],
                    useClass: _security_token_interceptor_service__WEBPACK_IMPORTED_MODULE_19__["TokenInterceptorService"],
                    multi: true
                },
                _main_record_service__WEBPACK_IMPORTED_MODULE_15__["RecordService"],
                _author_service_service__WEBPACK_IMPORTED_MODULE_21__["AuthorServiceService"],
                _security_authentication_service__WEBPACK_IMPORTED_MODULE_17__["AuthenticationService"],
                _security_can_activate_auth_guard__WEBPACK_IMPORTED_MODULE_18__["CanActivateAuthGuard"],
                _security_jwt_utils_service__WEBPACK_IMPORTED_MODULE_20__["JwtUtilsService"]
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/author-service.service.ts":
/*!*******************************************!*\
  !*** ./src/app/author-service.service.ts ***!
  \*******************************************/
/*! exports provided: AuthorServiceService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthorServiceService", function() { return AuthorServiceService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var AuthorServiceService = /** @class */ (function () {
    function AuthorServiceService(http) {
        this.http = http;
    }
    AuthorServiceService.prototype.getAuthors = function () {
        return this.http.get('/api/authors');
    };
    AuthorServiceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], AuthorServiceService);
    return AuthorServiceService;
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
    function Record(spec) {
        this.id = spec.id;
        this.title = spec.title;
        this.imageUrl = spec.imageUrl;
        this.styles = spec.styles;
        this.author = spec.author;
        this.price = spec.price;
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

module.exports = "<div>\n\t<form class=\"form-inline\">\n\t\t<div class=\"form-group\">\n\t\t\t<label for=\"input-price-lowest\">from: </label>\n\t\t\t<input class=\"form-control\" name=\"input-price-lowest\" id=\"input-price-lowest\" [(ngModel)]=\"priceLimits.lowest\"/>\t\n\t\t</div>\n\n\t\t<div class=\"form-group\">\n\t\t\t<label for=\"input-price-highest\">to: </label>\n\t\t\t<input class=\"form-control\" name=\"input-price-highest\" id=\"input-price-highest\" [(ngModel)]=\"priceLimits.highest\"/>\t\n\t\t</div>\n\n\t\t<div class=\"btn-group\">\n\t\t\t<button class=\"btn btn-primary\" (click)=\"filterRecords()\">filter</button>\n\t\t\t<button class=\"btn btn-warning\" (click)=\"resetFilter()\">reset</button>\n\t\t</div>\n\t</form>\n</div>"

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

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form class=\"form-signin\" (ngSubmit)=\"login()\">\n  <h2 class=\"form-signin-heading\">Please sign in</h2>\n  <label for=\"username\" class=\"sr-only\">Username</label>\n  <input type=\"text\" id=\"username\" class=\"form-control\" name=\"username\" [(ngModel)]=\"user.username\" placeholder=\"Username\" required autofocus>\n  <label for=\"inputPassword\" class=\"sr-only\">Password</label>\n  <input type=\"password\" id=\"inputPassword\" class=\"form-control\" name=\"username\" [(ngModel)]=\"user.password\" placeholder=\"Password\" required>\n  <button class=\"btn btn-primary btn-block\" type=\"submit\">Sign in</button>\n</form>\n<div *ngIf=wrongUsernameOrPass class=\"alert alert-warning box-msg\" role=\"alert\">\n  Wrong username or password.\n</div>"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _security_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../security/authentication.service */ "./src/app/security/authentication.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");




var LoginComponent = /** @class */ (function () {
    function LoginComponent(authenticationService, router) {
        this.authenticationService = authenticationService;
        this.router = router;
        this.user = {};
        this.wrongUsernameOrPass = false;
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.authenticationService.login(this.user.username, this.user.password).subscribe(function (loggedIn) {
            if (loggedIn) {
                _this.router.navigate(['/main']);
            }
        });
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            encapsulation: _angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewEncapsulation"].None,
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_security_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], LoginComponent);
    return LoginComponent;
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

module.exports = "<div class=\"row\">\n\t<app-add-record (newRecordAdded)=\"save($event)\"></app-add-record>\n\n\t<br/>\n\n\t<app-filter-records (setPriceLimits)=\"filterRecords($event)\"></app-filter-records>\n\n\t<br/>\n\n\t<app-sort-records (setRecordOrder)=\"loadData($event)\"></app-sort-records>\n\n\t<br/>\n\t<app-record-list [records]=\"records\" (deleteRecordIndex)=\"delete($event)\"></app-record-list>\n</div>\n\n"

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
/* harmony import */ var _main_record_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../main/record.service */ "./src/app/main/record.service.ts");




var MainComponent = /** @class */ (function () {
    function MainComponent(recordService) {
        this.recordService = recordService;
        this.orderTypes = _common_models__WEBPACK_IMPORTED_MODULE_2__["Order"];
        recordService.getRecords();
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
        this.recordService.
            getRecords(order, this.priceFilter.lowest, this.priceFilter.highest).
            subscribe(function (records) { _this.records = records; });
    };
    MainComponent.prototype.save = function (newRecord) {
        var _this = this;
        this.recordService.saveRecord(newRecord).subscribe(function () {
            _this.loadData();
        });
    };
    MainComponent.prototype.delete = function (id) {
        var _this = this;
        this.recordService.deleteRecord(id.toString()).subscribe(function () {
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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_main_record_service__WEBPACK_IMPORTED_MODULE_3__["RecordService"]])
    ], MainComponent);
    return MainComponent;
}());



/***/ }),

/***/ "./src/app/main/record.service.ts":
/*!****************************************!*\
  !*** ./src/app/main/record.service.ts ***!
  \****************************************/
/*! exports provided: RecordService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RecordService", function() { return RecordService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var RecordService = /** @class */ (function () {
    function RecordService(http) {
        this.http = http;
        this.path = '/api/records';
    }
    RecordService.prototype.getRecords = function (order, lowestPrice, highestPrice) {
        var params = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"]();
        if (+lowestPrice) {
            // HttpParams je imutabilna kolekcija!
            params = params.append('lowestPrice', lowestPrice.toString());
        }
        if (+highestPrice) {
            params = params.append('highestPrice', highestPrice.toString());
        }
        if (order !== undefined) {
            params = params.append('ord', order.toString());
        }
        return this.http.get(this.path, { params: params });
    };
    RecordService.prototype.getRecord = function (id) {
        return this.http.get("/api/records/" + id);
    };
    RecordService.prototype.saveRecord = function (newRecord) {
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({ 'Content-Type': 'application/json' });
        // let options = new RequestOptions({ headers: headers });
        return this.http.post(this.path, JSON.stringify(newRecord), { headers: headers });
    };
    RecordService.prototype.deleteRecord = function (id) {
        return this.http.delete(this.path + "/" + id);
    };
    RecordService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], RecordService);
    return RecordService;
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

module.exports = "<h1>\n  There is nothing here!\n</h1>\n"

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

module.exports = "<div *ngIf=\"isDataAvailable\">\n\t<h1>{{record.title}}</h1>\n\t<h2>{{record.author.name}}</h2>\n\t<div><img class=\"img-rounded\" width=\"100\" height=\"100\" src=\"{{record.imageUrl}}\"></div>\n\t<div>{{record.price}}</div>\n\t<div *ngIf=\"record.styles.length!=0\">\n\tstyles:\n\t<ul class=\"list-group\">\n\t\t<li class=\"list-group-item\" *ngFor=\"let style of record.styles\">\n\t\t\t{{style.name}}\n\t\t</li>\n\t</ul>\n\t</div>\n</div>\n"

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
/* harmony import */ var _main_record_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../main/record.service */ "./src/app/main/record.service.ts");




var RecordDetailsComponent = /** @class */ (function () {
    function RecordDetailsComponent(recordService, route) {
        this.recordService = recordService;
        this.route = route;
    }
    RecordDetailsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.recordService.getRecord(params['id']).subscribe(function (res) {
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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_main_record_service__WEBPACK_IMPORTED_MODULE_3__["RecordService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
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

module.exports = "<div>\n\t<h1>Records</h1>\n\t<table class=\"table table-bordered table-striped\">\n\t\t<thead>\n\t\t\t<tr>\n\t\t\t\t<th>Title</th><th>Author</th><th>Price</th><th>Action</th>\n\t\t\t</tr>\n\t\t</thead>\n\t\t<tbody>\n\t\t\t<tr app-record *ngFor=\"let record of records; let i = index\" [record]=\"record\" [index]=\"i\" (deleteRecordIndex)=\"delete($event)\">\n\t\t\t\t<!-- <app-record [record]=\"record\" [index]=\"i\" (deleteRecordIndex)=\"delete($event)\"></app-record> -->\n\t\t\t</tr>\n\t\t</tbody>\n\t</table>\n</div>"

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

module.exports = "<td>\n\t{{record.title}}\n</td>\n<td>\n\t{{record.author.name}}\n</td>\n<td>\n\t{{record.price}}\n</td>\n<td>\n\t<button\n\t\t*ngIf=\"isAdmin()\"\n\t\tclass=\"btn btn-danger\"\n\t\t(click)=\"deleteRecord(record.id)\">remove</button>\n\t<button class=\"btn btn-primary\" (click)=\"details(record.id)\">details</button>\n</td>"

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
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _common_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../common.models */ "./src/app/common.models.ts");
/* harmony import */ var _security_authentication_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../security/authentication.service */ "./src/app/security/authentication.service.ts");





var RecordComponent = /** @class */ (function () {
    function RecordComponent(router, authenticationService) {
        this.router = router;
        this.authenticationService = authenticationService;
        this.deleteRecordIndex = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    RecordComponent.prototype.ngOnInit = function () {
    };
    RecordComponent.prototype.deleteRecord = function (id) {
        this.deleteRecordIndex.next(id);
    };
    RecordComponent.prototype.details = function (id) {
        this.router.navigate(['/record', id]);
    };
    RecordComponent.prototype.isAdmin = function () {
        return this.authenticationService.isAdmin();
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _common_models__WEBPACK_IMPORTED_MODULE_3__["Record"])
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
            selector: 'tr[app-record]',
            template: __webpack_require__(/*! ./record.component.html */ "./src/app/record/record.component.html"),
            styles: [__webpack_require__(/*! ./record.component.css */ "./src/app/record/record.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            _security_authentication_service__WEBPACK_IMPORTED_MODULE_4__["AuthenticationService"]])
    ], RecordComponent);
    return RecordComponent;
}());



/***/ }),

/***/ "./src/app/security/authentication.service.ts":
/*!****************************************************!*\
  !*** ./src/app/security/authentication.service.ts ***!
  \****************************************************/
/*! exports provided: AuthenticationService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function() { return AuthenticationService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _security_jwt_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../security/jwt-utils.service */ "./src/app/security/jwt-utils.service.ts");






var AuthenticationService = /** @class */ (function () {
    function AuthenticationService(http, jwtUtilsService) {
        this.http = http;
        this.jwtUtilsService = jwtUtilsService;
        this.loginPath = '/api/login';
    }
    AuthenticationService.prototype.login = function (username, password) {
        var _this = this;
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({ 'Content-Type': 'application/json' });
        return this.http.post(this.loginPath, { username: username, password: password }, { headers: headers })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (res) {
            var token = res && res['token'];
            if (token) {
                localStorage.setItem('currentUser', JSON.stringify({
                    username: username,
                    roles: _this.jwtUtilsService.getRoles(token),
                    token: token
                }));
                return true;
            }
            else {
                return false;
            }
        }));
    };
    AuthenticationService.prototype.getToken = function () {
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        var token = currentUser && currentUser.token;
        return token ? token : "";
    };
    AuthenticationService.prototype.logout = function () {
        localStorage.removeItem('currentUser');
    };
    AuthenticationService.prototype.isLoggedIn = function () {
        if (this.getToken() != '')
            return true;
        else
            return false;
    };
    AuthenticationService.prototype.getCurrentUser = function () {
        if (localStorage.currentUser) {
            return JSON.parse(localStorage.currentUser);
        }
        else {
            return undefined;
        }
    };
    AuthenticationService.prototype.isAdmin = function () {
        var currentUser = this.getCurrentUser();
        if (!currentUser) {
            return false;
        }
        return currentUser.roles.includes('ROLE_ADMIN');
    };
    AuthenticationService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"], _security_jwt_utils_service__WEBPACK_IMPORTED_MODULE_4__["JwtUtilsService"]])
    ], AuthenticationService);
    return AuthenticationService;
}());



/***/ }),

/***/ "./src/app/security/can-activate-auth.guard.ts":
/*!*****************************************************!*\
  !*** ./src/app/security/can-activate-auth.guard.ts ***!
  \*****************************************************/
/*! exports provided: CanActivateAuthGuard */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CanActivateAuthGuard", function() { return CanActivateAuthGuard; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _security_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../security/authentication.service */ "./src/app/security/authentication.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");




var CanActivateAuthGuard = /** @class */ (function () {
    function CanActivateAuthGuard(authenticationService, router) {
        this.authenticationService = authenticationService;
        this.router = router;
    }
    CanActivateAuthGuard.prototype.canActivate = function (next, state) {
        if (this.authenticationService.isLoggedIn()) {
            return true;
        }
        else {
            this.router.navigate(['/login']);
            return false;
        }
    };
    CanActivateAuthGuard = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_security_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], CanActivateAuthGuard);
    return CanActivateAuthGuard;
}());



/***/ }),

/***/ "./src/app/security/jwt-utils.service.ts":
/*!***********************************************!*\
  !*** ./src/app/security/jwt-utils.service.ts ***!
  \***********************************************/
/*! exports provided: JwtUtilsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JwtUtilsService", function() { return JwtUtilsService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var JwtUtilsService = /** @class */ (function () {
    function JwtUtilsService() {
    }
    JwtUtilsService.prototype.getRoles = function (token) {
        var jwtData = token.split('.')[1];
        var decodedJwtJsonData = window.atob(jwtData);
        var decodedJwtData = JSON.parse(decodedJwtJsonData);
        return decodedJwtData.roles.map(function (x) { return x.authority; }) || [];
    };
    JwtUtilsService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], JwtUtilsService);
    return JwtUtilsService;
}());



/***/ }),

/***/ "./src/app/security/token-interceptor.service.ts":
/*!*******************************************************!*\
  !*** ./src/app/security/token-interceptor.service.ts ***!
  \*******************************************************/
/*! exports provided: TokenInterceptorService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TokenInterceptorService", function() { return TokenInterceptorService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _security_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../security/authentication.service */ "./src/app/security/authentication.service.ts");




var TokenInterceptorService = /** @class */ (function () {
    function TokenInterceptorService(inj) {
        this.inj = inj;
    }
    TokenInterceptorService.prototype.intercept = function (request, next) {
        var authenticationService = this.inj.get(_security_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]);
        request = request.clone({
            setHeaders: {
                'X-Auth-Token': "" + authenticationService.getToken()
            }
        });
        return next.handle(request);
    };
    TokenInterceptorService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injector"]])
    ], TokenInterceptorService);
    return TokenInterceptorService;
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

module.exports = "<div>\n\t<div class=\"btn-group\">\n\t\t<button class=\"btn btn-primary\" (click)=\"sort(orderTypes.asc)\">sort by price asc</button>\n\t\t<button class=\"btn btn-primary\" (click)=\"sort(orderTypes.desc)\">sort by price desc</button>\n\t</div>\n</div>\n"

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

module.exports = __webpack_require__(/*! /Users/nikolalukic/workspace/predavanja/VP04_2018/55_Angular_prava_pristupa/primeri/primer1/record-store/client/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map