<template>
    <div>
        <table class="mainDetailTable" id="overviewTable" cellspacing="0" v-if="this.allInfo">
            <thead>
            <tr>
                <th style="width: 40%;">属性</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="name">业务系统数</td>
                <td class="detail">
                    <router-link :to="{name:'systemList'}">
                        {{this.allInfo.systemCount}}
                    </router-link>
                    &nbsp;个
                </td>
            </tr>
            <tr>
                <td>作业数数量</td>
                <td>
                    <router-link :to="{name:'jobList'}">
                        {{this.allInfo.jobCount}}
                    </router-link>
                    &nbsp;个
                </td>
            </tr>
            <tr>
                <td>任务数量</td>
                <td>
                    <router-link :to="{name:'taskList'}">
                        {{this.allInfo.taskCount}}
                    </router-link>
                    &nbsp;个
                </td>
            </tr>

            <tr>
                <td class="name">软件包</td>
                <td class="detail">
                    <router-link :to="{name:'packageList'}">
                        {{this.allInfo.packageCount}}
                    </router-link>
                    &nbsp;个
                </td>
            </tr>

            <tr>
                <td class="name">应用模块数量</td>
                <td class="detail">
                    <router-link :to="{name:'moduleList'}">
                        {{this.allInfo.appModuleCount}}
                    </router-link>
                    个
                </td>
            </tr>


            <tr>
                <td class="name">机器数量</td>
                <td class="detail">
                    <router-link :to="{name:'nodeList'}">
                        {{this.allInfo.nodeCount}}
                    </router-link>
                    &nbsp;台
                </td>
            </tr>
            <!--tr>
                <td class="name">监控和报警</td>
                <td class="detail">
                    <router-link :to="{name:'monitor'}"> 展示监控曲线</router-link>
                </td>
            </tr-->
            <!--tr>
                <td class="name">审计日志</td>
                <td>
                    <router-link :to="{name:'operationRecordList'}">
                        审计日志
                    </router-link>
                </td>
            </tr-->
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    export default {
        components: {},
        data () {
            return {}
        },
        computed: {
            allInfo: function () {
                return this.$store.state.business.allInfo;
            }
        },
        methods: {
            getAllInfo () {
                this.$store.dispatch('homeOperation', 'get');
            }
        },
        created () {
            this.getAllInfo();
        }
    }
</script>
<style>
    table#overviewTable td > a {
        font-size: 30px;
        color: green;
    }

    table#overviewTable td {
        font-size: 13px;;
    }
</style>

