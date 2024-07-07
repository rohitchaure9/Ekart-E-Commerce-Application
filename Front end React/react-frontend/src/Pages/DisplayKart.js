import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function DisplayKart() {

  const [products, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8007/api/ekart/working/kart/user/1");
    setUsers(result.data);
  };

  const placeOrder = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8001/api/ekart/order/user/1");
    await axios.delete("http://localhost:8007/api/ekart/working/kart/user/1");
    alert("Congatulations. Your Order Successfully Placed!");
    loadUsers();
  }

  const deleteFromKart = async (id) => { 
    await axios.delete(`http://localhost:8007/api/ekart/working/kart/user/1/${id}`);
    alert("Product removed from Kart successfully!!!");
    loadUsers();
  }

  const incrementKartQuantity = async (id) => {
    await axios.post(`http://localhost:8007/api/ekart/working/kart/increment/1/${id}`);
    loadUsers();
  }
  
  const decrementKartQuantity = async (id) => {
    await axios.post(`http://localhost:8007/api/ekart/working/kart/decrement/1/${id}`);
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
      <h3>Kart Products</h3>
    </header>
    <div>
       {products.map((product) => (
         <div class="card rounded-3 mb-4">
          <div class="card-body p-4">
            <div class="row d-flex justify-content-between align-items-center">
              <div class="col-md-2 col-lg-2 col-xl-2">
                <img src={product.link}
                  class="img-fluid rounded-3" alt="Cotton T-shirt"/>
              </div>
              <div class="col-md-3 col-lg-3 col-xl-3">
                <p class="lead fw-normal mb-2">{product.name}</p>
                <p><span className="text-muted">Description: </span>{product.description}</p>
                
                 <p><span className="text-muted">Rating: </span>{product.rating}</p>
                 <p class="mb-0"><span className="text-muted">Price: </span>{product.price} Rs.</p>
              </div>
              <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                <button class="btn btn-light btn-sm" type="button"
                   onClick={() => incrementKartQuantity(product.id)}>
                   +
                </button>
                 <p class="h4 mx-1"><span className="text-muted">{product.quantity} </span> </p>

                <button class="btn btn-light btn-sm" type="button"
                   onClick={() => decrementKartQuantity(product.id)}>
                   -
                </button>
              </div>
              <div class="col-md-3 col-lg-2 col-xl-2">
                 <h5 class="mb-0"><span className="text-muted">Total: </span>{product.totalPrice} Rs.</h5>
               </div>
              <div class="col-md-1">
                <button onClick={() => deleteFromKart(product.id)} type="button" className="btn btn-primary btn-lg btn-danger">Remove</button>
              </div>
            </div>
          </div>
        </div>
       ))}
          <div className="text-center">
            <button type="button" className="btn btn-primary btn-lg btn-block" onClick={placeOrder}>Place Order</button>
          </div>
    </div>
        
  </div>
  </>
  );
}