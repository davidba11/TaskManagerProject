const vm = new Vue({
    el: '#app',
    data: {
        status:"new",
        n:1
    },

    created() {
//        this.getUsersList();
    },

    computed: {
        isProfile(){
            return this.status === "profile";
        }
    },

    methods: {
        singIn: function () {
            window.location = window.location.origin + "/login";
            setTimeot("redirect()", 1000);
        },
        goToProfile: function (){
           this.status = "profile";
        },
        goToProjects: function (){
           this.status = "project";
        },
        goToAdmin: function (){
           this.status = "admin";
        },
        goToTasks: function (){
           this.status = "task";
        }
        
    }
    
    
});


