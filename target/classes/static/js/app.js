
var app= angular.module('App',['dataProductServices', 'userConnectedModule', 'historySalesServices' ,'ui.router',
                        'angularUtils.directives.dirPagination'])
    .config(function($stateProvider, $locationProvider,  $urlRouterProvider){
        $locationProvider.html5Mode(true);
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('index', {
            url:"/",
            views:{
                'left':
                {
                    templateUrl:"/list-category.html"
                }
            }
        })
            .state('list-goods', {
            url:"/list-goods",
            views:{
                'main':{
                    templateUrl:"/list-goods.html",
                    controller:'listGoodsCtrl'
                },
                'left':
                {
                    templateUrl:"/filter-product.html",
                    controller:'filterGoodsCtrl'
                }
            }
        })
            .state('about', {
            url:"/about",
            views:{
                'main':{
                    templateUrl:"/about.html",
                    controller:'aboutCtrl'
                }
            }
        })
            .state('product-full-description', {
            url:"/product-full-description/:subcategory/:id",
            views:{
                'main':{
                    templateUrl:"/product-full-description.html",
                    controller:"productFullDescriptionCtrl"
                },
                'left':{
                    templateUrl:"/list-category.html"
                }
            }
        })
            .state('promotions', {
                url:"/promotions",
                views:{
                    'main':{
                        templateUrl:"/promotions.html"
                    }
                }
            })

            .state('contact', {
                url:"/contact",
                views:{
                    'main':{
                        templateUrl:"/contact.html",
                       controller:'contactCtrl'
                    }
                }
            })

            .state('list-goodsSearchAtName', {
                url:"/list-goodsSearchAtName",
                views:{
                    'main':{
                        templateUrl:"/list-goodsSearchAtName.html",
                        controller:'listGoodsSearchAtNameCtrl'
                    }
                }
            })
    })

