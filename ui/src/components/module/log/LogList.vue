<template>
    <div>
        <table class="itemListTable" cellspacing="0" v-if="this.logs">
            <thead id='thead'>
            <tr>
                <th style="width: 10%">日志ID</ths>
                <th style="width: 10%">操作类型</th>
                <th style="width: 55%">日志内容</th>
                <th style="width: 15%">创建时间</th>
                <th style="width: 10%">操作者</th>
            </tr>
            </thead>
            <tbody id='tbody'>
            <LogItem v-for="log in logs" :log="log" :key="log.id"></LogItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import LogItem from './LogItem.vue'
    export default {
        components: {LogItem},
        data () {
            return {}
        },
        computed: {
            logs () {
                return this.$store.state.logs.logs
            }
        },
        methods: {
            getLogs () {
                this.$store.dispatch('getLogs');
            }
        },
        created () {
            this.getLogs();
        }
    }
</script>
<style>
</style>
