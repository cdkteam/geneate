(function () {
    new Vue({
        el:"#app_memeber",
        data:function(){
            return {
                // 地区选择icon_change
                province:"",
                dialogFormVisible:false,
                dialogZbVisible:false,
                dialogAgeVisible:false,
                dialogWmVisible:false,
                dialogCodeVisible:false
            }
        },
        methods:{
            // 打开支系成员页面
            branchMember:function() {
                this.dialogFormVisible = true;
                console.log(1);
            },
            // 打开字辈信息页面
            zbMemeber:function() {
                this.dialogZbVisible = true;
                console.log(1);
            },
            // 打开年龄分布页面
            ageMemeber:function() {
                this.dialogAgeVisible = true;
                console.log(1);
            },
            // 打开男女比例页面
            wmMemeber:function() {
                this.dialogWmVisible = true;
                console.log(1);
            },
            // 打开标识码页面
            codeMemeber:function() {
                this.dialogCodeVisible = true;
                console.log(1);
            },
            // 支系简介
            memberDetail:function () {
                // 获取家庭成员详情并显示
                // layui.use(['layer'], function () {
                //     var layer = layui.layer;
                //     layer.open({
                //         shadeClose:true,
                //         type:1,
                //         area:'90%',
                //         title:'详情',
                //         content:$('#member_info')
                //     });
                // });
                this.dialogMemeberVisible = true;
            }
        }
    });
})(window);