const vm = new Vue({
    el: '#app',
    data: {
        status: "new",
        user: {
            id: undefined,
            username: "",
            password: "",
            identification_number: undefined,
            first_name: "",
            last_name: "",
            phone_number: "",
            email: "",
            date_of_birth: "",
            status: ""
        }
    },

    created() {
//        this.getUsersList();
    },

    computed: {
        isProfile() {
            return this.status === "profile";
        },
        isProject() {
            return this.status === "project";
        },
        isAdmin() {
            return this.status === "admin";
        },
        isTask() {
            return this.status === "task";
        }
    },
    methods: {
        singIn: function () {
            window.location = window.location.origin + "/login";
            setTimeot("redirect()", 1000);
        },

        goToProfile: function () {
            this.status = "profile";
        },

        goToProjects: function () {
            this.status = "project";
        },

        goToAdmin: function () {
            this.status = "admin";
        },

        goToTasks: function () {
            this.status = "task";
        },

        searchUser: function () {
            let service_path = window.location.origin + "/users/" + this.user.id;
            console.log(service_path);

            axios.get(service_path).then(rs => {
                let {data} = rs;
                console.log(data);
//                const cambiada = fecha_nac.split("/").reverse().join("/");
//                console.log(cambiada)
                this.user = data;
            }).catch(error => {
                this.getNotify("Usuario y/o contraseña incorrecta.", "danger", "top", 50, "right", 500, 3000, true, 10);
                console.log(error);
            });
        }
    }

});


