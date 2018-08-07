<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th>ID</th>
                <th>所属系统ID</th>
                <th>模块名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <ModuleItem v-for="module in moduleList" :module="module" :key="module.id"></ModuleItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import ModuleItem from './AppModuleItem.vue'
    import $ from 'jquery'
    export default {
        components: {ModuleItem},
        data () {
            return {}
        },
        computed: {
            moduleList () {
                return this.$store.state.business.appModuleList;
            }
        },
        methods: {
            getModuleList () {
                this.$store.dispatch('moduleOperation', {action: 'list'});
            }
        },
        created () {
            this.getModuleList();
        }
    }
</script>
<style>
</style>
