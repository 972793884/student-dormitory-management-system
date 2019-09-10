function datafilter(data, visiblePages, currentPage, pageSize) {
    var namelist = [];
    /*key 列表*/
    var vallist = [];
    /*值 列表*/
    var operatorlist = [];
    /*运算符列表*/
    var form = $("#filterForm")
    /*获取条件查询*/
    form.find("input,select").each(function (e) {
        var val = $(this).val();
        if (val != "" && val != "undefined") {
            namelist.push($(this).attr('name'))
            vallist.push(val)
            operatorlist.push($(this).attr('operator'))
        }
    })
    /*过滤数据*/
    var filter = "";
    if (namelist.length != "undefined" && namelist.length > 0) {
        /*生成过滤条件*/
        for (var i = 0; i < namelist.length; i++) {
            var op = operatorlist[i] + "'" + vallist[i] + "'";
            if (operatorlist[i] == 'match') {
                op = '.' + operatorlist[i] + '("' + vallist[i] + '")'
            }
            if (i != namelist.length - 1) {
                filter += "e." + namelist[i] + op + "&&";
            } else {
                filter += "e." + namelist[i] + op;
            }
        }
        /*执行过滤*/
        /*alert(filter)*/
        data = data.filter(function (e) {
            return eval(filter);
        })
    }
    data = data == "undefined" ? [] : data
    var totalPages = Math.ceil(data.length / pageSize)
    currentPage = Math.min(totalPages, currentPage)
    $('#pagination').jqPaginator('option', {totalPages: totalPages, currentPage: currentPage});
    return data;
}

function sortData(data, col, flag) {
    /*比较器*/
    function buildsort(a, b) {
        var bool = eval("a." + col + " - b." + col);
        if (Number.isNaN(bool)) {
            bool = eval("a." + col + ".localeCompare(b." + col + ", 'zh-CN')");
        }
        return flag ? bool : -bool;
    }

    data.sort(buildsort)
    return data
}

function pageData(data, page, pagesize) {
    var result = [];
    page = page - 1
    for (var i = page * pagesize; i < page * pagesize + pagesize; i++) {
        result.push(data[i]);
        if (i == data.length - 1) {
            return result;
        }
    }
    return result;
}

function search(data, visiblePages, page, pageSize) {
    var result = datafilter(data, visiblePages, page, pageSize)
    if (result == "") {
        console.log("没有数据显示")
        $("#pagination").hide()
        return
    } else
        $("#pagination").show()
    var sort = sortData(result, "id", true);
    var datas = pageData(sort, page, pageSize)
    datas.forEach(function (e) {
        /* alert(e.id)*/
    })
    return datas
}

function searchData(visiblePages, page, pageSize) {
    vm.list = search(vm.data, visiblePages, page, pageSize)
}

function build(data, visiblePages, pageSize) {
    if (data == "" || data == undefined || data == [] || data.length == 0 || data.length == undefined){
        console.log("没有数据显示")
        $("#pagination").hide()
        vm.list=''
        return
    }

    var totalPages = Math.ceil(data.length / pageSize)

    $.jqPaginator('#pagination', {
        totalPages: totalPages,
        visiblePages: visiblePages,
        currentPage: 1,
        wrapper: '<ul class="pagination"></ul>',
        first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);">尾页</a></li>',
        page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
        onPageChange: function (page) {
            var result = search(data, visiblePages, page, pageSize)
            vm.list = result
        }
    });
}

function isLogin() {
    $.ajax({
        url: "/isLogin",
        type: "GET",
        data: {},
        dataType: "json",
        success: function (data) {
            if (data.state=='fail')
                $(".loginMenu").hide();
            else{
                $(".login").hide();
                $(".doorExpress").hide();
                if (data.user.role=='1') {
                    $(".admin").hide();
                }
            }
        }
    });
}