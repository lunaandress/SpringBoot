import PropTypes from "prop-types";
import { useEffect, useState } from "react";
import { listProdcut } from "../services/ProductService";
import { ProductForm } from "./ProductForm";
import { ProductGrid } from "./ProductGrid";




export const ProductApp = ({title}) =>{

    const[products , setProduct]=useState([])
    useEffect(()=>{
        const result = listProdcut()
        setProduct(result)
    },[])
    return (
        <div>
            <div>
            <h1>{title.text}</h1>
            <ProductForm/>
            </div>
            <div>
            <ProductGrid products={products}/>
            </div>
    

        </div>
    )
}
ProductApp.propTypes={
        title:PropTypes.string.isRequired
    }