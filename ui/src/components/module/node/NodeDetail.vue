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
            <tr v-if="node.id">
                <td>ID</td>
                <td>{{node.id}}</td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input type="text" v-model="node.address">
                </td>
            </tr>
            <tr v-if="node.id">
                <td>创建时间</td>
                <td>
                    {{node.createTime|datetime}}
                </td>
            </tr>
            <tr v-if="node.id">
                <td>最后连接时间</td>
                <td>
                    {{node.lastConnectionTime|datetime}}
                </td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!editable" @click="editable = true;">修改</button>
                    <button v-if="editable" @click="updateNode(); editable = false;">保存</button>
                    <button v-if="this.node.id" @click="deleteNode();">删除</button>
                </td>
            </tr>
            <tr v-if="node.id">
                <td>任务列表</td>
                <td>
                    <table class="itemListTable">
                        <thead>
                        <tr>
                            <th width="10%">任务名称</th>
                            <th width="10%">所属作业</th>
                            <th width="50%">软件包版本</th>
                            <th width="10%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <TaskItem v-for="task in node.taskList" :task="task" :showJobAndSystem="true"
                                  :hideNode="true" key="task.id"></TaskItem>
                        </tbody>
                    </table>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import TaskItem from './../system/TaskItem.vue'
    export default {
        components: {TaskItem},
        data () {
            return {
                editable: false
            }
        },
        computed: {
            node() {
                return this.$store.state.business.node;
            }
        },
        created () {
            this.getNodeDetail(this.$route);
        },
        beforeRouteUpdated (to, from, next) {
            this.getNodeDetail(to);
            next();
        },
        methods: {
            getNodeDetail(route) {
                let nodeId = parseInt(route.params.nodeId);
                if (nodeId) {
                    this.$store.dispatch('nodeOperation', {action: 'get', node: {id: nodeId}});
                    this.editable = false;
                } else {
                    this.$store.commit('UPDATE_BUSINESS_BY_NAME', {
                        name: 'node', value: {
                            id: 0,
                            address: null,
                        }
                    });
                    this.editable = true;
                }
            },
            updateNode() {
                this.$store.dispatch('nodeOperation', {action: "update", node: this.node}).then((node) => {
                    this.$router.push({name: 'nodeDetail', params: {nodeId: node.id}});
                });
            },
            deleteNode() {
                if (!confirm("删除节点以及该节点上的任务，确认删除？")) {
                    return;
                }
                this.$store.dispatch("nodeOperation", {action: "delete", node: {id: this.node.id}}).then((data) => {
                    this.$router.push({name: 'nodeList'});
                });
            }
        }
    }
</script>
<style>
</style>

