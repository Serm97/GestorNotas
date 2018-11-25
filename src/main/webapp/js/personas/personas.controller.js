var personasModule = angular.module("personasModule");

personasModule.controller('personasController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.personas = new Array();
        $scope.person = {};

        $scope.create = function () {
            console.log(JSON.stringify($scope.person));
            $http.post('api/personas', JSON.stringify($scope.person)).then(function (response) {
                swal("Creado", "Persona " + $scope.person.nombrePersona + " ha sido creada.", "success");
                persona = response.data;
                $http.get('api/datatypes/roles/' + $scope.person.rol.idRol).then(function (response) {
                    rol = response.data;
                    switch (rol.nombreRol) {
                        case "Estudiante":
                            estudiante = {};
                            estudiante.codEstudiante = '500' + getRandomInt(100, 200);
                            estudiante.idPersona = persona;
                            $http.post('api/estudiantes', JSON.stringify(estudiante)).then(function (response) {
                                swal("Asignado a la lista de Estudiantes.");
                            }, function (error) {
                                console.log(error);
                            });
                            estudiante = {};
                            break;

                        case "Profesor":
                            profesor = {};
                            profesor.codprofesor = '200' + getRandomInt(200, 400);
                            profesor.idPersona = persona;
                            profesor.areaProfundizacion = "Por definir";

                            $http.post('api/profesores', JSON.stringify(profesor)).then(function (response) {
                                swal("Asignado a la lista de Profesores.");
                            }, function (error) {
                                console.log(error);
                            });
                            profesor = {};
                            break;

                        case "Coordinador":
                            coordinador = {};
                            coordinador.codCoordinador = '111' + getRandomInt(111, 500);
                            coordinador.idPersona = persona;
                            coordinador.idPrograma = persona.idPrograma;
                            swal("Asignado a la lista de Coordinadores.");
                            $http.post('api/coordinadores', JSON.stringify(coordinador)).then(function(response){

                            }, function (error) {
                                console.log(error);
                            });
                            coordinador = {};
                            break;

                    }
                }, function (error) {
                    console.log(error);
                });

                $scope.person = {};
                $state.reload();
            }, function (error) {
                console.log(error);

            });
        };

        $scope.editar = function (id) {
            $http.get('api/personas/' + id).then(function (response) {
                $scope.person = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        $scope.actualizar = function () {
            $http.put('api/personas/' + $scope.person.idPersona, JSON.stringify($scope.person)).then(function (response) {
                swal("Persona " + $scope.person.nombrePersona + " ha sido actualizado.");
                $scope.person = {};
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };

        // ComboBox
        $http.get('api/programas').then(function (response) {
            $scope.listaProgramas = new Array();
            $scope.listaProgramas = response.data;

        }, function (error) {
            console.log(error);
        });

        $http.get('api/datatypes/TIPO_DOCUMENTO').then(function (response) {
            $scope.listaTipoDocumento = new Array();
            $scope.listaTipoDocumento = response.data;

        }, function (error) {
            console.log(error);
        });

        $http.get('api/datatypes/GENERO').then(function (response) {
            $scope.listaGenero = new Array();
            $scope.listaGenero = response.data;

        }, function (error) {
            console.log(error);
        });

        $http.get('api/datatypes/roles').then(function (response) {
            $scope.listaRoles = new Array();
            $scope.listaRoles = response.data;

        }, function (error) {
            console.log(error);
        });

        $http.get('api/personas').then(function (response) {
            console.log(response.data);
            $scope.personas = response.data;
        }, function (error) {
            console.log(error);
        });

        // Eliminar Persona
        $scope.eliminar = function (id) {
            $http.delete('api/personas/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}
