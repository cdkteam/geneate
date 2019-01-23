layui.use(['orgChart', 'jquery'], function() {
    var $ = layui.jquery;
    // var admin = layui.admin;
    var orgChart = layui.orgChart;
    $.getJSON('jsondata.js', function(json) {
        console.log(json);
        var data = json.data;
        //3表示显示到部门的第3级
        orgChart.render({
            elm: '.orgWrap',
            data: data,
            drag: true,
            depth: 3,
            renderdata: function(data, $dom) {
                var value = data;
                if(value && Object.keys(value).length) {
                    var $name = $('<div class="name"></div>');
                    var $relation = $('<p class="relationship"></p>');
                    !!(value.name) && $name.text(value.name);
                    !!(value.relation) && $relation.text(value.relation);
                    $name.append($relation);
                    $dom.append($name);
                    $dom.addClass('organization')
                }
            },
            callback: function() {}
        });
    });

});