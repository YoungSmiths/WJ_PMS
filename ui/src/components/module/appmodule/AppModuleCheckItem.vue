<template>
    <tr id="moduleCheckItem">
        <td>
            {{moduleCheck.id}}
        </td>
        <td>
            <router-link
                :to="{name: 'moduleCheckDetail', params: { moduleId:moduleCheck.appModule.id, moduleCheckId: moduleCheck.id}}">
                {{moduleCheck.url}}
            </router-link>
        </td>
        <td>
            {{moduleCheck.createTime | datetime}}
        </td>
        <td class='icon'>
            <div class="btn build">
                <router-link
                    :to="{name: 'moduleCheckDetail',  params: {  moduleId:moduleCheck.appModule.id,moduleCheckId: moduleCheck.id}}">
                    <span title='详情'></span>
                </router-link>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['moduleCheck'],
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
