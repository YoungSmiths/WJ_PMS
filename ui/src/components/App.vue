<template>
    <div id="app">
        <HeaderComponent></HeaderComponent>
        <title-component></title-component>
        <router-view></router-view>
    </div>
</template>

<script type="text/ecmascript-6">
    import HeaderComponent from './header/Header.vue'
    import TitleComponent from '../components/header/Title.vue'
    export default {
        name: 'app',
        components: {HeaderComponent,TitleComponent}
    }
</script>

<style>
</style>

