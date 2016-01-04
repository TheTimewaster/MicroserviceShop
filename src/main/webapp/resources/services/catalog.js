microServiceShop.factory('catalog', ['$http', function($http){
    return $http.get('/resources/catalog.json')
    .success(function(data)
    {
        return data.products;
    })
    .error(function(data)
    {
        return data.products;
    });
}])