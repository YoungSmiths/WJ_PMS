<template>
    <tr id="packageItem">
        <td>
            {{package.id}}
        </td>
        <td>
            <router-link :to="{name: 'systemDetail', params: { systemId: package.job.system.id}}">
                {{package.job.system.name}}
            </router-link>
        </td>
        <td>
            <router-link :to="{name: 'jobDetail', params: { jobId: package.job.id}}">
                {{package.job.name}}
            </router-link>
        </td>
        <td>
            <router-link :to="{name: 'packageDetail', params: { packageId: package.id}}">
                {{package.versionMd5}}
            </router-link>
        </td>
        <td>
            {{package.createTime | datetime}}
        </td>
        <td>
            <label :class="this.package.confirmed ? 'confirmed' : 'unconfirmed'">{{ this.package.confirmed ? '合规' :
                '未确认' }}</label>
        </td>
        <td class='icon'>
            <router-link :to="{name: 'packageDetail', params: { packageId: package.id}}">
                详情
            </router-link>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['package'],

        computed: {
        },

        methods: {
        },

        mounted () {
        },

        created () {
        }
    }
</script>
<style>
</style>

