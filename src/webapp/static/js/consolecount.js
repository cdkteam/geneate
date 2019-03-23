window.onload = function () {
    // 用户日活跃量
    var dayChart = echarts.init(document.getElementById("dayCount"));
    // 男女比例
    var sexChart = echarts.init(document.getElementById("sexCount"));

    var date = new Date();

    var days = date.getDate();

    var dayArray = [], dataArray = [];

    var dayCount = {
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


    dayChart.setOption(dayCount);
    sexChart.setOption(sexOption);

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

    $.ajax({
        type:"POST",
        url:"/count/c_index_sex",
        success:function (r) {
            console.log(r);
            var d = r.data;
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