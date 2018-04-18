var basePath= "";
$(window).ready(function(){
    if(basePath==""){
        basePath=getRootPath();
    }

});

/**
 * 获取根目录
 * @returns {string}
 */
function getRootPath()
{
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/'+ webName;
}


