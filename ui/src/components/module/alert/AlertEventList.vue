<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th style="width: 5%">ID</th>
                <th style="width: 13%">报警时间</th>
                <th style="width: 8%">目标用户</th>
                <th style="width: 5%">级别</th>
                <th style="width: 40%">主题</th>
                <th style="width: 8%">是否处理</th>
                <th style="width: 8%">处理人</th>
                <th style="width: 13%">处理时间</th>
            </tr>
            </thead>
            <tbody>
            <AlertEventItem v-for="alert in alertList" :alert="alert" :key="alert.id"></AlertEventItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import AlertEventItem from './AlertEventItem.vue'
    import $ from 'jquery'
    export default {
        components: {AlertEventItem},
        data () {
            return {}
        },
        computed: {
            alertList () {
                return this.$store.state.business.eventList;
            }
        },
        methods: {
            getAlertList () {
                this.$store.dispatch('alertEventOperation', {action: 'list'});
            }
        },
        created () {
            this.getAlertList();
        }
    }
</script>
<style>
</style>

