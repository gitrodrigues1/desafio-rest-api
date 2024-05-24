<script setup>
import { ref, reactive } from 'vue'
import axios from 'axios';
import { useObjectsStore } from '@/stores/ObjectsStore';

const newCustomer = reactive({data: {
    name: '',
    gender: '',
    birthDate: '',
    age: '',
    state: '',
    city: ''
}});

const cities = useObjectsStore().cities;

const states = ref(["AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" ]);

function createCustomer() {
    axios.post("/customers", newCustomer)
    .then(response => console.log(`Customer created: ${response.data}`))
    .catch(error => console.error(error));
}

</script>

<template>
    <div class="customer-form">
        <h2>Create Customer</h2>
        
        <form @submit.prevent="createCustomer">

            <div class="form-group col-6">
                <label for="name">Name:</label>
                <input class="form-control" type="text" id="name" v-model="newCustomer.data.name" required>
            </div>

            <div class="form-group col-2">
                <label for="genre">Genre:</label>
                <select class="form-select" id="genre" v-model="newCustomer.data.gender" required>
                    <option value="">Select your gender</option>
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                    <option value="OTHER">Other</option>
                </select>
            </div>

            <div class="form-group col-2">
                <label for="birthDate">Birth Date:</label>
                <input class="form-control" type="date" id="birthDate" v-model="newCustomer.data.birthDate" required>
            </div>

            <div class="form-group col-2">
                <label for="age">Age:</label>
                <input class="form-control" type="number" id="age" v-model="newCustomer.data.age" required>
            </div>

            <div class="form-group col-2">
                <label for="state">State:</label>
                <select class="form-select" id="state" v-model="newCustomer.data.state">
                    <option selected>Select a state</option>
                    <option v-for="s in states" :value="s">{{ s }}</option>
                </select>
            </div>

            <div class="form-group col-6">
                <label for="city">City:</label>
                <select  class="form-select" id="city" v-model="newCustomer.data.state">
                    <option value="">Select a city</option>
                    <option v-for="c in cities" :value="c.name">{{ c.name }}</option>
                </select>
            </div>

            <button class="btn btn-primary" type="submit">Save</button>
            <button class="btn btn-primary">Cancel</button>
        </form>
    </div>
</template>

<style scoped>
.customer-form {
    padding-top: 20px;
    padding-left: 10px;
}

button {
    margin-top: 10px;
    margin-right: 10px;
}

</style>
