<template>
    <tr id='taskItem'>
        <td>
            <router-link :to="{name: 'taskDetail', params: {taskId: task.id}}">
                {{task.name}}
            </router-link>
        </td>
        <td v-if="!hideNode">
            <router-link :to="{name: 'nodeDetail', params: {nodeId: task.node.id}}" v-if="task.node">
                {{task.node.address}}
            </router-link>
        </td>
        <td v-if="showJobAndSystem">
            <router-link :to="{name: 'systemDetail', params: {systemId: task.job.system.id}}">
                {{task.job.system.name}}
            </router-link>
            &nbsp;/&nbsp;
            <router-link :to="{name: 'jobDetail', params: {jobId: task.job.id}}">
                {{task.job.name}}
            </router-link>
        </td>
        <td>
            <span v-if="task.pkg">
                <router-link :to="{name: 'packageDetail', params: {packageId: task.pkg.id}}">
                    <label :class="task.pkg.confirmed ? 'confirmed' : 'unconfirmed'">
                        {{task.pkg.versionMd5}}
                    </label>
                </router-link>
            </span>
        </td>
        <td class='icon'>
            <div class="btn build">
                <router-link :to="{name: 'taskDetail', params: {taskId: task.id}}">
                    <span title='详情'></span>
                </router-link>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['task', 'hideNode', 'showJobAndSystem'],

        computed: {},
        methods: {},
        mounted () {
            if (this.task.isLast) {
                let tableData = this.appConfig.dataTableChinese('用户名');
                tableData.searching = true;
                let table = $('.task-table').DataTable(tableData);
                $('.search-input-name').on('keyup change', function () {
                    table
                        .column(1)
                        .search(this.value)
                        .draw();
                });
                $('.search-input-desc').on('keyup change', function () {
                    table
                        .column(2)
                        .search(this.value)
                        .draw();
                });
            }

        }
    }

</script>
<style>

</style>
