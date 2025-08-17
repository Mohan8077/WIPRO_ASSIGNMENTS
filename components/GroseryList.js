import React from 'react';

const GroceryList = ({ items }) => {
  const handleAddToCart = () => {
    alert("Groceries Added to Cart!");
  };

  return (
    <div style={{ textAlign: 'center' }}>
      <h2>Groceries List:</h2>
      <ul style={{ listStyleType: 'disc', paddingLeft: '20px', display: 'inline-block', textAlign: 'left' }}>
        {items.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
      <br />
      <button onClick={handleAddToCart}>Add to Cart</button>
    </div>
  );
};

export default GroceryList;
