import { useState } from "react"

const initialDateForm={
    name:'',
    description: ' ',
    price: 0
}
export const  ProductForm =()=>{
    const[form,setForm] = useState(initialDateForm);

   // const{name,description,price}=form
    return(
        <form action="">
            <div>
            <input placeholder="Name"
            style={{marginBottom:'2px'}}
            name="name"
            value={form.name}
            onChange={(event)=> setForm({
                ...form,name:event.target.value
            })}
            />
            </div>
        <div>

            <input placeholder="Description"
            style={{marginBottom:'2px'}}
            name="description"
            value={form.description}
            onChange={(event)=> setForm({
                ...form,description:event.target.value
            })}
            />
        </div>

            <div>
            <input placeholder="Price"
            style={{marginBottom:'2px'}}
            name="price"
            value={form.price}
            onChange={(event)=> setForm({
                ...form,price:event.target.value
            })}
            />
            </div>
            <button type="submit">
                Create
            </button>
        </form>
    )
}