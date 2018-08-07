<template>
    <tr id='systemItem'>
        <td>
            {{system.id}}
        </td>
        <td class='id'>
            <router-link :to="{name: 'systemDetail', params: { systemId: system.id}}">
                {{system.name}}
            </router-link>
        </td>

        <td id='buildTime'>{{system.createTime | datetime}}</td>
        <td class='icon'>
            <div class="btn build" @click="jumpToDetail">
                <span title='查看系统'>
                </span>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['system'],

        computed: {},
        methods: {
            jumpToDetail () {
                this.$router.push('/business/system/' + this.system.id);
            }
        },
        mounted () {
        }
    }

</script>
<style>

</style>
