import { defineStore } from "pinia";
import { ref, reactive, computed } from "vue";

export const useObjectsStore = defineStore('objectStore', () => {
    
    const cities = reactive([]);

    return {
        cities,
    }
})