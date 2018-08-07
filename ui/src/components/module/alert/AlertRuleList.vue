<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th style="width: 5%">ID</th>
                <th style="width: 15%">创建时间</th>
                <th style="width: 5%">级别</th>
                <th style="width: 8%">名称</th>
                <th style="width: 27%">描述</th>
                <th style="width: 10%">判断条件</th>
                <th style="width: 8%">阀值</th>
                <th style="width: 12%">最大报警次数</th>
                <th style="width: 10%">接收人</th>
            </tr>
            </thead>
            <tbody>
            <AlertRuleItem v-for="rule in ruleList" :rule="rule" :key="rule.id"></AlertRuleItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import AlertRuleItem from './AlertRuleItem.vue'
    import $ from 'jquery'
    export default {
        components: {AlertRuleItem},
        data () {
            return {}
        },
        computed: {
            ruleList () {
                return this.$store.state.business.ruleList;
            }
        },
        methods: {
            getAlertList () {
                this.$store.dispatch('alertRuleOperation', {action: 'list'});
            }
        },
        created () {
            this.getAlertList();
        }
    }
</script>
<style>
</style>

