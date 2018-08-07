<template>
    <div>
        <table class="mainDetailTable" cellspacing="0" v-if="module != null">
            <thead>
            <tr>
                <th style="width: 30%;">属性</th>
                <th style="width: 70%">值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>所属系统</td>
                <td>
                    <router-link :to="{name: 'systemDetail', params: { systemId: this.module.system.id}}">
                        {{this.module.system.name}}
                    </router-link>
                </td>
            </tr>
            <tr v-if="module.id">
                <td>ID</td>
                <td>{{module.id}}</td>
            </tr>
            <tr>
                <td>名称</td>
                <td>
                    <input type="text" name="name" v-model="module.name" :disabled="!editable"/>
                </td>
            </tr>
            <tr v-if="module.id">
                <td>创建时间</td>
                <td>{{this.module.createTime | datetime}}</td>
            </tr>
            <tr v-if="module.id">
                <td>最近一次校验</td>
                <td v-if="module.alertCount === 0">
                    URL数：{{this.module.checkCount}}；未校验通过数：<span class="normal">{{this.module.alertCount}}</span>
                </td>
                <td v-else="module.alertCount === 0">
                    URL数：{{this.module.checkCount}}；未校验通过数：<span class="mAlert">{{this.module.alertCount}}</span>
                </td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!editable" @click="editable = !editable;">修改</button>
                    <button v-if="editable" @click="updateModule();">保存</button>
                    <button v-if="!editable && this.module.id" @click="deleteModule();">删除</button>
                    <!--<button v-if="!editable && this.module.id" @click="checkModule();">校验</button>-->
                </td>
            </tr>
            <tr v-if="module.id">
                <td>
                    URL列表
                </td>
                <td>
                    <button class="btn btn-pri import-btn fr" @click="jumpToCreateAppModuleCheck();">添加URL</button>
                    <table class="itemListTable" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>URL</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <ModuleCheckItem v-for="moduleCheck in module.appModuleCheckList"
                                         :moduleCheck="moduleCheck" :key="moduleCheck.id"></ModuleCheckItem>
                        </tbody>
                    </table>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import ModuleCheckItem from './AppModuleCheckItem.vue'
    export default {
        components: {ModuleCheckItem},
        data () {
            return {
                editable: false
            }
        },
        computed: {
            module: function () {
                console.log(JSON.stringify(this.$store.state.business))
                return this.$store.state.business.appModule;
            },
            systemId: function () {
                return this.$route.params.systemId
            }
        },
        created() {
            this.getModuleDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getModuleDetail(to);
            next();
        },
        methods: {
            getModuleDetail(route) {
                window.vm = this;
                let moduleId = parseInt(route.params.moduleId);
                if (moduleId) {
                    this.$store.dispatch('moduleOperation', {
                        action: 'GET',
                        module: {id: moduleId}
                    }).then((data) => {
                        this.editable = false;
                    }, (data) => {
                        alert("module of id " + id + " not exist.");
                        this.$router.push({name: 'moduleList'});
                    });
                } else {
                    this.$store.commit('UPDATE_BUSINESS_BY_NAME', {
                        name: 'appModule', value: {
                            id: 0,
                            name: null,
                            system: this.$store.state.business.system
                        }
                    });
                    this.editable = true;
                }
            },
            checkModule () {
                this.$store.dispatch("moduleOperation", {action: 'put', module: this.module}).then((data) => {
//                    this.$router.push({name: 'moduleDetail', params: {'moduleId':parseInt(route.params.moduleId)}});
                }, (data) => {
                    this.appConfig.showErrorAlert(data);
                });
            },
            deleteModule () {
                if (confirm("确认删除？")) {
                    let systemId = this.module.system.id;
                    this.$store.dispatch("moduleOperation", {action: 'delete', module: this.module}).then((data) => {
                        this.$router.push({name: 'systemDetail',params:{systemId:systemId}})
                    }, (data) => {
                        this.appConfig.showErrorAlert(data);
                    });
                }
            },
            updateModule () {
                this.$store.dispatch('moduleOperation', {action: 'update', module: this.module}).then((data) => {
                    this.$router.push({name: 'moduleDetail', params: {'moduleId': data.id}});
                    this.editable = false;
                });
            },
            jumpToCreateAppModuleCheck () {
                this.$router.push({name: 'moduleCheckDetail', params: {moduleCheckId: 0}});
            }
        }
    }
</script>
<style>
    .mAlert {
        background-color: yellow;
        color: red;
    }
</style>
