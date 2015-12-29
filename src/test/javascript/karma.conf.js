// Karma configuration
// http://karma-runner.github.io/0.10/config/configuration-file.html

module.exports = function (config) {
    config.set({
        // base path, that will be used to resolve files and exclude
        basePath: '../../..',

        // testing framework to use (jasmine/mocha/qunit/...)
        frameworks: ['jasmine'],

        // list of files / patterns to load in the browser
        files: [
            'target/javascript/META-INF/resources/webjars/jquery/2.1.1/jquery.min.js',
            'target/javascript/META-INF/resources/webjars/angular-file-upload/1.6.12/angular-file-upload-html5-shim.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular-animate.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular-route.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular-resource.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular-cookies.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular-sanitize.js',
            'target/javascript/META-INF/resources/webjars/angularjs/1.3.1/angular-mocks.js',
            'target/javascript/META-INF/resources/webjars/angular-translate/2.4.0/angular-translate.js',
            'target/javascript/META-INF/resources/webjars/angular-file-upload/1.6.12/angular-file-upload.min.js',
            'target/javascript/META-INF/resources/webjars/angular-translate-loader-static-files/2.4.0/angular-translate-loader-static-files.js',
            'target/javascript/META-INF/resources/webjars/angular-dynamic-locale/0.1.17/tmhDynamicLocale.min.js',
            'target/javascript/META-INF/resources/webjars/angular-http-auth/1.2.1/http-auth-interceptor.js',
            'target/javascript/META-INF/resources/webjars/angular-dateparser/1.0.9/angular-dateparser.min.js',
            'target/javascript/META-INF/resources/webjars/angular-loading-bar/0.6.0/loading-bar.js',
            'target/javascript/META-INF/resources/webjars/angular-translate-storage-cookie/2.4.0/angular-translate-storage-cookie.js',
            'src/main/webapp/resources/js/*.js',
            'src/test/javascript/**/!(karma.conf).js'
        ],

        // list of files / patterns to exclude
        exclude: [],

        // web server port
        port: 9876,

        // level of logging
        // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
        logLevel: config.LOG_INFO,

        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: false,

        // Start these browsers, currently available:
        // - Chrome
        // - ChromeCanary
        // - Firefox
        // - Opera
        // - Safari (only Mac)
        // - PhantomJS
        // - IE (only Windows)
        browsers: ['PhantomJS'],

        // Continuous Integration mode
        // if true, it capture browsers, run tests and exit
        singleRun: true
    });
};
