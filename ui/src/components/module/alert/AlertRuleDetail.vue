<template>
    <div>
        <div class="panel-body">
            <table class="mainDetailTable" cellspacing="0" v-if="rule != null">
                <thead>
                <tr>
                    <th style="width: 30%;">属性</th>
                    <th style="width: 70%">值</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>id</td>
                    <td>{{ rule.id }}</td>
                </tr>
                <tr>
                    <td>创建时间</td>
                    <td>{{ rule.createTime | datetime }}</td>
                </tr>
                <tr>
                    <td>目标用户</td>
                    <td>
                        {{rule.user && rule.user.name}}
                    </td>
                </tr>
                <tr>
                    <td>级别</td>
                    <td>
                        <label :class='"level" + rule.level'>
                            {{rule.level|levelToDescription}}
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>名称</td>
                    <td>
                        {{rule.name}}
                    </td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td>{{rule.description}}</td>
                </tr>
                <tr>
                    <td>检查条件</td>
                    <td>
                        {{rule.compareCondition}}
                    </td>
                </tr>
                <tr>
                    <td>阀值</td>
                    <td>{{rule.threshold}}</td>
                </tr>
                <tr>
                    <td>最大报警次数</td>
                    <td>{{rule.lastPeriodCount}}</td>
                </tr>
                <tr>
                    <td>默认接收人</td>
                    <td>{{rule.user ? rule.user.name : '-'}}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script type="text/ecmascript-6">
    import $ from 'jquery'
    export default {
        components: {},
        data () {
            return {}
        },
        computed: {
            rule () {
                return this.$store.state.business.rule;
            }
        },
        created () {
            this.getAlertRuleDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getAlertRuleDetail(to);
            next();
        },
        methods: {
            getAlertRuleDetail (route) {
                let ruleId = parseInt(route.params.alertRuleId);
                this.$store.dispatch('alertRuleOperation', {action: 'get', rule: {id: ruleId}});
            }
        }
    }
</script>
<style>

</style>
