<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th width="10%">任务名称</th>
                <th width="10%">节点IP</th>
                <th width="10%">所属作业</th>
                <th width="30%">软件包版本</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody>
            <TaskItem v-for="task in taskList" :task="task" :key="task.id" :showJobAndSystem="true"></TaskItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import TaskItem from './TaskItem.vue'
    export default {
        components: {TaskItem},
        data () {
            return {}
        },
        computed: {
            taskList: function () {
                return this.$store.state.business.taskList;
            }
        },
        created() {
            this.getTaskList();
        },
        methods: {
            getTaskList() {
                this.$store.dispatch('taskOperation', {action: 'list'});
            }
        }
    }
</script>
<style>
</style>

