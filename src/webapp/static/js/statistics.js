$(function () {
    // 男女分布
    var maleChart = echarts.init(document.getElementById('male_dis'));
    // 年龄分布
    var ageChart = echarts.init(document.getElementById('age_dis'));

    // 男女分布图配置
    var maleOption = {
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

    // 年龄分布图配置
    var ageOption = {
        title : {
            text: '年龄分布',
            x:'center'
        },
        xAxis: {
            // name:'年龄',
            type: 'category',
            data: ['0-12', '12-18', '18-36', '36-60', '60<']
        },
        // tooltip : {
        //     trigger: 'item',
        //     formatter: "{a} <br/>{b} : {c} ({d}%)"
        // },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: []
        },
        yAxis: {
            name:'数量/年龄',
            minInterval: 1,
            type: 'value'
        },
        series: [{
            data: [],
            type: 'bar'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    maleChart.setOption(maleOption);
    ageChart.setOption(ageOption);

    // 男女比例数据获取
    setInterval(function () {
        $.ajax({
            type:"POST",
            url:"/count/c_index_data",
            data:{
                memberFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID,
                type:2
            },
            success:function (r) {
                // console.log(r);
                var d = r.data, boys = 0,girls = 0;
                // console.log(d);
                if(d.length != 0) {
                    boys = d[0].boys;
                    girls = d[0].girls;
                }
                maleChart.setOption({
                    series: [{
                        data: [
                            {value: boys, name:"男"},
                            {value: girls, name:"女"}
                        ]
                    }]
                })
            },
            error:function (r) {
                console.error('男女比例数据获取失败')
            }
        });
    }, 3000);


    // 年龄分布数据获取
    setInterval(function () {
        $.ajax({
            type:"POST",
            url:"/count/c_index_data",
            data:{
                memberFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID,
                type:3
            },
            success:function (r) {
                console.log(r);
                var d = r.data;
                var arr = [0,0,0,0,0], ageName = [];
                d.forEach(function (v, i) {
                    var age = parseInt(v.age);
                    // console.log(age);
                    if(age >= 0 && age < 12) {
                        arr[0] += 1;
                    }

                    if(age >= 12 && age < 18) {
                        arr[1] += 1;
                    }

                    if(age >= 18 && age < 36) {
                        arr[2] += 1;
                    }

                    if(age >= 36 && age < 60) {
                        arr[3] += 1;
                    }

                    if(age >= 60) {
                        arr[4] += 1;
                    }
                });
                ageChart.setOption({
                    series: [{
                        data: arr
                    }]
                });
            },
            error:function (r) {
                console.error('年龄分布数据获取失败')
            }
        });
    },3000)

});