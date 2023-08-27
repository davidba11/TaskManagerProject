
/* global axios */

const vm = new Vue({
    el: '#register',
    data: {
        user: {
            username: undefined,
            password: undefined,
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
        passLength(){
            return this.user.password!==undefined?this.user.password.length:undefined;
        }
    },
    methods: {
        singIn: function () {
            window.location = window.location.origin + "/login";
            setTimeot("redirect()", 1000);
        },
        isNull: function (param) {
            return param === "" || param === undefined || param === null;
        },
        isValidatePass1: function () {
            let isMayus = false;
            let isNumber = false;
            let numeros = "0123456789";
            for (var index = 0; index < this.passLength; index++) {
                if (this.user.password.charAt(index) === this.user.password.charAt(index).toUpperCase()) {
                    isMayus = true;
                }
                if (numeros.indexOf(this.user.password.charAt(index), 0) !== -1) {
                    isNumber = true;
                }
            }
            return this.passLength >= 8 && isMayus && isNumber;
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

        formatDate: function () {
            return this.user.date_of_birth !== undefined ? this.user.date_of_birth.replace(/^(\d{4})-(\d{2})-(\d{2})$/g, '$3/$2/$1') : undefined;
        },
        validateSingUp: function(){
            return 
        },
        singUp: function () {
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
                window.location = window.location.origin + "/login";
                setTimeot("redirect()", 1000);
                console.log(rs);
            }).catch(error => {
                console.log(error);
            });
        }
    }
});