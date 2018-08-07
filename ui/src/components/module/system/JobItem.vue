<template>
    <tr id='jobItem'>
        <td>
            {{job.id}}
        </td>
        <td class='id'>
            <router-link :to="{name: 'jobDetail', params: { jobId: job.id}}">
                {{job.name}}
            </router-link>
        </td>
        <td class='path'>{{job.path}}</td>
        <td class='icon'>
            <div class="btn build">
                <router-link :to="{name: 'jobDetail', params: { jobId: job.id}}">
                    <span title='查看作业'></span>
                </router-link>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['job'],
        computed: {},
        methods: {}
    }
</script>
<style>

</style>
