$(function () {
    // 男女分布
    var maleChart = echarts.init(document.getElementById('male_dis'));
    // 年龄分布
    var ageChart = echarts.init(document.getElementById('age_dis'));

    // 指定图表的配置项和数据
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

    var ageOption = {
        title : {
            text: '年龄分布',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: []
        },
        series : [
            {
                name: '访问来源',
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

    // 使用刚指定的配置项和数据显示图表。
    maleChart.setOption(maleOption);
    ageChart.setOption(ageOption);

    $.ajax({
        type:"POST",
        url:"/count/c_index_data",
        data:{
            memberFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID,
            type:2
        },
        success:function (r) {
            // console.log(r);
            var d = r.data[0];
            maleChart.setOption({
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
            var arr = [], ageName = [];
            d.forEach(function (v, i) {
                var o= {};
                o.value = v.nums;
                o.name = v.age + '岁';
                ageName.push(o.name);
                arr.push(o);
            })
            ageChart.setOption({
                legend: {
                    data: ageName
                },
                series: [{
                    data: arr
                }]
            })
        },
        error:function (r) {
            console.error('年龄分布数据获取失败')
        }
    });
});