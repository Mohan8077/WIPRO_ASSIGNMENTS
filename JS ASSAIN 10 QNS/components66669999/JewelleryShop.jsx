import React, { useState } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  useParams,
  useLocation,
  Navigate,
} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

// Fade transition component for page transitions
const FadeTransition = ({ children }) => {
  const [fade, setFade] = React.useState(false);
  const location = useLocation();

  React.useEffect(() => {
    setFade(true);
    const timer = setTimeout(() => setFade(false), 300);
    return () => clearTimeout(timer);
  }, [location]);

  return (
    <div
      style={{
        transition: "opacity 300ms ease-in-out",
        opacity: fade ? 0 : 1,
      }}
    >
      {children}
    </div>
  );
};

const Navbar = () => (
  <nav className="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div className="container">
      <Link className="navbar-brand" to="/">
        Jewellery Shop
      </Link>
      <button
        className="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav ms-auto">
          <li className="nav-item">
            <Link className="nav-link" to="/">
              Home
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/products">
              Products
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/cart">
              Cart
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/checkout">
              Checkout
            </Link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
);

const Home = () => (
  <div className="container text-center">
    <h1>Welcome to the Jewellery Shop</h1>
    <p>Your one-stop shop for beautiful jewellery pieces.</p>
    <Link to="/products" className="btn btn-primary">
      Browse Products
    </Link>
  </div>
);

const productsData = [
  {
    id: "1",
    name: "Gold Necklace",
    price: 199.99,
    description: "Elegant 24k gold necklace perfect for any occasion.",
    image:
      "https://images.unsplash.com/photo-1549924231-f129b911e442?auto=format&fit=crop&w=600&q=80",
  },
  {
    id: "2",
    name: "Diamond Ring",
    price: 299.99,
    description: "Sparkling diamond ring with a platinum band.",
    image:
      "https://images.unsplash.com/photo-1503602642458-232111445657?auto=format&fit=crop&w=600&q=80",
  },
  {
    id: "3",
    name: "Silver Bracelet",
    price: 99.99,
    description: "Stylish silver bracelet with intricate designs.",
    image:
      "https://images.unsplash.com/photo-1546484959-f3a1dba85a14?auto=format&fit=crop&w=600&q=80",
  },
];

const Products = () => {
  return (
    <div className="container">
      <h2>Our Products</h2>
      <div className="row">
        {productsData.map((product) => (
          <div key={product.id} className="col-md-4 mb-4">
            <div className="card h-100">
              <img
                src={product.image}
                className="card-img-top"
                alt={product.name}
                style={{ height: "200px", objectFit: "cover" }}
              />
              <div className="card-body d-flex flex-column">
                <h5 className="card-title">{product.name}</h5>
                <p className="card-text">${product.price.toFixed(2)}</p>
                <Link
                  to={`/products/${product.id}`}
                  className="btn btn-outline-primary mt-auto"
                >
                  View Details
                </Link>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

const ProductDetails = ({ addToCart }) => {
  const { productId } = useParams();
  const product = productsData.find((p) => p.id === productId);

  if (!product) return <Navigate to="/404" />;

  return (
    <div className="container">
      <h2>{product.name}</h2>
      <div className="row">
        <div className="col-md-6">
          <img
            src={product.image}
            alt={product.name}
            className="img-fluid rounded"
          />
        </div>
        <div className="col-md-6">
          <h3>${product.price.toFixed(2)}</h3>
          <p>{product.description}</p>
          <button
            className="btn btn-success"
            onClick={() => addToCart(product)}
          >
            Add to Cart
          </button>
        </div>
      </div>
    </div>
  );
};

const Cart = ({ cartItems, removeFromCart }) => {
  const totalPrice = cartItems.reduce((acc, item) => acc + item.price, 0);

  return (
    <div className="container">
      <h2>Your Cart</h2>
      {cartItems.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <>
          <ul className="list-group mb-3">
            {cartItems.map((item, idx) => (
              <li
                key={idx}
                className="list-group-item d-flex justify-content-between align-items-center"
              >
                {item.name} - ${item.price.toFixed(2)}
                <button
                  className="btn btn-sm btn-danger"
                  onClick={() => removeFromCart(idx)}
                >
                  Remove
                </button>
              </li>
            ))}
          </ul>
          <h4>Total: ${totalPrice.toFixed(2)}</h4>
          <Link to="/checkout" className="btn btn-primary">
            Proceed to Checkout
          </Link>
        </>
      )}
    </div>
  );
};

const Checkout = ({ cartItems, clearCart }) => {
  const [orderPlaced, setOrderPlaced] = useState(false);

  const handlePlaceOrder = () => {
    setOrderPlaced(true);
    clearCart();
  };

  if (cartItems.length === 0 && !orderPlaced)
    return (
      <div className="container">
        <h2>Checkout</h2>
        <p>Your cart is empty. Please add items before checkout.</p>
        <Link to="/products" className="btn btn-primary">
          Browse Products
        </Link>
      </div>
    );

  return (
    <div className="container">
      <h2>Checkout</h2>
      {orderPlaced ? (
        <div className="alert alert-success" role="alert">
          Thank you for your purchase! Your order has been placed.
        </div>
      ) : (
        <>
          <h4>Order Summary:</h4>
          <ul className="list-group mb-3">
            {cartItems.map((item, idx) => (
              <li key={idx} className="list-group-item">
                {item.name} - ${item.price.toFixed(2)}
              </li>
            ))}
          </ul>
          <button className="btn btn-success" onClick={handlePlaceOrder}>
            Place Order
          </button>
        </>
      )}
    </div>
  );
};

const NotFound = () => (
  <div className="container text-center">
    <h2>404 - Page Not Found</h2>
    <p>The page you are looking for does not exist.</p>
    <Link to="/" className="btn btn-primary">
      Go Home
    </Link>
  </div>
);

export default function JewelleryShop() {
  const [cartItems, setCartItems] = useState([]);

  const addToCart = (product) => setCartItems((prev) => [...prev, product]);
  const removeFromCart = (index) =>
    setCartItems((prev) => prev.filter((_, i) => i !== index));
  const clearCart = () => setCartItems([]);

  return (
    <Router>
      <Navbar />
      <FadeTransition>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<Products />} />
          <Route
            path="/products/:productId"
            element={<ProductDetails addToCart={addToCart} />}
          />
          <Route
            path="/cart"
            element={
              <Cart cartItems={cartItems} removeFromCart={removeFromCart} />
            }
          />
          <Route
            path="/checkout"
            element={<Checkout cartItems={cartItems} clearCart={clearCart} />}
          />
          <Route path="/404" element={<NotFound />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </FadeTransition>
    </Router>
  );
}
