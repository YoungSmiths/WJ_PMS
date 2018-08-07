<template>
    <div>
        <router-view></router-view>
        <hr style="margin-top: 30px; width: 100%; color: #01A2F5" />
        <span style="float: right; font-size: small">
            <router-link :to="{name: 'systemList'}">
                业务列表
            </router-link>
            |
            <router-link :to="{name: 'jobList'}">
                作业列表
            </router-link>
            |
            <router-link :to="{name: 'taskList'}">
                任务列表
            </router-link>
        </span>
    </div>

</template>
