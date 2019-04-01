window.onload = function () {
    // 用户日活跃量容器初始化
    var dayChart = echarts.init(document.getElementById("dayCount"));
    // 男女比例容器初始化
    var sexChart = echarts.init(document.getElementById("sexCount"));

    // dayArray：每日用户活跃数图x轴坐标数据；dataArray：每日用户活跃数图y轴坐标数据。数据来源为后台数据
    var dayArray = [], dataArray = [];

    // 初始化每日用户活跃量图参数
    var dayOption = {
        title:{
            text:"本月每日用户活跃数"
        },
        tooltip:{
            trigger:'axis',
            formatter:"本月{b}号 <br> 用户活跃数：{c} 人"
        },
        xAxis: {
            name:"日",
            type: 'category',
            data: []
        },
        yAxis: {
            name:"用户活跃量",
            type: 'value'
        },
        series: [{
            data: [],
            type: 'line',
            smooth: true
        }]
    };

    // 初始化男女比例图参数
    var sexOption = {
        title : {
            text: '男女比例',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c}人 ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男','女']
        },
        series : [
            {
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 容器设置参数
    dayChart.setOption(dayOption);
    sexChart.setOption(sexOption);

    // 异步获取每日用户活跃量数据
    $.ajax({
        type:"POST",
        url:"/daily/d_list",
        success:function (r) {
            for(var i = 0;i < r.data.length;i++) {
                dayArray.push(r.data[i].time);
                dataArray.push(r.data[i].number);
            }

            dayChart.setOption({
                xAxis: {
                    data: dayArray
                },
                series: [{
                    data: dataArray
                }]
            });

        }
    });

    // 异步获取男女比例数据
    $.ajax({
        type:"POST",
        url:"/count/c_index_data",
        data:{
            type:2
        },
        success:function (r) {
            // console.log(r);
            var d = r.data[0];
            sexChart.setOption({
                series: [{
                    data: [
                        {value: d.boys, name:"男"},
                        {value: d.girls, name:"女"}
                    ]
                }]
            })
        },
        error:function (r) {
            console.error('男女比例数据获取失败')
        }
    });

}