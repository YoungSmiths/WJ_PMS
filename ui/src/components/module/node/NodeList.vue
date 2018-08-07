<template>
    <div>
        <table class="itemListTable" cellspacing="0">
            <thead>
            <tr>
                <th>节点ID</th>
                <th>节点地址</th>
                <th>最后连接时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <NodeItem v-for="node in nodeList" :node="node" :key="node.id"></NodeItem>
            </tbody>
        </table>
        <button class="btn btn-pri import-btn fr" @click="jumpToAddNode();">添加节点</button>
    </div>
</template>
<script type="text/ecmascript-6">
    import NodeItem from './NodeItem.vue'
    export default {
        components: {NodeItem},
        data () {
            return {}
        },
        computed: {
            nodeList () {
                return this.$store.state.business.nodeList;
            }
        },
        created () {
            this.getNodeList();
        },

        methods: {
            jumpToAddNode() {
                this.$router.push({name: 'nodeDetail', params: {nodeId: 0}});
            },
            getNodeList () {
                this.$store.dispatch('nodeOperation', {action: 'list'});
            }
        }
    }

</script>
<style>
</style>

