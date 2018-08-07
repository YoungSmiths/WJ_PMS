<template>
    <tr>
        <td>
            <router-link :to="{name: 'alertRuleDetail', params: {alertRuleId: rule.id}}">
                {{rule.id}}
            </router-link>
        </td>
        <td>
            {{rule.createTime|datetime}}
        </td>
        <td>
            <label :class='"level" + rule.level'>
                {{rule.level|levelToDescription}}
            </label>
        </td>
        <td>
            <router-link :to="{name: 'alertRuleDetail', params: {alertRuleId: rule.id}}">
                {{rule.name}}
            </router-link>
        </td>
        <td>
            {{rule.description|truncate(20)}}
        </td>
        <td>
            {{rule.compareCondition}}
        </td>
        <td>
            {{rule.threshold}}
        </td>
        <td>
            {{rule.lastPeriodCount}}
        </td>
        <td>
            {{rule.user.name}}
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['rule'],
        methods: {}
    }
</script>
<style>
</style>

