const vm = new Vue({
    el: '#application',
    data: {
        user: "",
        pass: "",
        users: []
    },

    created() {
        this.getUsersList();
    },

    computed: {
    },

    methods: {
        getUsersList: function () {
            let service_path = window.location.href + "users";
            console.log(window.location.href);
            axios.get(service_path).then(rs => {
                let {data} = rs;
                this.users = data;
                console.log(this.users);
            }).catch(error => {
//                this.getNotify("Usuario y/o contraseña incorrecta.", "danger", "top", 50, "right", 500, 3000, true, 10);
                console.log(error);
            });
        },

        register: function () {
            window.location = window.location.origin + "/register";
            setTimeot("redirect()", 1000);
        },
        
        singIn: function () {
            window.location = window.location.origin + "/menu";
            setTimeot("redirect()", 1000);
        }
    }
});