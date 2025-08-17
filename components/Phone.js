import React, { useState } from 'react';

const Phone = () => {
  // Initial state
  const [phone, setPhone] = useState({
    brand: 'Apple',
    model: 'iPhone 15',
    price: 79999,
  });

  // Function to increase price by a fixed amount (e.g., 1000)
  const increasePrice = () => {
    setPhone(prevPhone => ({
      ...prevPhone,
      price: prevPhone.price + 1000,
    }));
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h2>📱 Phone Details</h2>
      <p><strong>Brand:</strong> {phone.brand}</p>
      <p><strong>Model:</strong> {phone.model}</p>
      <p><strong>Price:</strong> ₹{phone.price}</p>
      <button 
        onClick={increasePrice} 
        style={{
          backgroundColor: '#007bff',
          color: 'white',
          border: 'none',
          padding: '10px 25px',
          borderRadius: '5px',
          fontSize: '16px',
          cursor: 'pointer',
          marginTop: '15px',
        }}
      >
        Increase Price
      </button>
    </div>
  );
};

export default Phone;
