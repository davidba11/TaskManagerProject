const vm = new Vue({
    el: '#menu',
    data: {
    },

    created() {
//        this.getUsersList();
    },

    computed: {
    },

    methods: {
        singIn: function () {
            window.location = window.location.origin + "/login";
            setTimeot("redirect()", 1000);
        }
    }
});


