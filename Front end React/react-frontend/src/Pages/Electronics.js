import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Electronics() {
  const [products, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8005/api/ekart/product/category/Electronics");
    setUsers(result.data);
  };

  const addToKart = async (id) => { 
    await axios.post(`http://localhost:8007/api/ekart/working/kart/1/${id}`);
    alert("Product added to Kart successfully!!!");
    loadUsers();
  }

  const addToWishList = async (id) => { 
    await axios.post(`http://localhost:8007/api/ekart/working/wishList/1/${id}`);
    alert("Product added to Wish List successfully!!!");
    loadUsers();
  }

  

  return (
    <>
      <div class="p-3 text-center bg-white border-bottom">
    <div class="container">
      <div class="row gy-3">
        <div class="col-lg-2 col-sm-4 col-4">
          <img src="https://ekartlogistics.com/assets/images/ekblueLogo.png" height="35" />
        </div>
        <div class="order-lg-last col-lg-5 col-sm-8 col-8">
          <div class="d-flex float-end">
            <a href="http://localhost:3000/displaywishlist" class="me-1 border rounded py-1 px-3 nav-link d-flex align-items-center"> <i class="fas fa-heart m-1 me-md-2"></i><p class="d-none d-md-block mb-0">Wishlist</p> </a>
            <a href="http://localhost:3000/displaykart" class="border rounded py-1 px-3 nav-link d-flex align-items-center"> <i class="fas fa-shopping-cart m-1 me-md-2"></i><p class="d-none d-md-block mb-0">My cart</p> </a>
                <a href="http://localhost:3000/displayorders" class="border rounded py-1 px-3 nav-link d-flex align-items-center"> <i class="fas fa-shopping-cart m-1 me-md-2"></i><p class="d-none d-md-block mb-0">My Orders</p> </a>
                <a href="http://localhost:3000/" class="me-1 border rounded py-1 px-3 nav-link d-flex align-items-center"> <i class="fas fa-user-alt m-1 me-md-2"></i><p class="d-none d-md-block mb-0">Logout</p> </a>
          </div>
        </div>
        <div class="col-lg-5 col-md-12 col-12">
          <div class="input-group float-center">
            {/* <div class="form-outline">
              <input type="search" id="form1" placeholder="Search" class="form-control" />
            </div>
            <button type="button" class="btn btn-primary">
              <i class="fas fa-search"></i>
            </button> */}
          </div>
        </div>
      </div>
    </div>
      </div>
      <nav class="navbar navbar-expand-lg navbar-light bg-white">
    <div class="container justify-content-center justify-content-md-between">
      <button
              class="navbar-toggler border py-2 text-dark"
              type="button"
              data-mdb-toggle="collapse"
              data-mdb-target="#navbarLeftAlignExample"
              aria-controls="navbarLeftAlignExample"
              aria-expanded="false"
              aria-label="Toggle navigation"
              >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarLeftAlignExample">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link text-dark" aria-current="page" href="http://localhost:3000/Home">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark" href="#"><span className="text-muted">Categories: </span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark" href="http://localhost:3000/displayelectronics">Electronics</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark" href="http://localhost:3000/displayclothes">Clothes</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark" href="http://localhost:3000/displayfurniture">Furniture</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div className="container my-5">
    <header className="mb-4">
      <h3>Electronics Category</h3>
    </header>
    <div>
      <div className="row">
       {products.map((product) => (
         
           <div className="col-lg-5 col-md-6 col-sm-6 r-flex">
        <div className="card w-100 my-2 shadow-2-strong">
          <img src={product.link} class="card-img-top" width={524} height={550}/>
          <div className="card-body d-flex flex-column">
                 <div className="flex-row"><h5 className="card-title">{ product.name}</h5>
                 <p className="card-text">{product.price} Rs.</p></div>
                 <p className="card-text">{product.description}</p>
                 <p className="card-text"><span class="text-muted">Rating: </span> {product.rating}</p>
            <div class="d-flex justify-content-between total font-weight-bold mt-4">
              <div class="btn-group" role="group" aria-label="Basic example">
                       <button onClick={() => addToKart(product.id)} type="button" className="btn btn-primary btn-lg btn-block">Add to kart</button>
              </div>
              <div class="btn-group" role="group" aria-label="Basic example">
                       <button onClick={ ()=> addToWishList(product.id)} type="button" className="btn btn-primary btn-lg btn-block btn-danger">Add to Wish List</button>
              </div>
           </div>
          </div>
        </div>
      </div>
       
       ))}
            </div>
    </div>
        
  </div>
  </>
  );
}