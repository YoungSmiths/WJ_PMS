<template>
    <div>
        <table class="mainDetailTable" cellspacing="0" v-if="task">
            <thead>
            <tr>
                <th>属性</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr v-if="task.id">
                <td>ID</td>
                <td>{{task.id}}</td>
            </tr>
            <tr v-if="task.job && task.job.system">
                <td>所属作业</td>
                <td>
                    <router-link :to="{name: 'systemDetail', params: {systemId: task.job.system.id}}">
                        {{task.job.system.name}}
                    </router-link>
                    &nbsp;-&nbsp;
                    <router-link :to="{name: 'jobDetail', params: {jobId: task.job.id}}">
                        {{task.job.name}}
                    </router-link>
                </td>
            </tr>
            <tr>
                <td>名称</td>
                <td><input type="text" v-model="task.name" :disabled="!editable"></td>
            </tr>
            <tr>
                <td>所在节点</td>
                <td>
                    <div v-if="task.node && task.node.id">
                        <router-link :to="{name: 'nodeDetail', params: {nodeId: task.node.id}}"
                                     v-if="task.node.id">
                            {{task.node.address}}
                        </router-link>
                    </div>
                    <div v-if="!task.id">
                                    <span type="radio" v-for="node in nodeList">
                                        <input type="radio" :id="'node_' + node.id" :value="node.id"
                                               v-model="task.node.id">
                                        <label :for="'node_' + node.id">
                                            {{node.address}}
                                        </label>
                                        （<router-link :to="{name: 'nodeDetail', params: {nodeId: node.id}}">
                                        详情
                                    </router-link>）
                                    </span>
                    </div>
                </td>
            </tr>
            <tr v-if="task.id">
                <td>任务状态</td>
                <td>
                    <pre>{{ task.status }}</pre>
                </td>
            </tr>
            <tr v-if="task.id">
                <td>当前版本</td>
                <td>
                                <span v-if="task.pkg">
                                    <router-link :to="{name: 'packageDetail', params: {packageId: task.pkg.id}}">
                                        {{ task.pkg.versionMd5 }}
                                    </router-link>
                                    （
                                    <label :class="task.pkg.confirmed ? 'confirmed' : 'unconfirmed'">
                                        {{ task.pkg.confirmed ? '合规' : '未确认' }}
                                    </label>
                                    ）
                                    <a title="与前一个版本的对比差异" @click="showDiffForCurrentVersion">差异</a>
                                </span>
                    <label v-else>
                        N/A
                    </label>
                </td>
            </tr>
            <tr v-if="task.id">
                <td>任务创建时间</td>
                <td>
                    <pre>{{ task.createTime | datetime }}</pre>
                </td>
            </tr>
            <tr v-if="task.id">
                <td>版本开始时间</td>
                <td>
                    <pre>{{ task.pkgStartTime | datetime }}</pre>
                </td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!editable" @click="editable = true;">修改</button>
                    <button v-if="editable" @click="saveTask(); editable = false;">保存</button>
                    <button v-if="this.task.id" @click="deleteTask();">删除</button>
                </td>
            </tr>
            <tr v-if="task.id">
                <td>版本历史</td>
                <td>
                    <table class="itemListTable" cellspacing="0">
                        <thead>
                        <tr>
                            <th>版本号</th>
                            <th>是否合规</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>查看变化</th>
                        </tr>
                        </thead>
                        <tbody>
                        <TaskVersionRecordItem v-for="version in task.versionList" :version="version"
                                               :key="version.id">
                        </TaskVersionRecordItem>
                        </tbody>
                    </table>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="versionDiffPanel">
            <hr style="width: 100%"/>
            <div>
                            <span style="color: red;">
                                <span>上一个版本：</span>
                                <span v-if="this.previousPackage">
                                    <router-link
                                        :to="{name: 'packageDetail', params: {packageId: this.previousPackage.id}}">
                                        {{this.previousPackage.versionMd5}}
                                    </router-link>
                                </span>
                                <span v-else>nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn</span>
                            </span>
                <span
                    style="color: black; font-weight: bolder">&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;</span>
                            <span style="color: green">
                                <span>当前版本：</span>
                                <label v-if="this.currentPackage">
                                    <router-link
                                        :to="{name: 'packageDetail', params: {packageId: this.currentPackage.id}}">
                                        {{this.currentPackage.versionMd5}}
                                    </router-link>
                                </label>
                                <label v-else>nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn</label>
                            </span>
                            <span style="float: right;">
                                <a @click="hideVersionDiffPanel();">关闭</a>
                            </span>
            </div>
            <pre id="versionDiffContent"></pre>
        </div>
    </div>
</template>
<script type="text/ecmascript-6">
    import TaskVersionRecordItem from './TaskVersionRecordItem.vue'
    export default {
        components: {TaskVersionRecordItem},
        data () {
            return {
                editable: false,
                currentPackage: null,
                previousPackage: null
            }
        },
        computed: {
            task: function () {
                return this.$store.state.business.task;
            },
            nodeList: function () {
                return this.$store.state.business.nodeList;
            }
        },
        created () {
            this.getTaskDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getTaskDetail(to);
            next();
        },
        methods: {
            getTaskDetail(route) {
                let taskId = parseInt(route.params.taskId);
                if (taskId) {
                    this.$store.dispatch('taskOperation', {action: "get", task: {id: taskId}});
                } else {
                    this.$store.commit('UPDATE_BUSINESS_BY_NAME', {
                        name: "task",
                        value: {
                            id: 0,
                            name: null,
                            job: null,
                            node: {
                                id: null
                            }
                        }
                    });
                    this.$store.dispatch('jobOperation', {
                        action: "get", job: {id: parseInt(route.params.jobId)}
                    }).then((job) => {
                        this.task.job = job;
                    }, (data) => {
                        this.$router.go(-1);
                    });

                    this.$store.dispatch('nodeOperation', {
                        action: "list"
                    });
                    this.editable = true;
                }
                $('#versionDiffPanel').hide();
            },

            saveTask() {
                this.$store.dispatch('taskOperation', {action: "update", task: this.task}).then((task) => {
                    this.$router.push({name: 'taskDetail', params: {taskId: task.id}});
                });
            },

            deleteTask() {
                if (!confirm("确认删除任务？")) {
                    return;
                }
                let jobId = this.task.job.id;
                this.$store.dispatch("taskOperation", {action: "delete", task: this.task}).then((data) => {
                    this.$router.push({name: 'jobDetail', params: {jobId: jobId}});
                });
            },
            showDiffForCurrentVersion: function () {
                let previous = null;
                if (this.task && this.task.versionList && this.task.versionList.length > 0) {
                    previous = this.task.versionList[0].pkg;
                }
                this.showPackageDiff(previous, this.task && this.task.pkg);
            },
            showTaskVersionRecordDiff: function (current) {
                let versionList = this.task ? this.task.versionList : null;
                let previous = null;
                if (current && versionList) {
                    for (let index = 0; index < versionList.length; ++index) {
                        if ((index + 1 < versionList.length) && (versionList[index].id == current.id)) {
                            previous = versionList[index + 1];
                        }
                    }
                }
                this.showPackageDiff(previous && previous.pkg, current && current.pkg);
            },
            showPackageDiff: function (previousPackage, currentPackage) {
                this.currentPackage = currentPackage;
                this.previousPackage = previousPackage;
                this.renderVersionDiff(
                    this.previousPackage && this.previousPackage.versionContent,
                    this.currentPackage && this.currentPackage.versionContent
                );
            },
            renderVersionDiff(previous, current) {
                previous = previous || "";
                current = current || "";

                var diff = JsDiff["diffLines"](previous, current);
                var fragment = document.createDocumentFragment();
                for (var i = 0; i < diff.length; i++) {
                    if (diff[i].added && diff[i + 1] && diff[i + 1].removed) {
                        var swap = diff[i];
                        diff[i] = diff[i + 1];
                        diff[i + 1] = swap;
                    }

                    var node;
                    if (diff[i].removed) {
                        node = document.createElement('del');
                        node.appendChild(document.createTextNode(diff[i].value));
                    } else if (diff[i].added) {
                        node = document.createElement('ins');
                        node.appendChild(document.createTextNode(diff[i].value));
                    } else {
                        node = document.createTextNode(diff[i].value);
                    }
                    fragment.appendChild(node);
                }

                $('#versionDiffContent').empty().append(fragment);
                $('#versionDiffPanel').show();
            },
            hideVersionDiffPanel() {
                $('#versionDiffPanel').hide();
            }
        }
    }

</script>
<style>
    #versionDiffPanel {
        display: none;
    }

    #versionDiffContent {
        background-color: #EEE;
    }

    del {
        text-decoration: none;
        color: #b30000;
        background: #fadad7;
    }

    ins {
        background: #eaf2c2;
        color: #406619;
        text-decoration: none;
    }
</style>
