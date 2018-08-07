<template>
    <div id="contentPanel" class="container">
        <breadcrumbs id="breadcrumbs"></breadcrumbs>
        <router-view></router-view>
    </div>
</template>
<script type="text/ecmascript-6">
    export default {}
</script>
<style>
    #breadcrumbs {
        margin-top: 8px;
    }
    a {
        color: #01A2F5;
    }
    td {
        font-size: 12px;
    }

    #contentPanel {
        margin-bottom: 100px;
    }
</style>

