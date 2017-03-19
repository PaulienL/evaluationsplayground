"use strict";
var testing_1 = require('@angular/core/testing');
var core_1 = require('@ngx-translate/core');
var Observable_1 = require('rxjs/Observable');
var app_component_1 = require('./app.component');
var dummy_component_1 = require("./dummy/dummy.component");
var http_1 = require("@angular/http");
var testing_2 = require("@angular/http/testing");
var LocalTranslateLoader = (function () {
    function LocalTranslateLoader() {
        this.translations = { "TITLE": "Fy Faen! {{catchPhrase}}" };
    }
    LocalTranslateLoader.prototype.getTranslation = function (lang) {
        return Observable_1.Observable.of(this.translations);
    };
    return LocalTranslateLoader;
}());
describe('AppComponent', function () {
    var injector, translateService;
    beforeEach(testing_1.async(function () {
        testing_1.TestBed.configureTestingModule({
            declarations: [
                app_component_1.AppComponent,
                dummy_component_1.DummyComponent
            ],
            imports: [
                core_1.TranslateModule.forRoot({
                    loader: {
                        provide: core_1.TranslateLoader,
                        useFactory: function () { return new LocalTranslateLoader(); }
                    }
                }),
                http_1.HttpModule
            ],
            providers: [
                testing_2.MockBackend,
                http_1.BaseRequestOptions,
                {
                    provide: http_1.Http,
                    deps: [testing_2.MockBackend, http_1.BaseRequestOptions],
                    useFactory: function (backend, defaultOptions) { return new http_1.Http(backend, defaultOptions); }
                }
            ]
        }).compileComponents();
        injector = testing_1.getTestBed();
        translateService = injector.get(core_1.TranslateService);
    }));
    it('should create the app', testing_1.async(function () {
        var fixture = testing_1.TestBed.createComponent(app_component_1.AppComponent);
        var app = fixture.debugElement.componentInstance;
        expect(app).toBeTruthy();
    }));
});
