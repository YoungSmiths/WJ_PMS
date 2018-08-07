<template>
    <div>
        <div class="page-header-menu container">
            <div class="test">
                <ul>
                    <li>
                        <router-link class="title" :to="{name: 'home'}">概览</router-link>
                    </li>
                    <li>
                        <router-link class="title" :to="{name: 'systemList'}">业务系统</router-link>
                    </li>
                    <li>
                        <router-link class="title" :to="{name: 'packageList'}">软件包管理</router-link>
                    </li>
                    <li>
                        <router-link class="title" :to="{name: 'nodeList'}">节点信息</router-link>
                    </li>
                    <li>
                        <router-link class="title" :to="{name: 'moduleList'}">业务模块</router-link>
                    </li>
                    <li>
                        <router-link class="title" :to="{name: 'alertEventList'}">监控报警</router-link>
                    </li>
                    <li>
                        <router-link class="title" :to="{name: 'operationRecordList'}">操作日志</router-link>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script type="text/ecmascript-6">
    export default {
        components: {},
        computed: {},
        methods: {},
        mounted () {
        },
        watch: {}
    }

</script>
<style>
    .page-header-menu {
        background: #5bb0e0;
    }

    .page-header-menu {
        display: block;
        height: 41px;
        clear: both;
    }

    .test {
        margin: auto;
    }

    .test ul {
        float: left;
        margin-left: 10px;
        margin-top: 11px;
        list-style: none;
    }

    .test li {
        float: left;
        /* width: 80px; */
        margin-left: 35px;
        margin-right: 35px;
        line-height: 23px;
        font-family: inherit;
        font-size: 16px;
    }

    .title {
        color: #FFF;
    }

    .title:hover {
        color: #204d74;
    }
</style>
