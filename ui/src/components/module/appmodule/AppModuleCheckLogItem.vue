<template>
    <tr id="moduleCheckLogItem">
        <td>
            {{moduleCheckLog.id}}
        </td>
        <td>
            {{moduleCheckLog.url}}
        </td>
        <td v-if="isSuccess" style="color: green;">
            正常
        </td>
        <td v-else="isSuccess" style="color: red">异常</td>
        <td>
            {{moduleCheckLog.createTime | datetime}}
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    export default {
        props: ['moduleCheckLog'],
        computed: {
            isSuccess: function () {
                if(this.moduleCheckLog.statusCode == 200)
                    return 200;
                else return false;
            }
        },
        methods: {},
        mounted () {
        },
        created () {
        }
    }
</script>
<style>
</style>
