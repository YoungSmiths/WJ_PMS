<template>
    <tr class='versionItem'>
        <td>
            <router-link :to="{name: 'packageDetail', params: {packageId: version.pkg.id}}" v-if="version.pkg">
                {{version.pkg.versionMd5}}
            </router-link>
            <label v-else>
                N/A
            </label>
        </td>
        <td>
            <label :class="version.pkg.confirmed ? 'confirmed' : 'unconfirmed'" v-if="version.pkg">
                {{ version.pkg.confirmed ? '合规' : '未确认' }}
            </label>
            <label v-else>
                N/A
            </label>
        </td>
        <td>{{version.startTime | datetime}}</td>
        <td>{{version.endTime | datetime}}</td>
        <td>
            <a title="与前一个版本的对比差异" @click="showTaskVersionRecordDiff">差异</a>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['version'],
        computed: {},
        methods: {
            showTaskVersionRecordDiff() {
                return this.$parent.showTaskVersionRecordDiff(this.version);
            }
        },
        mounted () {
        },
        created () {
        }
    }
</script>
<style>
</style>

