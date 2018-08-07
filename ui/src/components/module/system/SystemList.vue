<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th>业务系统ID</th>
                <th>业务系统名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <SystemItem v-for="system in systemList" :system="system" :key="system.id"></SystemItem>
            </tbody>
        </table>
        <button class="btn btn-pri import-btn fr" @click="jumpToCreateSystem">添加系统</button>
    </div>
</template>
<script type="text/ecmascript-6">
    import SystemItem from './SystemItem.vue'
    export default {
        components: {SystemItem},
        data () {
            return {}
        },
        computed: {
            systemList() {
                return this.$store.state.business.systemList;
            }
        },
        methods: {
            getSystemList () {
                this.$store.dispatch('systemOperation', {action: 'list'});
            },
            jumpToCreateSystem() {
                this.$router.push({name: 'systemDetail', params: {systemId: 0}});
            }
        },
        created () {
            this.getSystemList();
        }
    }
</script>
<style>

</style>

