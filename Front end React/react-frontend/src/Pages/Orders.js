import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function Orders() {

 let navigate = useNavigate();

  const [products, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8001/api/ekart/order/user/1");
    setUsers(result.data);
  };

  const deleteFromOrders = async (id) => { 
    await axios.delete(`http://localhost:8001/api/ekart/order/user/1/${id}`);
    alert("Order cancelled!!!");
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
      <h3>Orders</h3>
    </header>
        <div>
          {products.map((product) => (
         <div className="card shadow-0 border rounded-3">
          <div className="card-body">
            <div className="row">
              <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                <div class="bg-image hover-zoom ripple rounded ripple-surface">
                      <img src={ product.link}
                    class="w-100" />
                  
                </div>
              </div>
              <div class="col-md-6 col-lg-6 col-xl-6">
                    <h5>{product.name}</h5>
                <div class="mt-1 mb-0 text-muted small">
                      <span>{product.description}</span>
                </div>
                <div class="mb-2 text-muted small">
                  <span>Unique design</span>
                  <span class="text-primary"> • </span>
                  <span>Good Quality</span>
                  <span class="text-primary"> • </span>
                  <span>Reliable<br /></span>
                      <p className="fw-bold">Quantity: {product.quantity}</p>
                      <p></p>
                      <p></p>
                      <span>Order will be delivered soon.</span>
                </div>
              </div>
              <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                <div class="d-flex flex-row align-items-center mb-1">
                      <h4 class="mb-1 me-1">{ product.price} Rs.</h4>
                </div>
                <h6 class="text-success">Free shipping</h6>
                <div class="d-flex flex-column mt-4">
                      <button onClick={ () => deleteFromOrders(product.id)} class="btn btn-primary mt-2 btn-danger" type="button">
                    Cancel Order
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
       ))}
    </div>
        
  </div>
  </>
  );
}