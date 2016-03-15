/**
 * Created by user on 23.02.16.
 */

var moduleUser = angular.module("userConnectedModule", []);
moduleUser.factory("getUserConnectedServices", function()
{
    var isUserConnected = false;
    var isAdminConnected = false;
    var userInformation = ''
    var loginUser = ''
    var passwordUser = ''

    var getCookies = function()
    {
        var cookies = {};
        var all = document.cookie;

        if (all === "")
            return cookies;

        var list = all.split("; ");
        for(var i = 0; i < list.length; i++)
        {
            var cookie = list[i];
            var p = cookie.indexOf("=");
            var name = cookie.substring(0,p);

            var value = cookie.substring(p+1);

            value = decodeURIComponent(value);

            if(name == 'connected')
            {
                if(value == 'admin')
                {
                    isAdminConnected = true
                }
                else if(value == 'user')
                {
                    isUserConnected = true
                    isAdminConnected = false
                }
            }
            else if(name == 'login')
            {
                loginUser = value
            }
            else if(name == 'password')
            {
                passwordUser = value
            }
        }
    }

    getCookies()

    return {
        userConnected: function(message)
        {
            isUserConnected = message
        },

        getConnectedUser: function()
        {
            return isUserConnected;
        },

        adminConnected:function(message)
        {
            isAdminConnected = message
        },

        getConnectedAdmin: function()
        {
            return isAdminConnected;
        },

        writeUserInfo: function(mes)
        {
            userInformation = mes
        },

        readUserInfo: function()
        {
            return userInformation;
        },

        readLoginUser: function()
        {
            return loginUser;
        },

        readPasswordUser: function()
        {
            return passwordUser;
        }
    }
})