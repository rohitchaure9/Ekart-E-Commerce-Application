import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddProduct() {
  let navigate = useNavigate();

  const [product, setUser] = useState({
    name: "",
    link: "",
    description: "",
    rating:"",
    category: "",
    price:""
  });

  const { name, link, description, rating, category, price } = product;

  const onInputChange = (e) => {
    const value=e.target.value
    setUser({ ...product, [e.target.name]: value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8005/api/ekart/product/add", product)
      .then((response) => { 
        console.log(response)
        alert("Product Added Successfully!")
      }).catch((err) => { 
        console.log(err)
        alert(err)
      })
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Add Product</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter product name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Link" className="form-label">
                Image Link
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your image-link"
                name="link"
                value={link}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Description" className="form-label">
                Description
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your product description"
                name="description"
                value={description}
                onChange={(e) => onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Rating" className="form-label">
                Rating
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter your product ratings"
                name="rating"
                value={rating}
                onChange={(e) => onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Category" className="form-label">
                Category
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your category"
                name="category"
                value={category}
                onChange={(e) => onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Price" className="form-label">
                Price
              </label>
              <input
                type={"price"}
                className="form-control"
                placeholder="Enter your price"
                name="price"
                value={price}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button onClick={ onSubmit} type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}