<template>
    <div>
        <table class="mainDetailTable" cellspacing="0" v-if="alert != null">
            <thead>
            <tr>
                <th style="width: 30%;">属性</th>
                <th style="width: 70%">值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>id</td>
                <td>{{ alert.id }}</td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td>{{ alert.createTime | datetime }}</td>
            </tr>
            <tr>
                <td>报警规则</td>
                <td>
                    <router-link :to="{name: 'alertRuleDetail', params: {alertRuleId: alert.rule.id}}" v-if="alert.rule">
                        {{alert.rule.description}}
                    </router-link>
                    <label v-else>-</label>
                </td>
            </tr>
            <tr>
                <td>目标用户</td>
                <td>
                    {{alert.user && alert.user.name}}
                </td>
            </tr>
            <tr>
                <td>报警源</td>
                <td>{{alert.sourceUri}}</td>
            </tr>
            <tr>
                <td>报警级别</td>
                <td>
                    <label :class='"level" + alert.level'>
                        {{alert.level | levelToDescription }}
                    </label>
                </td>
            </tr>
            <tr>
                <td>报警主题</td>
                <td>
                    <span :title="alert.subject">{{alert.subject}}</span>
                </td>
            </tr>
            <tr>
                <td>报警内容</td>
                <td>
                    <span :title="alert.content">{{alert.content}}</span>
                </td>
            </tr>
            <tr>
                <td>是否确认</td>
                <td>
                    {{alert.confirmed ? '是' : '否'}}&nbsp;&nbsp;
                    <button v-if="!alert.confirmed" @click="confirmAlert()">
                        确&nbsp;认
                    </button>
                </td>
            </tr>
            <tr>
                <td>确认人</td>
                <td>
                    {{alert.confirmedBy ? alert.confirmedBy.name : '-'}}
                </td>
            </tr>
            <tr>
                <td>确认时间</td>
                <td>
                    {{alert.confirmedTime | datetime}}
                </td>
            </tr>
            </tbody>
        </table>
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
            alert () {
                return this.$store.state.business.event;
            }
        },
        created () {
            this.getAlertEventDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getAlertEventDetail(to);
            next();
        },
        methods: {
            getAlertEventDetail (route) {
                let alertId = parseInt(route.params.alertEventId);
                this.$store.dispatch('alertEventOperation', {action: 'get', event: {id: alertId}});
            },
            confirmAlert() {
                if (window.confirm("确认报警已处理？")) {
                    this.$store.dispatch("alertEventOperation", {
                        action: 'update', event: {
                            id: this.alert.id,
                            confirmed: true
                        }
                    });
                }
            }
        }
    }
</script>
<style>

</style>
