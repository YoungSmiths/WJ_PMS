export default {
    template: '' +
    '<nav class="breadcrumb" v-if="$breadcrumbs.length">' +
    '    <router-link class="breadcrumb-item" v-for="(crumb, key) in $breadcrumbs" :to="linkProp(crumb)" :key="key">' +
    '        {{ crumb | crumbText }}' +
    '    </router-link>' +
    '</nav>'
}

