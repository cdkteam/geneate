
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

    /**
     * layui 上传组件，详情请移步 https://www.layui.com/doc/modules/upload.html
     * @param elem ：绑定的DOM
     * @param url ：上传路径
     * @param field ：文件参数（需跟后台接受参数名一致）
     * @param data ：上传的额外参数，0 代表该图片为轮播图类型
     * @param before ：上传前的操作
     * @param done ：上传后的回调；参数 res 为后台返回的数据
     * @param error ：发生错误的回调函数
     */
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
            // console.log(res);
            if(carousel.carouselMaps.length >= 3) {
                layer.msg("只能上传3张轮播图片");
                layer.closeAll('loading');
                return;
            }
            // 将数据设置到DOM对象中，对象push到数组中进行回显
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var carsouleItem = new Object();
            // 创建时间
            carsouleItem.createDate = year + "-" + month + "-" + day;
            // 图片地址
            carsouleItem.imgUrl = res.data;
            // 图片id
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

    // 轮播图id数组
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

    // vue实例对象
    var carousel = new Vue({
        el:"#carousel",
        data:{
            carouselMaps:"",
            carouselIds:[]
        },
        methods:{
            checkboxClick:function (itemId, _this) {
                // 因为layui的form对象没渲染上，所以用了该方法代替
                var parentClassName = _this.target.parentNode.className;
                // 判断是否被选中
                if(parentClassName.indexOf('layui-form-checked') > -1) { // 取消选中
                    _this.target.parentNode.className =
                        _this.target.parentNode.className.substring(0, parentClassName.indexOf('layui-form-checked'));
                    // 去除当前轮播图id
                    itemIdArr.splice(itemIdArr.indexOf(itemId), 1);
                } else { // 选中
                    _this.target.parentNode.className += ' layui-form-checked';
                    // 判断数组中已存在添加过的id，避免重复添加
                    if(itemIdArr.indexOf(itemId) === -1) {
                        itemIdArr.push(itemId); // 添加选中图id
                    }
                }
            }
        }
    });

    /**
     * 请求获取轮播图数据
     * @type {XMLHttpRequest}
     */
    var xhr = new XMLHttpRequest();

    xhr.open("POST", "/img/carousel", true);

    xhr.setRequestHeader("Content-Type", "text/plain;application/json");

    xhr.onload = function(e) {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                // 解析json字符串为json对象
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