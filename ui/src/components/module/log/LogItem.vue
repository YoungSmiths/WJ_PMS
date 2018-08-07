<template>
    <tr id='logItem'>
        <td>
            {{log.id}}
        </td>
        <td class='id'>
            {{log.action}}
        </td>
        <td>{{log.newContent}}</td>
        <td id='buildTime'>{{log.createTime | datetime}}</td>
      <!--  <td class='icon'>
            <router-link :to="{name: log.target}" :disabled="!$store.state.user.token">
                {{log.target}}
            </router-link>
        </td>-->
        <td>{{log.user ? log.user.displayName : 'N/A' }}</td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['log'],

        computed: {},
        methods: {
            jumpToDetail () {
                // this.$router.push('/business/system/' + this.system.id);
            }
        },
        mounted () {
        }
    }

</script>
<style>
</style>
