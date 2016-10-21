var app = angular.module('minmax', [
   'jcs-autoValidate',
    'angular-ladda'
]);

app.run(function (defaultErrorMessageResolver) {
    defaultErrorMessageResolver.getErrorMessages().then(function (errorMessages) {
        errorMessages['tooYoung'] = 'You must be at least {0} years old to use this site.';
        errorMessages['tooOld'] = 'You must be max {0} years old to use this site.';
        errorMessages['badUsername'] = 'Username can only contain numbers and letters and _.';
    })
});
// https://minmax-server.herokuapp.com/register/'

app.controller('MinMaxCtrl', function ($scope) {
    $scope.formModel = {};
    
    $scope.submitting = false;
    
    $scope.onSubmit = function () {
        window.location="/amazonshopping/approvalPage";
        
    };
});