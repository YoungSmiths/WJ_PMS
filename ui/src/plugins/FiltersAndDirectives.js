/**
 * Created by chris on 16/7/21.
 */

export default {
    install(Vue, options) {
        Vue.directive('number', {
            twoWay: true,
            bind: function (value2) {
                this.handler = (event, value)=> {
                    value = value || this.updateValue
                    const type = this.arg || 'int'
                    var elValue = this.value || this.el.value;
                    var originValue = elValue
                    if (!this.modifiers.required && elValue === '') {
                        this.el.value = ''
                        return
                    }
                    var isDecimal = type == 'decimal' || type == 'float' || type == 'double';
                    if (type == 'int') {
                        elValue = parseInt(elValue) || 0
                    } else if (isDecimal) {
                        elValue = Number(elValue) || 0
                    }
                    if (value) {
                        if (typeof value.min === 'number') {
                            elValue = Math.max(value.min, elValue)
                        }
                        if (typeof value.max === 'number') {
                            elValue = Math.min(value.max, elValue)
                        }
                    }
                    if (isDecimal) {
                        if (Number(originValue) !== elValue) {
                            if (originValue.match(/\.$/)) {
                                elValue = elValue + '.'
                            }
                            this.el.value = elValue
                        }
                    } else {
                        this.el.value = elValue
                    }

                }
                this.el.addEventListener('input', this.handler)
            },
            update: function (newValue, oldValue) {
                this.updateValue = newValue;
                this.handler(null, newValue)
            },
            unbind: function () {
                this.el.removeEventListener('input', this.handler)
            }
        });

        Vue.filter('date', function (value, format = 'YYYY-MM-DD HH:mm') {
            if (!value) return '-'
            return window.moment(value).format(format)
        });

        Vue.filter('datetime', function (value, format = 'YYYY-MM-DD HH:mm:ss') {
            if (!value) return '-';
            return window.moment(value).format(format)
        });

        Vue.filter("levelToDescription", function (level) {
            if (level != null) {
                return {0: '提示', 1: '一般', 2: '重大', 3: '紧急'}[level];
            }
            return 'N/A';
        });
        Vue.filter('truncate', function (text, stop, clamp) {
            stop = stop || 30;
            return text.slice(0, stop) + (stop < text.length ? clamp || '...' : '')
        })
    }
}

