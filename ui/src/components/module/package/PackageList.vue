<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th>ID</th>
                <th>所属系统</th>
                <th>所属作业</th>
                <th>版本号</th>
                <th>创建时间</th>
                <th>是否合规</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <PackageItem v-for="package in packageList" :package="package" :key="package.id"></PackageItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import PackageItem from './PackageItem.vue'
    import $ from 'jquery'
    export default {
        components: {PackageItem},
        data () {
            return {}
        },
        computed: {
            packageList () {
                return this.$store.state.business.packageList;
            }
        },
        methods: {
            getPackageList () {
                this.$store.dispatch('packageOperation', {action: 'list'});
            }
        },
        created () {
            this.getPackageList();
        }
    }
</script>
<style>
</style>
