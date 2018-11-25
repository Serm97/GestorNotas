var app = angular.module("GestorNotasKL");

app.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        $urlRouterProvider.otherwise('/');
        
        $stateProvider.state('main',{ 
                url: '/',
                templateUrl: 'js/login/login.html',
                controller: 'loginController'
            }
        );

        $stateProvider.state('inicio',{ 
                url: '/inicio',
                templateUrl: 'views/home.html',
                controller: 'loginController'
            }
        );

        $stateProvider.state('programas',{ 
            url: '/programas',
            templateUrl: 'js/programas/programas.html',
            controller: 'programasController'
        }
        );

        $stateProvider.state('personas',{ 
            url: '/personas',
            templateUrl: 'js/personas/personas.html',
            controller: 'personasController'
            }
        );
    
        $stateProvider.state('inscripciones',{ 
            url: '/inscripciones',
            templateUrl: 'js/inscripciones/inscripciones.html',
            controller: 'inscripcionesController'
            }
        );

        $stateProvider.state('cursos',{ 
            url: '/cursos',
            templateUrl: 'js/cursos/cursos.html',
            controller: 'cursosController'
            }
        );

        $stateProvider.state('estudiantes',{ 
            url: '/estudiantes',
            templateUrl: 'js/estudiantes/estudiantes.html',
            controller: 'estudiantesController'
            }
        );

        $stateProvider.state('profesores',{ 
            url: '/profesores',
            templateUrl: 'js/profesores/profesores.html',
            controller: 'profesoresController'
            }
        );

        $stateProvider.state('asignaturas',{ 
            url: '/asignaturas',
            templateUrl: 'js/asignaturas/asignaturas.html',
            controller: 'asignaturasController'
            }
        );
        
}]);
