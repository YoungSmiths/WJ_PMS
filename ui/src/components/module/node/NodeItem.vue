<template>
    <tr>
        <td>
            {{node.id}}
        </td>
        <td>
            <router-link :to="{name: 'nodeDetail', params: { nodeId: node.id}}">
                {{node.address}}
            </router-link>
        </td>
        <td>{{ node.lastConnectionTime | datetime}}</td>
        <td class='icon'>
            <div class="btn build">
                <router-link :to="{name: 'nodeDetail', params: {nodeId: node.id}}">
                    <span title='节点详情'></span>
                </router-link>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['node'],

        computed: {},
        methods: {},
        mounted () {
        }
    }

</script>
<style>
</style>
