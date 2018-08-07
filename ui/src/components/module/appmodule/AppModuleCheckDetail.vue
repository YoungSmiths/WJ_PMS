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
            <tr v-if="moduleCheck.id">
                <td>ID</td>
                <td>
                    {{moduleCheck.id}}
                </td>
            </tr>
            <tr>
                <td>所属业务模块</td>
                <td>
                    <router-link :to="{name: 'moduleDetail', params: {moduleId:moduleCheck.appModule.id}}">
                        {{moduleCheck.appModule.name}}
                    </router-link>
                </td>
            </tr>
            <tr v-if="moduleCheck.id">
                <td>创建时间</td>
                <td>{{moduleCheck.createTime | datetime}}</td>
            </tr>
            <tr>
                <td>URL</td>
                <td><input type="text" name="name" v-model="moduleCheck.url"
                           :disabled="!editable"></td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!editable" @click="editable = true;">修改</button>
                    <button v-if="editable" @click="updateUrl(); editable = false;">保存</button>
                    <button v-if="this.moduleCheck.id" @click="deleteModuleCheck();">删除</button>
                    <!--<button v-if="this.moduleCheck.id" @click="moduleCheckAction();">校验</button>-->
                </td>
            </tr>
            <tr v-if="moduleCheck.id">
                <td>
                    日志列表
                </td>
                <td>
                    <table class="itemListTable" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>URL</th>
                            <th>状态</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <ModuleCheckLogItem
                            v-for="moduleCheckLog in moduleCheck.appModuleCheckLogList"
                            :moduleCheckLog="moduleCheckLog"
                            :key="moduleCheckLog.id"></ModuleCheckLogItem>
                        </tbody>
                    </table>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import ModuleCheckLogItem from './AppModuleCheckLogItem.vue'
    export default {
        components: {ModuleCheckLogItem},
        data(){
            return {
                editable: false
            }
        },
        computed: {
            moduleCheck: function () {
                return this.$store.state.business.moduleCheck
            }
        },
        created(){
            this.getModuleCheckDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next){
            this.getModuleCheckDetail(to);
            next();
        },
        methods: {
            getModuleCheckDetail(route){
                let moduleCheckId = parseInt(route.params.moduleCheckId);
                if (moduleCheckId) {
                    this.$store.dispatch('moduleCheckOperation', {
                        action: "get",
                        moduleCheck: {id: moduleCheckId}
                    }).then((data) => {
                        this.editable = false;
                    }, (data) => {
                        alert("system of moduleCheck " + moduleCheckId + " not exist.");
                        let moduleId = parseInt(route.params.moduleId);
                        this.$router.push({name: 'moduleCheckDetail',params:{moduleId:moduleId,moduleCheckId:moduleCheckId}});
                    });
                } else {
                    this.$store.commit('UPDATE_BUSINESS_BY_NAME', {
                        name: 'moduleCheck',
                        value: {
                            id: 0,
                            name: null,
                            url: null,
                            appModule:this.$store.state.business.appModule
                        }
                    });
                    this.editable = true;
                }
            },
            updateUrl(){
                let id = this.moduleCheck.id;
                this.$store.dispatch('moduleCheckOperation', {
                    action: "update",
                    moduleCheck: this.moduleCheck
                }).then((moduleCheck) => {
                    if (id !== 0) {
                         this.$store.dispatch('moduleCheckOperation', {
                            action: "get",
                            moduleCheck:{
                                id:id
                            }
                        });
                    } else {
                        this.$router.push({
                            name: 'moduleCheckDetail',
                            params: {
                                moduleCheck: {
                                    id: moduleCheck.id
                                }
                            }
                        });
                    }
                });
            },
            deleteModuleCheck(){
                if (!confirm("确认删除作业？")) {
                    return;
                }
                let moduleId = this.moduleCheck.appModule.id;
                this.$store.dispatch("moduleCheckOperation", {
                    action: "delete",
                    moduleCheck: this.moduleCheck
                }).then((data) => {
                    this.$router.push({name: 'moduleDetail', params: {moduleId: moduleId}});
                });
            }
        }
    }

</script>
<style>
</style>
