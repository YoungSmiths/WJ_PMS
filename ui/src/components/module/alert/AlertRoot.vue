<template>
    <div>
        <router-view></router-view>
        <hr style="margin-top: 50px; width: 100%; color: #01A2F5"/>
        <span style="float: right; font-size: small">
            <router-link :to="{name: 'alertEventList'}">
                告警列表
            </router-link>
            |
            <router-link :to="{name: 'alertRuleList'}">
                报警规则列表
            </router-link>
        </span>
    </div>
</template>

