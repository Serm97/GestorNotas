var asignaturasModule = angular.module("asignaturasModule");

asignaturasModule.controller('asignaturasController', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        $scope.asignaturas = new Array();
        $scope.asignatura = {};

        $scope.create = function () {
            $http.post('api/asignaturas', JSON.stringify($scope.asignatura)).then(function (response) {
                swal("Exito", "Se ha creado la Asignatura " + $scope.asignatura.nomAsignatura + " para el programa " + $scope.asignatura.idPrograma.nomPrograma, "success");
                $scope.asignatura = {};
                $state.reload();

            }, function (error) {
                console.log(error);
            });
        };

        $scope.editar = function (id) {
            $http.get('api/asignaturas/' + id).then(function (response) {
                $scope.asignatura = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        $scope.actualizar = function () {
            $http.put('api/asignaturas/'+$scope.asignatura.idAsignatura, JSON.stringify($scope.asignatura)).then(function (response) {
                swal("Exito", "Se ha actualizado la Asignatura " + $scope.asignatura.nomAsignatura + " para el programa " + $scope.asignatura.idPrograma.nomPrograma, "success");
                $scope.asignatura = {};
                $state.reload();

            }, function (error) {
                console.log(error);
            });
        };

        $http.get('api/programas').then(function (response) {
            $scope.listaProgramas = new Array();
            $scope.listaProgramas = response.data;

        }, function (error) {
            console.log(error);
        });


        $http.get('api/asignaturas').then(function (response) {
            console.log(response.data);
            $scope.asignaturas = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id) {
            $http.delete('api/asignaturas/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                swal("Restricción", "No se puede eliminar la asignatura por que existen cursos dependientes.", "error");
                console.log(error);
            });
        };
    }]);

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}