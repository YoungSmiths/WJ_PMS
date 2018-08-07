<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th>作业ID</th>
                <th>作业名称</th>
                <th>作业部署绝对路径</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <JobItem v-for="job in jobList" :job="job" :key="job.id"></JobItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import JobItem from './JobItem.vue'
    export default {
        components: {JobItem},
        data () {
            return {}
        },
        computed: {
            jobList: function () {
                return this.$store.state.business.jobList;
            }
        },
        created() {
            this.getJobList();
        },
        methods: {
            getJobList() {
                this.$store.dispatch('jobOperation', {action: 'list'});
            }
        }
    }
</script>
<style>

</style>
