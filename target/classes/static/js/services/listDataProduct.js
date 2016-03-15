/**
 * Created by user on 01.02.16.
 */
var module = angular.module("dataProductServices", []);
module.factory("listDataProductServices", function($rootScope){
    var dataProduct = []
    var dataSearchProduct = []
    var dataAllProduct = []
    var listFilter = []
    var listSurname = []

    return {
        dataSearchProductRead:function()
        {
            return dataSearchProduct;
        },

        dataSearchProductWrite:function(message)
        {
            dataProduct= message
            dataSearchProduct = message
        },

        dataProductRead:function()
        {
            return dataProduct;
        },

        dataProductWrite:function(message)
        {
            for(var i = 0; i<message.length; i++)
            {
                dataProduct.push(message[i])
            }
            dataProduct = message
            dataAllProduct = message
            dataSearchProduct = message
        },

        addFilter:function(surname, filter)
        {
            listSurname.push(surname)
            var obj = {};
            if(listSurname.length > 0)
            {
                for (var i = 0; i < listSurname.length; i++)
                {
                    var str = listSurname[i];
                    obj[str] = true;
                }
            }
            listSurname = Object.keys(obj);

            var listObj = {}
            listObj[surname] = filter
            listFilter.push(listObj)

            for(var i = 0; i<listFilter.length; i++)
            {
                if(Object.keys(listFilter[i])=='brand')
                {
                    var brand = listFilter[i];
                    listFilter.splice(i, 1);
                    listFilter.unshift(brand)
                }
            }

            var dataUpdate=[]
            var count = 0
            var r=[]
            for(var a = 0; a<dataAllProduct.length; a++)
            {
                for (var i = 0; i < listSurname.length; i++)
                {
                    for (var j = 0; j < listFilter.length; j++)
                    {
                        if (dataAllProduct[a][listSurname[i]]==listFilter[j][listSurname[i]])
                        {
                            if(Object.keys(listFilter[j])=='brand')
                            {
                                dataUpdate.push(dataAllProduct[a])
                            }
                            else if(dataUpdate.length>0)
                            {
                                for(var t=0; t<dataUpdate.length; t++)
                                {
                                    if(dataUpdate[t][listSurname[i]] == listFilter[j][listSurname[i]])
                                    {
                                        r.push(dataUpdate[t])
                                    }
                                }
                            }
                            else
                            {
                                var isTrue = true
                                for(var e = 0; e<listFilter.length; e++)
                                {
                                    if(Object.keys(listFilter[e]) == 'brand')
                                    {
                                        isTrue=false
                                    }
                                }
                                if(isTrue)
                                {
                                    if(dataAllProduct[a][listSurname[i]] == listFilter[j][listSurname[i]])
                                    {
                                        r.push(dataAllProduct[a])
                                    }
                                }
                            }
                        }
                    }
                }
                count=0;
            }

            if(listSurname.length>1)
            {
                if(r.length == 0 && listFilter.length > 0)
                {
                    toastr.info("Non goods")
                }
                else
                {
                    dataProduct = r
                }
                dataProduct = r
            }
            else if(dataUpdate.length>0)
            {
                dataProduct=dataUpdate
            }
            else
            {
                if(r.length == 0)
                {
                    toastr.warning("Please update page")
                }
                else
                {
                    dataProduct = r
                }
            }
        },

        removeFilter:function(surname, deleteFilter)
        {
            var countSurnameFilter = []

            for(var i=0; i<listFilter.length; i++)
            {
                if(listFilter[i][surname] == deleteFilter)
                {
                    listFilter.splice(i, 1);
                }
            }

            for(var i = 0; i<listFilter.length; i++)
            {
                if(Object.keys(listFilter[i]) == surname)
                {
                    var numIndex = listFilter.indexOf(Object.keys(listFilter[i]))
                    countSurnameFilter.push(numIndex)
                }
            }

            for(var i = 0; i<listSurname.length;i++)
            {
                if(listFilter.length>0)
                {
                    var metka = 0;
                    for (var j = 0; j < listFilter.length; j++){
                        if(Object.keys(listFilter[j])!= listSurname[i] && countSurnameFilter.length != 1)
                        {
                            if(countSurnameFilter.length < 2)
                                metka = 1;
                        }
                    }
                    if(metka==1)
                    {
                        listSurname.splice(i,1)
                    }
                }
                else
                {
                    if(listSurname[i]==surname)
                    {
                        listSurname.splice(i,1)
                    }
                }
            }

            if(listFilter.length == 0)
            {
                dataProduct=dataAllProduct
            }
            else if(listFilter.length > 0)
            {

                var dataUpdate=[]
                var count = 0
                var r=[]
                for(var a = 0; a<dataAllProduct.length; a++)
                {
                    for (var i = 0; i < listSurname.length; i++)
                    {
                        for (var j = 0; j < listFilter.length; j++)
                        {
                            if (dataAllProduct[a][listSurname[i]]==listFilter[j][listSurname[i]])
                            {

                                if(Object.keys(listFilter[j])=='brand')
                                {
                                    dataUpdate.push(dataAllProduct[a])
                                }
                                else if(dataUpdate.length>0)
                                {
                                    for(var t=0; t<dataUpdate.length; t++)
                                    {
                                        if(dataUpdate[t][listSurname[i]] == listFilter[j][listSurname[i]])
                                        {
                                            r.push(dataUpdate[t])
                                        }
                                    }
                                }
                                else if(dataUpdate.length == 0 )
                                {
                                    var isTrue = true
                                    for(var e = 0; e<listFilter.length; e++)
                                    {
                                        if(Object.keys(listFilter[e]) =='brand')
                                        {
                                            isTrue=false
                                        }
                                    }

                                    if(isTrue)
                                    {
                                        if(dataAllProduct[a][listSurname[i]] == listFilter[j][listSurname[i]])
                                        {
                                            r.push(dataAllProduct[a])
                                        }
                                    }
                                }
                            }
                        }
                    }
                    count=0;
                }

                if(listSurname.length>1)
                {
                    dataProduct = r
                }
                else if(dataUpdate.length>0)
                {
                    dataProduct=dataUpdate
                }
                else
                {
                    dataProduct = r
                }
            }
        }
    }
})

