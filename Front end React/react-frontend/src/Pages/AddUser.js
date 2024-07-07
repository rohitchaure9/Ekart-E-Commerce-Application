import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddUser() {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    name: "",
    age: "",
    email: "",
    address:"",
    phNo: "",
    password:""
  });

  const { name, age, email, address, phNo, password } = user;

  const onInputChange = (e) => {
    const value=e.target.value
    setUser({ ...user, [e.target.name]: value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8003/api/ekart/user/add", user)
      .then((response) => { 
        console.log(response)
        alert("Successfully Registered...!!!")
      }).catch((err) => { 
        console.log(err)
        alert(err)
      })
    navigate("/");
  };

  return (
    <><div class="p-3 text-center bg-white border-bottom">
    <div class="container">
      <div class="row gy-3">
        <div class="col-lg-2 col-sm-4 col-4">
          <img src="https://ekartlogistics.com/assets/images/ekblueLogo.png" height="35" />
        </div>
        <div class="order-lg-last col-lg-5 col-sm-8 col-8">
          <div class="d-flex float-end">
                <a href="http://localhost:3000/" class="me-1 border rounded py-1 px-3 nav-link d-flex align-items-center"> <i class="fas fa-user-alt m-1 me-md-2"></i><p class="d-none d-md-block mb-0">Sign In</p> </a>
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
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register User</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Age" className="form-label">
                Age
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter your age"
                name="age"
                value={age}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-Mail
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your e-mail address"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Address" className="form-label">
                Address
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your address"
                name="address"
                value={address}
                onChange={(e) => onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Ph No." className="form-label">
                Ph No.
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter your phone number"
                name="phNo"
                value={phNo}
                onChange={(e) => onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Password" className="form-label">
                Password
              </label>
              <input
                type={"password"}
                className="form-control"
                placeholder="Enter your password"
                name="password"
                value={password}
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
      </>
  );
}