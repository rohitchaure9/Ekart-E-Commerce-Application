import AddUser from "./Pages/AddUser";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./Layout/Navbar";
import Home from "./Pages/HomePage";
import AddProduct from "./Pages/AddProduct";
import DisplayKart from "./Pages/DisplayKart";
import WishlistPage from "./Pages/WishListPage";
import Orders from "./Pages/Orders";
import Electronics from "./Pages/Electronics";
import Clothes from "./Pages/Clothes";
import Furniture from "./Pages/Furniture";
import SignIn from "./Pages/SignIn";


function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<SignIn />} />
          <Route exact path="/home" element={<Home />} />
          <Route exact path="/adduser" element={<AddUser />} />
          <Route exact path="/addproduct" element={<AddProduct />} />
          <Route exact path="/displaykart" element={<DisplayKart />} />
          <Route exact path="/displaywishlist" element={<WishlistPage />} />
          <Route exact path="/displayorders" element={<Orders />} />
          <Route exact path="/displayelectronics" element={<Electronics />} />
          <Route exact path="/displayclothes" element={<Clothes />} />
          <Route exact path="/displayfurniture" element={<Furniture />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
