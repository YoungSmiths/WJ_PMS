<template>
    <div>
        <table class="mainDetailTable" cellspacing="0">
            <thead>
            <tr>
                <th>属性</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr v-if="job.id">
                <td>ID</td>
                <td>
                    {{job.id}}
                </td>
            </tr>
            <tr v-if="job.system">
                <td>所属系统</td>
                <td>
                    <router-link :to="{name: 'systemDetail', params: {systemId: job.system.id}}">
                        {{job.system.name}}
                    </router-link>
                </td>
            </tr>
            <tr>
                <td>名字</td>
                <td>
                    <input type="text" name="name" v-model="job.name" :disabled="!editable"></input>
                </td>
            </tr>
            <tr v-if="job.id">
                <td>创建时间</td>
                <td>{{job.createTime | datetime}}</td>
            </tr>
            <tr>
                <td>部署路径</td>
                <td><input type="text" name="name" v-model="job.path" :disabled="!editable"></input></td>
            </tr>
            <tr>
                <td>状态检查规则</td>
                <td><textarea class="statusCheckRule" v-model="job.statusCheckRule" :disabled="!editable"
                              :readonly="!editable">
                            </textarea></td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!editable" @click="editable = true;">修改</button>
                    <button v-if="editable" @click="updateJob(); editable = false;">保存</button>
                    <button v-if="this.job.id" @click="deleteJob();">删除</button>
                </td>
            </tr>
            <tr v-if="job.id">
                <td>任务列表</td>
                <td>
                    <button class="btn btn-pri import-btn fr" @click="jumpToCreateTask();">添加任务</button>
                    <table class="itemListTable" cellspacing="0">
                        <thead>
                        <tr>
                            <th width="10%">任务名称</th>
                            <th width="10%">节点IP</th>
                            <th width="30%">软件包版本</th>
                            <th width="10%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <TaskItem v-for="task in job.taskList" :task="task" :key="task.id"></TaskItem>
                        </tbody>
                    </table>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import TaskItem from './TaskItem.vue'
    export default {
        components: {TaskItem},
        data () {
            return {
                editable: false
            }
        },
        computed: {
            job: function () {
                return this.$store.state.business.job;
            }
        },
        created(){
            this.getJobDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getJobDetail(to);
            next();
        },
        methods: {
            getJobDetail(route) {
                let jobId = parseInt(route.params.jobId);
                if (jobId) {
                    this.$store.dispatch('jobOperation', {action: "get", job: {id: jobId}});
                } else {
                    this.$store.commit('SET_JOB', {
                        id: 0,
                        name: null,
                        path: null,
                        statusCheckRule: null,
                        system: null
                    });
                    this.$store.dispatch('systemOperation', {
                        action: 'get',
                        system: {id: parseInt(route.params.systemId)}
                    }).then((system) => {
                        this.job.system = system;
                    }, (data) => {
                        this.$router.go(-1);
                    });
                    this.editable = true;
                }
            },
            updateJob() {
                this.$store.dispatch('jobOperation', {action: "update", job: this.job}).then((job) => {
                    this.$router.push({name: 'jobDetail', params: {jobId: job.id}});
                });
            },
            deleteJob() {
                if (!confirm("确认删除作业？")) {
                    return;
                }
                let systemId = this.job.system.id;
                this.$store.dispatch("jobOperation", {action: "delete", job: this.job}).then((data) => {
                    this.$router.push({name: 'systemDetail', params: {systemId: systemId}});
                });
            },
            jumpToCreateTask() {
                this.$router.push({name: 'jobTaskDetail', params: {jobId: this.job.id, taskId: 0}});
            }
        }
    }

</script>
<style>
    .statusCheckRule {
        background-color: #EEE;
    }
</style>
