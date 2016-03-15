/**
 * Created by user on 04.03.16.
 */
var module = angular.module("historySalesServices", []);
module.factory("historySalesServices", function($rootScope)
{
    var listHistorySales = []

    return {
        listSalesRead:function()
        {
            return listHistorySales;
        },

        listSalesWrite:function(responce)
        {
            listHistorySales = responce;
        }
    }
})
