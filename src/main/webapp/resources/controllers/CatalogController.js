microServiceShop.controller('CatalogController', ['$scope', 'catalog', function($scope, catalog) {
  catalog.success(function(data) {
    $scope.catalog = data.products;
  });
}]);