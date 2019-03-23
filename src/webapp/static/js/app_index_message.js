$(function () {
    layui.use(['layer'], function () {
        /**
         * 开启定时任务，每3秒拉取一次消息
         * code为200就显示消息
         */

        var setInterval_message = setInterval(function () {
            $.ajax({
                type:"POST",
                url:"/message/app_index_message",
                success:function (r) {
                    // console.log(r);
                    if(r.code == 200) {
                        $("#alertMessage").show(0);
                        $(".el-alert__title").text(r.message);
                    }
                },
                error:function () {
                    console.log('网络错误');
                }
            })

        }, 3000);

        $(".el-alert__closebtn").click(function () {
            // clearInterval(setInterval_message);
            // 将消息设为已读
            $.ajax({
                type:"POST",
                url:"/message/app_index_read",
                success:function (r) {
                },
                error:function () {
                    layer.msg('网络错误');
                }
            })

        });

    });

});