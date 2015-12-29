'use strict';

describe('Controllers Tests ', function () {

    beforeEach(module('myApp'));

    describe('UsersListCtrl', function () {
        var $scope, $httpBackend;

        beforeEach(inject(function (_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('resources/i18n/en.json').
                respond({});
            $httpBackend.expectGET('user/account').
                respond({"preferences" : {"lang" : "en"}});
            $httpBackend.expectGET('user/all').
                respond([{"id":1,"firstName":"adminName","familyName":"adminFamily"}]);

            $scope = $rootScope.$new();
            $controller('UsersListCtrl', {$scope: $scope});
        }));

        it('should set users', function () {
            console.log('------> should set users');
            $httpBackend.flush();

            expect($scope.users).not.toBeUndefined();
            expect($scope.users[0]).not.toBeUndefined();
        });
    });


    //describe('UserEditCtrl', function () {
    //    var $scope, userService, deferred, spyPromise;
    //
    //    beforeEach(inject(function ($rootScope, $controller, UserService, Roles, $q) {
    //
    //        this.$scope = $rootScope.$new();
    //
    //        //create a promise for the spy to return to mock the async calls to the service
    //        deferred = $q.defer();
    //        spyPromise = deferred.promise;
    //
    //
    //        //Setup 2 functions for the spy to call if the async call was successfull or failed
    //        spyPromise.success = function (fn) {
    //            //success of the promise consumes the success callback
    //            spyPromise.then( function (data) {
    //                //call the promise.success method in controller
    //                fn(data);
    //            });
    //            return spyPromise;
    //        };
    //
    //        spyPromise.error = function (fn) {
    //            //error of the promise consumes the error callback, not the success callback
    //            spyPromise.then( undefined, function (status) {
    //                //call the promise.error method in the controller
    //                fn(status);
    //            });
    //            return spyPromise;
    //        };
    //
    //        userService = UserService;
    //
    //        $controller('UserEditCtrl', {$scope: $scope, UserService: UserService, Roles : Roles});
    //    }));
    //
    //    it('should save user', function () {
    //        console.log('------> should save user');
    //
    //        //SET SPY
    //        spyOn(userService, 'saveUser').and.returnValue(spyPromise);
    //
    //
    //        //WHEN
    //        $scope.saveUser();
    //
    //        expect(userService.saveUser).toHaveBeenCalled();
    //    });
    //});


});
