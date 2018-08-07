<template>
    <div>
        <table id="systemDetailTable" class="mainDetailTable" cellspacing="0">
            <thead>
            <tr>
                <th>属性</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr v-if="system.id">
                <td>ID</td>
                <td>{{system.id}}</td>
            </tr>
            <tr>
                <td>名称</td>
                <td>
                    <input type="text" name="name" v-model="system.name" :disabled="!editable"></input>
                </td>
            </tr>
            <tr>
                <td>访问信息</td>
                <td>
                    <textarea type="text" name="name" v-model="system.cert" :disabled="!editable"></textarea>
                </td>
            </tr>
            <tr v-if="system.id">
                <td>创建时间</td>
                <td>{{this.system.createTime | datetime}}</td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!editable" @click="editable = !editable;">修改</button>
                    <button v-if="editable" @click="updateSystem();">保存</button>
                    <button v-if="!editable && this.system.id" @click="deleteSystem();">删除</button>
                </td>
            </tr>


            <tr v-if="system.id">
                <td>
                    模块列表
                </td>
                <td>
                    <button class="btn btn-pri import-btn fr" @click="jumpToCreateModule();">添加模块</button>
                    <table class="itemListTable" cellspacing="0" border="1px">
                        <thead>
                        <tr>
                            <th style="width: 10%;">ID</th>
                            <th style="width: 15%;">所属系统</th>
                            <th style="width: 30%;">模块名称</th>
                            <th style="width: 25%;">创建时间</th>
                            <th style="width: 20%;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <ModuleItem v-for="module in system.appModuleList" :module="module"
                                    :key="module.id"></ModuleItem>
                        </tbody>
                    </table>
                </td>
            </tr>

            <tr v-if="system.id">
                <td>
                    作业列表
                </td>
                <td>
                    <button class="btn btn-pri import-btn fr" @click="jumpToCreateJob();">添加作业</button>
                    <table class="itemListTable" cellspacing="0" border="1px">
                        <thead>
                        <tr>
                            <th style="width: 10%;">作业ID</th>
                            <th style="width: 15%;">作业名称</th>
                            <th style="width: 55%;">作业部署绝对路径</th>
                            <th style="width: 20%;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <JobItem v-for="job in system.jobList" :job="job" :key="job.id"></JobItem>
                        </tbody>
                    </table>
                </td>
            </tr>

            <tr v-if="system.id">
                <td>
                    任务列表
                </td>
                <td>
                    <button class="btn btn-pri import-btn fr" @click="jumpToAllTaskList();">所有任务</button>
                    <table class="itemListTable" cellspacing="0" border="1px">
                        <thead>
                        <tr>
                            <th style="width: 10%;">任务名称</th>
                            <th style="width: 15%;">节点IP</th>
                            <th style="width: 55%;">软件包版本</th>
                            <th style="width: 20%;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <TaskItem v-for="task in system.taskList" :task="task" :key="task.id"></TaskItem>
                        </tbody>
                    </table>
                </td>
            </tr>

            <tr v-if="system.id">
                <td>
                    结点列表
                </td>
                <td>
                    <button class="btn btn-pri import-btn fr" @click="jumpToAllNodeList();">所有节点</button>
                    <table class="itemListTable" cellspacing="0" border="1px">
                        <thead>
                        <tr>
                            <th style="width: 10%;">节点ID</th>
                            <th style="width: 15%;">节点IP</th>
                            <th style="width: 55%;">最后连接时间</th>
                            <th style="width: 20%;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <NodeItem v-for="node in system.nodeList" :node="node" :key="node.id"></NodeItem>
                        </tbody>
                    </table>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import NodeItem from '../node/NodeItem.vue'
    import TaskItem from './TaskItem.vue'
    import JobItem from './JobItem.vue'
    import ModuleItem from '../appmodule/AppModuleItem.vue'
    export default {
        components: {JobItem, TaskItem, ModuleItem, NodeItem},
        data () {
            return {
                editable: false
            }
        },
        computed: {
            system: function () {
                return this.$store.state.business.system;
            }
        },
        created() {
            this.getSystemDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getSystemDetail(to);
            next();
        },
        methods: {
            getSystemDetail(route) {
                window.vm = this;
                let systemId = parseInt(route.params.systemId);
                if (systemId) {
                    this.$store.dispatch('systemOperation',
                                            {
                                                action: 'get',
                                                system: {id: systemId}
                                            }
                                        )
                        .then(
                            (data) => {
                                this.editable = false;
                            },
                            (data) => {
                                alert("system of id " + id + " not exist.");
                                this.$router.push({name: 'systemList'});
                            });
                } else {
                    this.$store.commit('UPDATE_BUSINESS_BY_NAME', {
                        name: 'system', value: {
                            id: 0,
                            name: null
                        }
                    });
                    this.editable = true;
                }
            },

            deleteSystem () {
                if (confirm("确认删除？")) {
                    this.$store.dispatch("systemOperation", {action: 'delete', system: this.system}).then((data) => {
                        this.$router.push({name: 'systemList'})
                    }, (data) => {
                        this.appConfig.showErrorAlert(data);
                    });
                }
            },
            updateSystem () {
                this.$store.dispatch('systemOperation', {action: 'update', system: this.system}).then((data) => {
                    this.$router.push({name: 'systemDetail', params: {systemId: data.id}});
                    this.editable = false;
                });
            },
            jumpToCreateJob () {
                this.$router.push({name: 'systemJobDetail', params: {systemId: this.system.id, jobId: 0}});
            },
            jumpToCreateModule(){
                this.$router.push({name: 'systemModuleDetail', params: {systemId: this.system.id, moduleId: 0}});
            },
            jumpToAllTaskList() {
                this.$router.push({name: 'taskList'});
            },
            jumpToAllNodeList() {
                this.$router.push({name: 'nodeList'});
            }
        }
    }
</script>
<style>
    table#systemDetailTable table.itemListTable {
    }
</style>
