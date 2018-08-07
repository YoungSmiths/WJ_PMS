<template>
    <tr id="moduleItem">
        <td>
            {{module.id}}
        </td>
        <td>
            <router-link :to="{name: 'systemDetail', params: { systemId: this.module.system.id}}">
                {{module.system.name}}
            </router-link>
        </td>
        <td>
            <router-link :to="{name: 'moduleDetail', params: { moduleId: this.module.id}}">
                {{module.name}}
            </router-link>
        </td>
        <td id='buildTime'>
            {{module.createTime | datetime}}
        </td>
        <td class='icon'>
            <div class="btn build">
                <router-link :to="{name: 'moduleDetail', params: { moduleId: this.module.id}}">
                    <span title='详情'></span>
                </router-link>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['module'],
        computed: {},
        methods: {},
        mounted () {
        },
        created () {
        }
    }
</script>
<style>
</style>
