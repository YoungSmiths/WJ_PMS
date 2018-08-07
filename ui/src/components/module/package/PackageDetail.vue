<template>
    <div>
        <table class="mainDetailTable" cellspacing="0" v-if="pkg != null">
            <thead>
            <tr>
                <th style="width: 30%;">属性</th>
                <th style="width: 70%">值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>id</td>
                <td>{{ pkg.id }}</td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td>{{ pkg.createTime | datetime }}</td>
            </tr>
            <tr v-if="pkg.job">
                <td>所属作业</td>
                <td>
                    <router-link :to="{name: 'systemDetail', params: { systemId: pkg.job.system.id }}">{{
                        pkg.job.system.name }}
                    </router-link>
                    &nbsp;-&nbsp;
                    <router-link :to="{name: 'jobDetail', params: { jobId: pkg.job.id }}">{{ pkg.job.name
                        }}
                    </router-link>
                </td>
            </tr>
            <tr>
                <td>版本号</td>
                <td>
                    {{pkg.versionMd5}}
                </td>
            </tr>
            <tr>
                <td>是否合规</td>
                <td>
                    <label :class="pkg.confirmed ? 'confirmed' : 'unconfirmed'">
                        {{ pkg.confirmed ? '合规' : '不合规' }}
                    </label>
                </td>
            </tr>
            <tr>
                <td>操作</td>
                <td>
                    <button v-if="!pkg.confirmed" @click="confirmPackage()">
                        确认合规
                    </button>
                </td>
            </tr>
            <tr>
                <td>版本内容</td>
                <td>
                    <pre>{{ pkg.versionContent }}</pre>
                </td>
            </tr>
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
            pkg () {
                return this.$store.state.business.package;
            }
        },
        created () {
            this.getPackageDetail(this.$route);
        },
        beforeRouteUpdate(to, from, next) {
            this.getPackageDetail(to);
            next();
        },
        methods: {
            getPackageDetail (route) {
                let packageId = parseInt(route.params.packageId);
                this.$store.dispatch('packageOperation', {action: 'get', pkg: {id: packageId}});
            },
            confirmPackage () {
                if (window.confirm("确认软件包合规")) {
                    this.$store.dispatch("packageOperation", {
                        action: 'update', pkg: {
                            id: this.pkg.id,
                            confirmed: true
                        }
                    });
                }
            }
        }
    }
</script>
<style>

</style>
