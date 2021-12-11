<template>
    <div class="information">
        <h1>
        ¡Bienvenido a Hoteles Misuite
        <span>{{ userDetailById.name }}</span
        >!
         </h1>

         <h2>
        Disfruta del lujo y la comodidad en un solo lugar.
        </h2>


    <div class="details">
        <h3>Reserva Ahora</h3>
        
        <h2>
            
            <span>{{ userDetailById.username }}</span>
        </h2>

        <h2>
            
            <span>{{ userDetailById.email }}</span>
        </h2>
    </div>
</div>

</template>


<script>
import gql from "graphql-tag";
import jwt_decode from "jwt-decode";

export default {
    name: "Home",

    data: function () {
        return {
            userId: jwt_decode(localStorage.getItem("token_refresh")).user_id,
            userDetailById: {
            username: "",
            name: "",
            email: "",
        },
    };
},

    apollo: {
        userDetailById: {
            query: gql`
                query ($userId: Int!) {
                    userDetailById(userId: $userId) {
                        username
                        name
                        email
                    }
                }
            `,
            variables() {
                return {
                userId: this.userId,
                };
            }
        },
    }
};
</script>


<style>
.information {
    margin: 0;
    padding: 0%;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.information h1 {
    font-size: 50px;
    color: #000000;
}
.information h2 {
    font-size: 40px;
    color: #000000;
    }
.information span {
    color: #000000;
    font-weight: bold;
}
.details h3 {
    font-size: 25px;
    color: #dd2270;
    text-align: center;
}
.details h2 {
    font-size: 25px;
    color: #dd2270;
}
.details {
    border: 3px solid rgb(0, 0, 0);
    color: #dd2270;
    border-radius: 20px;
    padding: 30px 80px;
    margin: 30px 0 0 0;
}
</style>