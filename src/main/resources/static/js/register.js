const vm = new Vue({
    el: '#register',
    data: {
        user: {
            username: "",
            password: "",
            identification_number: 0,
            first_name: "",
            last_name: "",
            phone_number: "",
            email: "",
            date_of_birth: undefined,
            status: "Inactive"
        },
        password2: ""
    },
    created() {
    },
    computed: {
    },
    methods: {
        singIn: function () {
            window.location = window.location.origin+"/login";
            setTimeot("redirect()", 1000);
        },
        isNull: function (param) {
            return param === "" || param === undefined || param === null;
        },
        isValidatePass1: function () {
            let isMayus = false;
            let isNumber = false;
            let numeros = "0123456789";
            for (var index = 0; index < this.user.password.length; index++) {
                if (this.user.password.charAt(index) === this.user.password.charAt(index).toUpperCase()) {
                    isMayus = true;
                }
                if (numeros.indexOf(this.user.password.charAt(index), 0) !== -1) {
                    isNumber = true;
                }
            }
            return this.user.password.length >= 8 && isMayus && isNumber;
        },
        isValidatePass2: function () {
            let isMayus = false;
            let isNumber = false;
            let numeros = "0123456789";
            for (var index = 0; index < this.password2.length; index++) {
                if (this.password2.charAt(index) === this.password2.charAt(index).toUpperCase()) {
                    isMayus = true;
                }
                if (numeros.indexOf(this.password2.charAt(index), 0) !== -1) {
                    isNumber = true;
                }
            }
            return this.password2.length >= 8 && isMayus && isNumber;
        },
        reconfirmPass: function () {
            return this.password2 === this.user.password;
        },
        confirmEmail: function () {
            return this.user.email.match(/^(([^<>()\[\]\.,;:\s@\”]+(\.[^<>()\[\]\.,;:\s@\”]+)*)|(\”.+\”))@(([^<>()[\]\.,;:\s@\”]+\.)+[^<>()[\]\.,;:\s@\”]{2,})$/);
        },
        EncrypterPass: function () {
            let service_path = window.location.origin + "/users";
            axios.post(service_path, {
                username: this.user.username,
                password: this.user.password,
                identification_number: this.user.identification_number,
                first_name: this.user.first_name,
                last_name: this.user.last_name,
                phone_number: this.user.phone_number,
                email: this.user.email,
                date_of_birth: this.formatDate(),
                status: this.user.status
            }).then(rs => {
                console.log(rs);
            }).catch(error => {
//                this.getNotify("Usuario y/o contraseña incorrecta.", "danger", "top", 50, "right", 500, 3000, true, 10);
                console.log(error);
            });
        },

        formatDate: function () {
            return this.user.date_of_birth.replace(/^(\d{4})-(\d{2})-(\d{2})$/g, '$3/$2/$1');
        },
        singUp: function () {
            let service_path = window.location.origin + "users";
            axios.post(service_path).then(rs => {
                let {data} = rs;
                this.users = data;
                console.log(this.users);
            }).catch(error => {
//                this.getNotify("Usuario y/o contraseña incorrecta.", "danger", "top", 50, "right", 500, 3000, true, 10);
                console.log(error);
            });
            window.location = window.location.origin;
            setTimeot("redirect()", 1000);
        }
    }
});