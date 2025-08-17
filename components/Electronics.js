import React, { useState } from 'react';

const Electronics = () => {
  // Separate states for each property
  const [name] = useState('Laptop');
  const [brand, setBrand] = useState('Dell');
  const [price, setPrice] = useState(5500);

  // Handler to change brand (example changes to 'HP')
  const changeBrand = () => {
    setBrand('HP');
  };

  // Handler to increase price by 500
  const increasePrice = () => {
    setPrice(prevPrice => prevPrice + 500);
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h2>🔌 Electronic Item Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Brand:</strong> {brand}</p>
      <p><strong>Price:</strong> ₹{price}</p>
      <button
        onClick={changeBrand}
        style={{
          marginRight: '10px',
          padding: '8px 15px',
          fontSize: '14px',
          cursor: 'pointer'
        }}
      >
        Change Brand
      </button>
      <button
        onClick={increasePrice}
        style={{
          padding: '8px 15px',
          fontSize: '14px',
          cursor: 'pointer',
          backgroundColor: '#007bff',
          color: 'white',
          border: 'none',
          borderRadius: '4px',
        }}
      >
        Increase Price
      </button>
    </div>
  );
};

export default Electronics;
