microServiceShop.factory('catalog', ['$http', function($http){
    return $http.get('/catalog/all')
    .success(function(data)
    {
        return data.products;
    })
    .error(function(data)
    {
        return data.products;
    });
}])