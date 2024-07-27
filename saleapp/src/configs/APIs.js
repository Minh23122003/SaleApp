import axios from "axios"

const BASE_URL = "http://localhost:8080/SpringSaleApp/api/"

export const endpoints = {
    'categories': '/categories',
    'products': '/products'
}

export default axios.create({
    baseURL: BASE_URL
});