<template>
    <tr>
        <td>
            <router-link :to="{name: 'alertEventDetail', params: {alertEventId: alert.id}}">
                {{alert.id}}
            </router-link>
        </td>
        <td>
            {{alert.createTime|datetime}}
        </td>
        <td>
            {{alert.user && alert.user.name}}
        </td>
        <td>
            <label :class='"level" + alert.level'>
                {{alert.level | levelToDescription }}
            </label>
        </td>
        <td>
            <router-link :to="{name: 'alertEventDetail', params: {alertEventId: alert.id}}">
                <span :title="alert.subject">{{alert.subject | truncate(50)}}</span>
            </router-link>
        </td>
        <td>
            {{alert.confirmed ? '是' : '否'}}
        </td>
        <td>
            {{alert.confirmedBy ? alert.confirmedBy.name : ''}}
        </td>
        <td>
            {{alert.confirmedTime | datetime}}
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['alert'],
        methods: {}
    }
</script>
<style>
</style>

