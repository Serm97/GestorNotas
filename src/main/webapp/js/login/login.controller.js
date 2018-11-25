var loginModule = angular.module("loginModule");

loginModule.controller('loginController', ['$scope', '$http', '$state', function($scope, $http, $state){
    console.log("Funciona");
    $scope.usuario = {};
    $scope.login = function () {
            if ($scope.usuario.emailUsuario && $scope.usuario.clave) {
                $http.post('api/usuarios/Login', JSON.stringify($scope.usuario)).then(function (response) {
                    if (response){
                        $state.go('inicio');
                    }                    
                }, function (error) {
                    swal("Prohibido", "Revise los datos ingresados.", "error");
                    console.log(error);
                });
            };
        };
}]);