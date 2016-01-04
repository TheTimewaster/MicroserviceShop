var microServiceShop = angular.module('microServiceShop',[
    'ngRoute',
]);

microServiceShop.config(function($routeProvider)
{
   $routeProvider
   .when("/",{
       controller: 'CatalogController',
       templateUrl: 'pages/catalog.html'
   })
   .when("/about",{
       templateUrl: 'pages/about.html',
    //    controller: 'aboutController'
    })
   .when("/cart",{
       templateUrl: 'pages/cart.html',
       //controller: 'cartController'
    })
    .when("/checkout",{
       templateUrl: 'pages/checkout.html',
       //controller: 'checkoutController'
    })
    .otherwise({
        redirectTo: "/" 
    });
});