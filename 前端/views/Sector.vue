<template>
    <div class="sector">
        <div id="myChart" :style="{width: '700px', height: '700px'}"></div>
    </div>
</template>

<script>

    import axios from "axios";

    export default {
        name: 'sector',
        data() {
            return{
                data: [
                    { value: 1048, name: 'Search Engine' },
                    { value: 735, name: 'Direct' },
                    { value: 580, name: 'Email' },
                    { value: 484, name: 'Union Ads' },
                    { value: 300, name: 'Video Ads' }
                ],
            }
        },
        mounted() {

            axios.get('http://localhost:9091/rank_8/select').then((res) => {
                // 读取接口请求成功回传回来的数据
                var rank_8 = res.data.Rank_8
                // 定义数组，存放一会覆盖echarts图形的数据
                var data = []
                // 循环遍历数组，取出数据，转成和data一样的格式
                for(var i = 0; i < rank_8.length; i++) {
                    var d = {name: '', value: 0}
                    d.name = rank_8[i].coun
                    d.value = rank_8[i].num
                    // 往data数组中添加数据
                    data.push(d)
                }
                // 排序，b - a降序——a - b升序
                data.sort((a , b) => b.value - a.value)
                // 覆盖data(){}中全局变量的数据
                this.data = data
                // 画出图形
                this.Draw()
            }).catch((err) => {
                console.log(err)
                alert('请求失败！请检查后端接口！！！！')
            })
        },
        methods: {
            Draw() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart'))

                // 绘制图表
                myChart.setOption({
                    // options配置项
                    tooltip: { //鼠标悬停显示数据
                        trigger: 'item'
                    },

                    legend: {
                        // orient: 'vertical', //垂直显示
                        bottom: 20,  //修改位置
                        left: 'center',
                        icon: 'rect',  // 矩形图例 可修改宽高
                        itemHeight: 14,
                        itemWidth: 10,
                        textStyle: {
                            color: '#F65163'
                        }
                    },
                    series: [
                        {

                            type: 'pie',
                            radius: ['20%', '60%'], // 写成数组是内外半径,就会变成环形
                            center: ['50%', '50%'], // 饼图位置

                            //是饼图类型,这里是玫瑰,每一块区域面积岁数据变化,不加就是连接整齐的环
                            roseType: 'area',

                            avoidLabelOverlap: true,  //禁止标签重叠展示
                            labelLine: {
                                normal: {
                                    length: 2, // 第一段表示线
                                    length2: 60 // 第二段标示线
                                }
                            },
                            itemStyle: {
                                normal: {
                                    label: {
                                        show: true,
                                        formatter: ' {d}%' // 指示线显示百分
                                        // formatter: "{a} <br/>{b} : {c} ({d}%)"
                                        // 有四个数大家可自己试一试有哪一种,还能加标签
                                    }
                                }
                            },
                            // label: {  // 这里加上就不显示指示线了
                            //   show: false,
                            //   position: 'center'
                            // },
                            emphasis: {
                                label: {
                                    show: false
                                }
                            },

                            data: this.data
                        }
                    ]

                })
            }
        }
    }
</script>

