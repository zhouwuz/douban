<template>
    <div id="myChart" :style="{width: '800px', height: '600px'}"></div>
</template>
<script>
    import axios from 'axios'
    import *as echarts from 'echarts'
    export default {
        name: 'Echarts',
        mounted(){
            let _this=this;

            axios.get("http://localhost:9091/rank_5/select").then(function (response) {
                //基于准备好的dom，初始化echarts实例
                let myChart = _this.$echarts.init(document.getElementById('myChart'));

                // 绘制图表
                myChart.setOption({

                    title: {
                        text: '年代电影数量柱状图',
                        textStyle:{
                            color:"#959FB2",
                            fontSize:12
                        },
                        x:'center',
                        top:"30px"
                    },
                    grid: {
                        left: '3%',
                        right: '8%',
                        bottom: '18%',
                        containLabel: true
                    },
                    xAxis : {
                        type: 'value',
                        axisTick: {//去掉坐标轴刻线
                            show: true
                        },
                        splitLine :{
                            show:true
                        },
                        axisLine:{//x轴
                            lineStyle:{
                                color:'#6892DE',     //X轴的颜色
                            },
                        },
                    },
                    yAxis : {
                        type: 'category',
                        data: response.data.year,
                        axisTick: {           //去掉坐标轴刻线
                            show: true
                        },
                        axisLine:{
                            lineStyle:{
                                color:'#6892DE',     //y轴的颜色
                            },
                        },
                    },
                    series : [
                        {
                            name: '环比交错',
                            type: 'bar',
                            stack: '总量',
                            barWidth : 16,//柱图宽度
                            label: {
                                normal: {
                                    show: true,
                                    position: 'right',
                                    color: '#65BFCB',
                                    fontSize:12,
                                    formatter: '{c}部'
                                },
                            },
                            itemStyle:{
                                barBorderRadius:[0, 10, 10, 0], //圆角位置，左上、右上、右下、左下圆角
                                color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                                    offset: 0,
                                    color: '#5187E4'
                                }, {
                                    offset: 1,
                                    color: '#65C0CA'
                                }]),
                            },
                            data: response.data.num
                        },
                    ]


                    // title: {
                    //     text: '水果销量统计',
                    //     left: 'center',
                    //     top: 20,
                    //     textStyle: {
                    //         color: '#555555'
                    //     }
                    // },
                    // tooltip: {},
                    // xAxis: {
                    //     data: response.data.score
                    // },
                    // yAxis: {},
                    // series: [{
                    //     name: '销量',
                    //     type: 'bar',
                    //     data: response.data.num
                    // }]
                });
            });
        }
    }
</script>
