import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
    state: () => ({
        name: 'Joon',
        age: 25,
        email: 'joon@gmail.com',
        password: 'password',
        isLogin: false
    }),
    getters: {
        getName(state) {
            return state.name
        },
        getAge(state) {
            return state.age
        },
        getEmail(state) {
            return state.email
        },
        getPassword(state) {
            return state.password
        }
    },
    actions: {
        setName(name: string) {
            this.name = name
        },
        setAge(age: number) {
            this.age = age
        },
        setEmail(email: string) {
            this.email = email
        },
        setPassword(password: string) {
            this.password = password
        }
    }
})