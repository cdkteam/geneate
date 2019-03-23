
layui.config({
    base: '/static/layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'console', 'form', 'layer', 'upload'], function () {
    var form = layui.form;
    var layer = layui.layer;
    var upload = layui.upload;



    // 初始化复选框
    // form.render(null, 'component-form-element');
    form.render('checkbox');

    upload.render({
        elem: '#carsoule_add'
        ,url: '/upload/carsoule_upload'
        ,field:'carsouleImageFile'
        ,data:{
            type:0
        }
        ,before:function (e) {
            // layer.load();
        }
        ,done: function(res, index, upload){ //上传后的回调
            if(carousel.carouselMaps.length >= 3) {
                layer.msg("只能上传3张轮播图片");
                layer.closeAll('loading');
                return;
            }
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var carsouleItem = new Object();
            carsouleItem.createDate = year + "-" + month + "-" + day;
            carsouleItem.imgUrl = res.data;
            carsouleItem.id = res.id;
            carousel.carouselMaps.push(carsouleItem);
            layer.closeAll('loading');
        }
        ,error:function() {

        }
        ,accept: 'images' //允许上传的文件类型
        ,acceptMime:'image/*'
        ,size: 500 //最大允许上传的文件大小（KB）
    });

    var itemIdArr = [];

    var carsouleDel = document.getElementById("carsoule_del");
    // 删除选中的图片
    carsouleDel.addEventListener("click", function () {
        xhr.open("GET", "/img/delcarousel?imgStr=" + itemIdArr.toString(), true);
        xhr.onload = function(e) {
            if(xhr.readyState === 4) {
                if(xhr.status === 200) {
                    for(var i = 0;i < itemIdArr.length;i++) {
                        for(var j = 0;j < carousel.carouselMaps.length;j++) {
                            if(carousel.carouselMaps[j]) {
                                if(carousel.carouselMaps[j].id === itemIdArr[i]) {
                                    carousel.carouselMaps.splice(j, 1);
                                }
                            }
                        }
                    }
                    console.log(xhr.statusText);
                } else {
                    console.log(xhr.statusText);
                }
            }
            itemIdArr = [];
        }
        xhr.onerror = function (e) {
            console.log(xhr.statusText);
        }
        xhr.send(null);
    });

    var carousel = new Vue({
        el:"#carousel",
        data:{
            isShowApp: false,
            carouselMaps:"",
            carouselIds:[]
        },
        methods:{
            checkboxClick:function (itemId, _this) {
                // 因为layui的form对象没渲染上，所以用了该方法代替
                var parentClassName = _this.target.parentNode.className;
                if(parentClassName.indexOf('layui-form-checked') > -1) {
                    _this.target.parentNode.className =
                        _this.target.parentNode.className.substring(0, parentClassName.indexOf('layui-form-checked'));
                    itemIdArr.splice(itemIdArr.indexOf(itemId), 1);
                } else {
                    _this.target.parentNode.className += ' layui-form-checked';
                    if(itemIdArr.indexOf(itemId) === -1) {
                        itemIdArr.push(itemId);
                    }
                }
            }
        }
    });

    var xhr = new XMLHttpRequest();

    xhr.open("POST", "/img/carousel", true);

    xhr.setRequestHeader("Content-Type", "text/plain;application/json");

    xhr.onload = function(e) {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                carousel.carouselMaps = JSON.parse(xhr.responseText);
            } else {
                console.log(xhr.statusText);
            }
        } 
    }
    
    xhr.onerror = function (e) {
        console.log(xhr.statusText);
    }

    xhr.send(null);


});