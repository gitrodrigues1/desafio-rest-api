<script setup>
import { ref, onMounted } from 'vue';
import http from './http-common';
import { useObjectsStore } from '@/stores/ObjectsStore';

const newCity = ref({
    name: '',
    stateId: '',
});

const cities = useObjectsStore();

const states = ref(["AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" ]);

function createCity() {
    console.log(newCity.value);
    http.post("/cities", newCity.value)
    .then(response =>  {
        if(response.status === 201) {
            console.log(`City created: ${response.data}`);
            cities.$state.cities.push(response.data);
            console.log(`Store: ${cities}`);
            newCity.value = { name: '', stateId: '' };
        } 
            
    })
    .catch(error => console.error(error));
}

</script>

<template>
    <div class="city-class">
        <h2>Create City</h2>

        <form class="form" @submit.prevent="createCity">
            
            <!-- name -->
            <div class="form-group col-6">
                <label for="name">Name:</label>
                <input class="form-control" type="text" id="name" v-model="newCity.name" required>
            </div>

            <!-- state -->
            <div class="form-group col-4">
                <label for="state">State</label>
                <select class="form-select" id="state" @change="event => newCity.stateId = event.target.value">
                    <option selected>Select a state</option>
                    <option v-for="s in states" :value="s">{{ s }}</option>
                </select>
            </div>

            <button class="btn btn-primary" type="submit">Save</button>
            <button class="btn btn-primary">Cancel</button>

        </form>
    </div>
</template>

<style scoped>
.city-class {
    padding-top: 20px;
    padding-left: 10px;
}

button {
    margin-top: 10px;
    margin-right: 10px;
}
</style>