import { useEffect, useState } from "react";
import { listProdcut } from "../services/ProductService";


export const ProductApp = () =>{

    const[products , setProduct]=useState([])
    useEffect(()=>{
        const result = listProdcut()
        setProduct(result)
    },[])
    return (
        <>
        <h1> Lista de Productos</h1>
        <table>
            <thead>
                <tr>
                    <th>name</th>
                    <th>description</th>
                    <th>price</th>
                </tr>
            </thead>
            <tbody>
                {products.map(product =>{
                return (<tr key={product.name}>
                    <td>{product.name}</td>
                    <td>{product.description}</td>
                    <td>{product.price}</td>
                </tr>)
                })}
            </tbody>
        </table>
        </>
    )
}