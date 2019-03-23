(function () {
    /**
     * 首页逻辑处理
     *
     * **/
    new Vue({
        el:"#app_index",
        data:function () {
            return {
                // 首页轮播图片地址
                myloves:[
                    "static/imgs/ml1.jpg",
                    "static/imgs/ml2.jpg",
                    "static/imgs/ml3.jpg",
                    "static/imgs/ml4.jpg"
                ],// 帖子
                posts:[
                    {
                        id:1,
                        name:'xxx支系',
                        title:'帖子标题',
                        time:'2019-02-24',
                        imgUrl:'static/imgs/ml1.jpg'
                    },
                    {
                        id:2,
                        name:'xxx支系',
                        title:'帖子标题帖子标题帖子标题帖子标题帖子标题',
                        time:'2019-02-25',
                        imgUrl:'static/imgs/ml1.jpg'
                    },
                    {
                        id:3,
                        name:'xxx支系',
                        title:'帖子标题帖子标题帖子标题帖子标题',
                        time:'2019-02-26',
                        imgUrl:'static/imgs/ml1.jpg'
                    },
                    {
                        id:4,
                        name:'xxx支系',
                        title:'帖子标题帖子标题帖子标题帖子标题帖子标题',
                        time:'2019-02-27',
                        imgUrl:'static/imgs/ml1.jpg'
                    },
                    {
                        id:5,
                        name:'xxx支系',
                        title:'帖子标题帖子标题帖子标题帖子标题帖子标题',
                        time:'2019-02-28',
                        imgUrl:'static/imgs/ml1.jpg'
                    }
                ],
            }
        },
        methods:{
            // 打开帖子详情
            newsDetailDialogFunc:function() {
                this.newsDetailDialog = true;
                console.log('打开帖子详情');
            }
        }
    });
})(window);