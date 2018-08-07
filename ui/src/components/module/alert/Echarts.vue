<template>
    <div>
        <!-- 逻辑 -->
        <div class="wrapper">
            <table>
                <tbody>
                <tr id="select">
                    <td class="selectName" style="float:left">
                        <span>时间跨度</span>
                    </td>
                    <td style="float:left;width: 120px">

                        <single-select class="selectItem" v-bind:optionsdata="single.timeOptions"
                                       v-bind:selecteddata="single.timeSelected"
                                       @selected="singleTimeCallback"></single-select>
                    </td>
                    <td class="selectName" style="float:left">
                        <span>指标</span>
                    </td>
                    <td style="float:left">
                        <single-select class="selectItem" v-bind:optionsdata="single.indexOptions"
                                       v-bind:selecteddata="single.indexSelected"
                                       v-on:selected="singleIndexCallback" style="width:120px">
                        </single-select>
                    </td>
                    <td style="float:left">
                        <div>
                            <button class="submit" id="submit" @click="submit(1)">提交</button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div id="main" style="width: 950px;height:450px;"></div>
    </div>
</template>
<script type="text/ecmascript-6">
    require("../../utils/select-vue-component.js");
    let echarts = require('echarts');

    export default {
        props: ['showData'],
        data() {
            return {
                single: {
                    timeOptions: [],
                    timeSelected: {},
                    indexOptions: [],
                    indexSelected: {}
                }
            }
        },
        computed: {
            chartData(){
                return this.$store.state.chartData
            }
        },
        methods: {
            submit(flag){
                let node = new Array();
                let param;
                if (flag === 1) {
                    param = {
                        "name": this.single.indexSelected.id,
                        "node": node,
                        "period": this.single.timeSelected.id
                    }
                } else if (flag === 0) {
                    param = {
                        "name": "cpu.user.percent",
                        "node": "",
                        "period": "60-T"
                    }
                }
                this.$store.dispatch('getChartdata', param).then((data) => {
                        this.drawPie(data);
                    }
                );

            },
            querySelectData: function () {
                let mySelf = this
                // 时间
                mySelf.single.timeOptions = [{"id": "30-T", "name": "最近30分钟"}, {"id": "60-T", "name": "最近1小时"}, {
                    "id": "6-H",
                    "name": "最近6小时"
                }, {
                    "id": "24-H", "name": "最近1天"
                }, {"id": "7-D", "name": "最近1周"}, {"id": "30-D", "name": "最近1月"}, {"id": "90-D", "name": "最近3月"}];
                mySelf.single.timeSelected = {"id": "60-T", "name": "最近1小时"}

                // 指标
                mySelf.single.indexOptions = [{"id": "cpu.user.percent", "name": "CPU"}, {
                    "id": "mem.used.percent",
                    "name": "内存"
                }];
                //默认选择的指标列表
                mySelf.single.indexSelected = {"id": "cpu.user.percent", "name": "CPU"}

            },
            singleTimeCallback: function (data) {
                this.getBackEndData();
                this.single.timeSelected = data;
            },
            singleIndexCallback: function (data) {
                this.getBackEndData();
                this.single.indexSelected = data;
            },
            multipleCallback: function (data) {
                this.getBackEndData();
                this.multiple.nodeSelectedList = data;
            },
            getDrawData(data){
                let Y = new Array();
                let names = new Array();
                for (let key in data.Y) {
                    names.push(key)
                    Y.push(
                        {
                            name: key,
                            type: 'line',
                            data: data.Y[key],
                            markPoint: {
                                data: [
                                    {type: 'max', name: '最大值'},
                                    {type: 'min', name: '最小值'}
                                ]
                            },
                            markLine: {
                                data: [
                                    {type: 'average', name: '平均值'}
                                ]
                            }
                        }
                    );
                }
                let option = {
                    title: {
                        text: '资源使用率情况',
                        subtext: '百分比',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: names,
                        orient: 'vertical',
                        x: 'right',
                        y: '40px'
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            /* dataZoom: {
                             yAxisIndex: 'none'
                             },*/
                            dataView: {readOnly: true},
                            magicType: {type: ['line', 'bar']},
                            /*  restore: {},*/
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: true,
                        data: data.X
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} %'
                        }
                    },
                    series: Y
                };
                return option;
            },
            drawPie(data)
            {
                let myChart = echarts.init(document.getElementById('main'));
                myChart.clear();
                myChart.setOption(this.getDrawData(data))
            }
        },
        mounted()
        {
            this.querySelectData();
        },
        created()
        {
            this.submit(0);
        }
    }
</script>
<style>
    .selectName {
        float: right;
        margin: 8px;
        font-family: Microsoft Yahei;
        margin-left: 20px
    }

    .submit {
        margin-left: 20px;
        width: 80px;
        height: 35px;
        font-size: 16px;
        float: left;
        border: 0;
        BackColor: #fbfdff
    }

</style>
