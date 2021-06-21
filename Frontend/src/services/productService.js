import axios from "axios"

export default class ProductService {
    getProducts(){
        return axios.get("http://localhost:8080/api/products/getall") //apini adresini yazıyoruz
    }
     getByProductName(productName){
        return axios.get("http://localhost:8080/api/products/getByProductName?productName="+ productName)
    }//prudctname i objeye çağırıyoruz.

}